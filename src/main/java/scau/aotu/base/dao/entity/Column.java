package scau.aotu.base.dao.entity;

import scau.aotu.base.dao.constant.ColumnType;

/**
 * Created by lsp on 23/11/2016.
 * <p>
 * 记录字段信息
 */
public class Column {
    private String name; //字段名
    private Object value; //字段值
    private ColumnType type; //字段类型

    public Column(String name, Object value, ColumnType type) {
        this.name = name;
        this.value = value;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    public ColumnType getType() {
        return type;
    }
}
