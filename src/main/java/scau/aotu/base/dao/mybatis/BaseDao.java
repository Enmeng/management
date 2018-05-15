package scau.aotu.base.dao.mybatis;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import scau.aotu.base.dao.annotation.Table;
import scau.aotu.base.dao.constant.ColumnType;
import scau.aotu.base.dao.entity.Column;
import scau.aotu.base.dao.entity.SQLAdapter;
import scau.aotu.base.dao.entity.Unique;
import scau.aotu.base.dao.utils.ClazzUtil;
import scau.aotu.base.dao.utils.Generator;
import scau.aotu.base.dao.utils.NameUtil;
import scau.aotu.base.exception.BaseException;
import scau.aotu.base.exception.ERROR;
import scau.aotu.base.utils.CharacterFilterUtil;
import scau.aotu.base.utils.DateUtil;
import scau.aotu.base.utils.StringUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 通用MyBatisDao
 *
 * @param <T>
 */
public class BaseDao<T extends Unique> extends SqlSessionDaoSupport implements IBaseDao<T> {

    public static final String SQLNAME_SEPARATOR = ".";

    protected String namespace;
    protected Class<?> entityClass;

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    /**
     * 获取T的真实类型
     */
    public BaseDao() {
        entityClass = ClazzUtil.getGenericClass(getClass());
        ClazzUtil.cacheFieldInfo(entityClass);
    }

    @Override
    public String add(T entity) throws BaseException {
        if (entity == null) {
            throw new BaseException("实体对象不允许为空", ERROR.ERROR_NULLPOINTER);
        }
        if (StringUtil.isEmpty(entity.getId())) {
            entity.setId(Generator.INSTANCE.generateId());
        }
        StringBuilder builder = new StringBuilder();
        try {
            builder.append("INSERT INTO ")
                    .append(getTableName(entity.getClass())).append(" SET ")
                    .append(createQLByColumns(entity));

            getSqlSession().insert(getMapperId("add"), new SQLAdapter(builder.toString()));
        } catch (Exception e) {
            throw new BaseException(e, ERROR.ERROR_STORE_ERROR);
        }
        return entity.getId();
    }

    @Override
    public void update(T entity, Conditions conditions) throws BaseException {
        String fragment = "";
        if (conditions != null) {
            fragment = handleConditionsSQL(entityClass, conditions);
        }
        StringBuilder builder = new StringBuilder();
        try {
            builder.append("UPDATE ")
                    .append(getTableName(entity.getClass()))
                    .append(" SET ")
                    .append(createQLByColumns(entity))
                    .append(fragment);

            getSqlSession().update(getMapperId("update"), new SQLAdapter(builder.toString()));
        } catch (Exception e) {
            throw new BaseException(e, ERROR.ERROR_STORE_ERROR);
        }
    }

    @Override
    public void delete(Conditions conditions) throws BaseException {
        String fragment = "";
        if (conditions != null) {
            fragment = handleConditionsSQL(entityClass, conditions);
        }
        StringBuilder builder = new StringBuilder();
        try {
            builder.append("DELETE FROM ")
                    .append(getTableName(entityClass))
                    .append(fragment);

            getSqlSession().delete(getMapperId("delete"), new SQLAdapter(builder.toString()));
        } catch (Exception e) {
            throw new BaseException(e, ERROR.ERROR_STORE_ERROR);
        }
    }

    @Override
    public <V> V get(Conditions conditions, String... propertyName) throws BaseException {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT ");
        builder.append(getPropertyProject(propertyName));

        String fragment = "";
        if (conditions != null) {
            fragment = handleConditionsSQL(entityClass, conditions);
        }

        builder.append(" FROM ")
                .append(getTableName((entityClass)))
                .append(fragment);

        try {
            return getSqlSession().selectOne(getMapperId("get"), new SQLAdapter(builder.toString()));
        } catch (Exception e) {
            throw new BaseException(e, ERROR.ERROR_STORE_ERROR);
        }
    }

    @Override
    public long count(Conditions conditions) throws BaseException {
        StringBuilder builder = new StringBuilder();
        String fragment = "";
        if (conditions != null) {
            fragment = handleConditionsSQL(entityClass, conditions);
        }
        builder.append("SELECT COUNT(*) ");
        builder.append(" FROM ")
                .append(getTableName((entityClass)))
                .append(fragment);
        try {
            Object value = getSqlSession().selectOne(getMapperId("count"), new SQLAdapter(builder.toString()));
            if (value instanceof Long) {
                return (Long) value;
            }
            return 0;
        } catch (Exception e) {
            throw new BaseException(e, ERROR.ERROR_STORE_ERROR);
        }
    }

    @Override
    public <V> List<V> list(Conditions conditions, String... propertyName) throws BaseException {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT ");
        builder.append(getPropertyProject(propertyName));

        String fragment = "";
        if (conditions != null) {
            fragment = handleConditionsSQL(entityClass, conditions);
        }

        builder.append(" FROM ")
                .append(getTableName((entityClass)))
                .append(fragment);
        try {
            return getSqlSession().selectList(getMapperId("list"), new SQLAdapter(builder.toString()));
        } catch (Exception e) {
            throw new BaseException(e, ERROR.ERROR_STORE_ERROR);
        }
    }

    @Override
    public void executeUpdate(String methodId, String sql) throws BaseException {
        try {
            getSqlSession().update(getMapperId(methodId), new SQLAdapter(sql));
        } catch (Exception e) {
            throw new BaseException(e, ERROR.ERROR_STORE_ERROR);
        }
    }

    @Override
    public <V> List<V> executeList(String methodId, String sql) throws BaseException {
        try {
            return getSqlSession().selectList(getMapperId(methodId), new SQLAdapter(sql));
        } catch (Exception e) {
            throw new BaseException(e, ERROR.ERROR_STORE_ERROR);
        }
    }

    protected String getTableName(Class<?> entityClass) {
        Table table = entityClass.getAnnotation(Table.class);
        if (null == table) {//如果没有Table注解标注，直接转换类名为下划线命名法
            return NameUtil.capitalizeCamelToUnderline(entityClass.getSimpleName());
        }
        //如果有Table标注，返回标注指定的名字
        return table.name();
    }

    /**
     * 用于构造SQL语句<br/>
     * 内容为property_name='value' or property_name=number
     */
    protected String createQLByColumns(T entity) throws Exception {
        List<Column> columns = getColumns(entityClass, entity);
        if (columns.size() != 0) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < columns.size(); i++) {
                ColumnType type = columns.get(i).getType();
                builder.append(columns.get(i).getName()).append("=");
                if (ColumnType.STRING.equals(type) || ColumnType.DATE.equals(type)) {
                    //如果是字符串或者时间类型，需要进行字符过滤
                    builder.append(CharacterFilterUtil.filter(columns.get(i).getValue().toString()));
                } else {
                    builder.append(columns.get(i).getValue());
                }
                builder.append(",");
            }
            // 去除最后一个","号
            builder.deleteCharAt(builder.length() - 1);
            return builder.toString();
        }
        return "";
    }


    /**
     * 将SQL Mapping命名空间与给定的id名组合在一起。
     *
     * @param methodId 方法名
     * @return 组合了SqlMapping命名空间后的完整SqlMapping名
     */
    protected String getMapperId(String methodId) {
        return getDefaultNamespace() + SQLNAME_SEPARATOR + methodId;
    }

    protected String getDefaultNamespace() {
        if (StringUtil.isNotEmpty(namespace)) {
            return namespace;
        }
        namespace = this.getClass().getName();
        return namespace;
    }

    protected String getPropertyProject(String... propertyName) {
        if (propertyName == null || propertyName.length < 1) {
            return " * ";
        }
        StringBuilder builder = new StringBuilder();
        int len = propertyName.length - 1;
        for (int i = 0; i < len; i++) {
            builder.append(propertyName[i] + ",");
        }
        builder.append(propertyName[len]);
        return builder.toString();
    }

    public static String handleConditionsSQL(Class clazz, Conditions conditions) throws BaseException{
        String whereSQL = conditions.toWhereSQL();
        List<String> propertyList = conditions.getPropertyList();
        for(int i = 0; i < propertyList.size(); i++){
            String key = clazz.getName() + "_" + propertyList.get(i);
            String columnName = ClazzUtil.getColumnNameFromCache(key);
            if(null == columnName){
                throw new BaseException(ERROR.ERROR_NO_SUCH_FIELD);
            }
            whereSQL = whereSQL.replaceFirst("@"+i, columnName);
        }
        return whereSQL;
    }

    /**
     * 获取指定类的可用属性所对应的字段信息
     * <p>
     * 默认所有属性都要持久化到数据库，除非满足忽略规则
     * <p>
     * 忽略规则说明：
     * 1。没有getter和setter的字段，只有一种也不行
     * 2。实例obj中属性值为空
     * 3。被Transmit注解标注的属性
     *
     * @param clazz
     * @param obj
     * @return
     * @throws Exception
     */
    protected List<Column> getColumns(Class clazz, Object obj) throws Exception {
        List<Column> result = new ArrayList<>();

        List<Field> fieldList = ClazzUtil.getFieldsFromCache(clazz);
        for (Field field : fieldList) {

            field.setAccessible(true);
            Object value = field.get(obj);//调用getter方法
            if (value == null) {//忽略 值为空的 字段
                continue;
            }

            String key = clazz.getName() + "_" + field.getName();
            String columnName = ClazzUtil.getColumnNameFromCache(key);

            //开始获取字段类型，目前只支持字符串／日期／其他（数值类型）
            String type = field.getGenericType().toString();
            // 如果属性是String类型
            if ("class java.lang.String".equals(type)) {
                result.add(new Column(columnName, value, ColumnType.STRING));
            } else if ("class java.util.Date".equals(type)) {// 如果属性是Date类型
                result.add(new Column(columnName, DateUtil.getSimpleDate((Date) value), ColumnType.DATE));
            } else {// 如果属性是其他类型
                result.add(new Column(columnName, value, ColumnType.OTHER));
            }
        }
        return result;
    }
}
