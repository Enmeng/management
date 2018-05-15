package scau.aotu.base.dao.utils;

import scau.aotu.base.dao.annotation.Column;
import scau.aotu.base.dao.annotation.Transmit;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lsp on 23/11/2016.
 * <p>
 * 类工具类
 */
public class ClazzUtil {

    //保存类属性对应的Field对象信息
    private static final Map<String, Field> propertyFieldCache = new ConcurrentHashMap<>();
    //保存类属性名和表字段名信息
    private static final Map<String, String> propertyColumnCache = new ConcurrentHashMap<>();

    /**
     * 根据参数类找出实参的范型类型
     *
     * @param clazz
     * @return
     */
    public static Class<?> getGenericClass(Class<?> clazz) {
        Type t = clazz.getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            Type[] p = ((ParameterizedType) t).getActualTypeArguments();
            return ((Class<?>) p[0]);
        }
        return null;
    }

    /**
     * 该方法将实体类的属性缓存到propertyFieldCache，将字段名缓存到propertyColumnCache
     *
     * 【键值对的格式】
     * "类全路径名_属性名" = java.lang.reflect.Field（包含该属性信息的Field对象）
     * "类全路径名_属性名" = "字段名"
     *
     * 【举个例子】
     * "scau.cyl.entity.Person_userName" = java.lang.reflect.Field
     * "scau.cyl.entity.Person_userName" = "user_name"
     *
     */
    public static void cacheFieldInfo(Class<?> clazz){
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();//获取实体对应的属性的描述符

            for(PropertyDescriptor  pd : pds){
                Method method = pd.getReadMethod(); //获取getter方法
                if (method == null || pd.getWriteMethod() == null) { //忽略没有getter和setter方法的属性，必须要同时有
                    continue;
                }

                Field field = getField(clazz, pd.getName()); //找到对应属性的Field对象
                Transmit transmit = field.getAnnotation(Transmit.class);
                if (null != transmit) {// 忽略 由注解Transmit标注的字段
                    continue;
                }

                //开始获取表字段名
                String columnName = "";
                Column column = field.getAnnotation(Column.class);
                if (column == null) {//没有被注解Column 标注，默认把字段名由驼峰命名法转为下划线命名法
                    columnName = NameUtil.camelToUnderline(field.getName());
                } else {//如果有标注，直接采用标注的名称
                    columnName = column.name();
                }

                String key = clazz.getName() + "_" + pd.getName();

                propertyFieldCache.put(key, field);//本地缓存
                propertyColumnCache.put(key, columnName);//本地缓存
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 本地缓存，用于获取已经获取过字段信息的字段信息
     *
     * @param clazz
     * @param fieldName
     * @return
     * @throws Exception
     */
    private static Field getField(Class<?> clazz, String fieldName) throws Exception {
        Field field = null;
        try {
            field = clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            Class<?> cls = clazz.getSuperclass();
            if (cls != null) {
                while (true) {
                    if (cls == null) {
                        break;
                    }
                    try {
                        field = cls.getDeclaredField(fieldName);
                        break;
                    } catch (NoSuchFieldException ex) {
                        cls = cls.getSuperclass();
                    }
                }
            }
        }
        if (field == null) {
            throw new NoSuchFieldException();
        }

        return field;
    }

    public static List<Field> getFieldsFromCache(Class clazz){
        List<Field> fieldList = new ArrayList<>();
        for(Map.Entry<String, Field> entry : propertyFieldCache.entrySet()){
            if(entry.getKey().startsWith(clazz.getName())){
                fieldList.add(entry.getValue());
            }
        }
        return fieldList;
    }

    public static String getColumnNameFromCache(String key){
        return propertyColumnCache.get(key);
    }
}