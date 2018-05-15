package scau.aotu.base.dao.entity;

import java.io.Serializable;

/**
 * Created by lishunpeng on 2015/10/24.
 * <p>
 * 所有entity都需要扩展的抽象类
 * <p>
 * 用于定义统一的主键
 */
public abstract class Unique implements Serializable {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
