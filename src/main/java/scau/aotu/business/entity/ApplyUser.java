package scau.aotu.business.entity;

import scau.aotu.base.dao.annotation.Table;
import scau.aotu.base.dao.entity.Unique;

import java.util.Date;

/**
 * Created by AutoSSM.
 */
@Table(name = "tomato_apply_user")
public class ApplyUser extends Unique {
    private String projectId;

    private String userId;

    private String statement;

    private Date createTime;

    private String team;

    public ApplyUser() {
    }

    public ApplyUser(String projectId, String userId, String statement, Date createTime, String team) {
        this.projectId = projectId;
        this.userId = userId;
        this.statement = statement;
        this.createTime = createTime;
        this.team = team;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }


}
