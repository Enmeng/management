package scau.aotu.business.entity;

import scau.aotu.base.dao.annotation.Table;
import scau.aotu.base.dao.entity.Unique;

import java.util.Date;

/**
 * Created by AutoSSM.
 */
@Table(name = "tomato_project_apply")
public class ProjectApply extends Unique {
    private String projectId;

    private String userId;

    private Enum userProjectStatus;

    public ProjectApply() {
    }

    public ProjectApply(String projectId, String userId, Enum userProjectStatus) {
        this.projectId = projectId;
        this.userId = userId;
        this.userProjectStatus = userProjectStatus;
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

    public Enum getUserProjectStatus() {
        return userProjectStatus;
    }

    public void setUserProjectStatus(Enum userProjectStatus) {
        this.userProjectStatus = userProjectStatus;
    }


}
