package scau.aotu.base.dao.entity;

import java.io.Serializable;

/**
 * Created by lishunpeng on 2015/10/24.
 * <p>
 * SQL语句适配器
 * <p>
 * 封装SQL语句，供MyBatis使用，提供通用的增删差改
 */
public class SQLAdapter implements Serializable {

    private String sql;

    public SQLAdapter() {

    }

    public SQLAdapter(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
