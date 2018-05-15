package scau.aotu.business.entity;

import scau.aotu.base.dao.annotation.Table;
import scau.aotu.base.dao.entity.Unique;

import java.util.Date;

/**
 * Created by AutoSSM.
 */
@Table(name = "tomato_task")
public class Task extends Unique {
    private String taskTitle;

    private String taskContent;

    private String username;

    private Enum taskStatus;

    private Date createTime;

    public Task() {
    }

    public Task(String taskTitle, String taskContent, String username, Enum taskStatus, Date createTime) {
        this.taskTitle = taskTitle;
        this.taskContent = taskContent;
        this.username = username;
        this.taskStatus = taskStatus;
        this.createTime = createTime;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Enum getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Enum taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


}
