package scau.aotu.base.dao.mybatis;

import scau.aotu.base.utils.CharacterFilterUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lishunpeng on 2015/10/24.
 */
public class Conditions {
    private StringBuilder whereConditions;
    private int pageSize;
    private int orderByCount;
    private boolean whereFlag;
    private boolean orderByFlag;
    private List<String> propertyList;

    public Conditions() {
        pageSize = 10;
        orderByCount = 0;
        whereFlag = false;
        orderByFlag = false;
        whereConditions = new StringBuilder();
        propertyList = new ArrayList<>();
    }

    /**
     * 等于"="比较符
     */
    public Conditions equal(String propertyName, Object value) {
        addWhere();
        whereConditions.append("@"+propertyList.size() + " = " + filter(value));
        propertyList.add(propertyName.trim());
        return this;
    }

    /**
     * 模糊"like"比较符
     */
    public Conditions like(String propertyName, Object value) {
        addWhere();
        whereConditions.append("@"+propertyList.size() + " like " + filter("%" + value + "%"));
        propertyList.add(propertyName.trim());
        return this;
    }

    /**
     * 不等于"<>"比较符
     */
    public Conditions notEqual(String propertyName, Object value) {
        addWhere();
        whereConditions.append("@"+propertyList.size() + " <> " + filter(value));
        propertyList.add(propertyName.trim());
        return this;
    }

    /**
     * 大于">"比较符
     */
    public Conditions greaterThan(String propertyName, Object value) {
        addWhere();
        whereConditions.append("@"+propertyList.size() + " > " + filter(value));
        propertyList.add(propertyName.trim());
        return this;
    }

    /**
     * 小于"<"比较符
     */
    public Conditions lessThan(String propertyName, Object value) {
        addWhere();
        whereConditions.append("@"+propertyList.size() + " < " + filter(value));
        propertyList.add(propertyName.trim());
        return this;
    }

    /**
     * 小于等于"<="比较符
     */
    public Conditions lessEqual(String propertyName, Object value) {
        addWhere();
        whereConditions.append("@"+propertyList.size() + " <= " + filter(value));
        propertyList.add(propertyName.trim());
        return this;
    }

    /**
     * 大于等于">="比较符
     */
    public Conditions greaterEqual(String propertyName, Object value) {
        addWhere();
        whereConditions.append("@"+propertyList.size() + " >= " + filter(value));
        propertyList.add(propertyName.trim());
        return this;
    }

    /**
     * 间隔"between"比较符
     */
    public Conditions betweenAnd(String propertyName, Object low, Object high) {
        addWhere();
        whereConditions.append("@"+propertyList.size() + " between " + filter(low) + " and " + filter(high));
        propertyList.add(propertyName.trim());
        return this;
    }

    /**
     * 空 "is null"比较符
     */
    public Conditions isNull(String propertyName) {
        addWhere();
        whereConditions.append("@"+propertyList.size() + " is null ");
        propertyList.add(propertyName.trim());
        return this;
    }

    /**
     * 非空"is not null"比较符
     */
    public Conditions isNotNull(String propertyName) {
        addWhere();
        whereConditions.append("@"+propertyList.size() + " is not null ");
        propertyList.add(propertyName.trim());
        return this;
    }

    /**
     * limit分页符
     */
    public Conditions limit(int limit) {
        this.pageSize = limit;
        whereConditions.append(" LIMIT " + limit);
        return this;
    }

    /**
     * limit分页符
     */
    public Conditions limit(int start, int limit) {
        this.pageSize = limit;
        whereConditions.append(" LIMIT " + start + " , " + limit);
        return this;
    }

    /**
     * in操作符
     */
    public Conditions in(String propertyName, Object... keys) {
        addWhere();
        StringBuilder fragment = new StringBuilder();
        if (keys != null && keys.length > 0) {

            fragment.append("@"+propertyList.size() + " in (");
            propertyList.add(propertyName.trim());

            int len = keys.length - 1;
            for (int i = 0; i < len; i++) {
                fragment.append(filter(keys[i]) + ",");
            }
            fragment.append(filter(keys[len]));
            fragment.append(")");
        }
        whereConditions.append(fragment.toString());
        return this;
    }

    /**
     * 左括号(
     */
    public Conditions leftBracket() {
        whereConditions.append(" ( ");
        return this;
    }

    /**
     * 右括号(
     */
    public Conditions rightBracket() {
        whereConditions.append(" ) ");
        return this;
    }

    /**
     * 与"And"逻辑操作符
     */
    public Conditions and() {
        whereConditions.append(" AND ");
        return this;
    }

    /**
     * 与"Or"逻辑操作符
     */
    public Conditions or() {
        whereConditions.append(" OR ");
        return this;
    }

    /**
     * ASC 逻辑操作符
     */
    public Conditions asc(String... propertyNames) {
        return orderBy("ASC", propertyNames);
    }


    /**
     * DESC 逻辑操作符
     * ORDER BY 语句默认按照升序对记录进行排序。
     * 按照降序对记录进行排序，可以使用 DESC 关键字。
     */
    public Conditions desc(String... propertyNames) {
        return orderBy("DESC", propertyNames);
    }

    private Conditions orderBy(String type, String... propertyNames) {
        if (propertyNames != null && propertyNames.length > 0) {
            addOrderBy();

            if (orderByCount > 0) {
                whereConditions.append(" , ");
            }

            int len = propertyNames.length - 1;
            for (int i = 0; i < len; i++) {
                whereConditions.append("@" + propertyList.size() + ", ");
                propertyList.add(propertyNames[i].trim());
            }
            whereConditions.append("@" + propertyList.size() + " " + type + " ");
            propertyList.add(propertyNames[len].trim());
            orderByCount++;
        }
        return this;
    }

    private void addWhere() {
        if (!whereFlag) {
            whereConditions.append(" WHERE ");
            whereFlag = true;
        }
    }

    private void addOrderBy() {
        if (!orderByFlag) {
            whereConditions.append(" ORDER BY ");
            orderByFlag = true;
        }
    }

    public String toWhereSQL() {
        return whereConditions.toString();
    }

    /**
     * 去除最后的" AND "和" OR "
     */
    public String toTrimWhereSQL() {
        String sql = toWhereSQL();
        if (toWhereSQL().endsWith(" AND ")) {
            sql = sql.substring(0, sql.lastIndexOf(" AND "));
        } else if (toWhereSQL().endsWith(" OR ")) {
            sql = sql.substring(0, sql.lastIndexOf(" OR "));
        }
        return sql;
    }

    public List<String> getPropertyList(){
        return this.propertyList;
    }

    public int getPageSize() {
        return pageSize;
    }

    private static Object filter(Object value) {
        if (value instanceof String || value instanceof Date) {
            return CharacterFilterUtil.filter(value.toString());
        }
        return value;
    }


}
