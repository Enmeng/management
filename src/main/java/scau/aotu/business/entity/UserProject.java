package scau.aotu.business.entity;

import scau.aotu.base.dao.annotation.Table;
import scau.aotu.base.dao.entity.Unique;

import java.util.Date;

/**
 * Created by AutoSSM.
 */
@Table(name = "tomato_user_project")
public class UserProject extends Unique {
    private String userId;

    private String projectId;

    private Enum userProjectStatus;

    public UserProject() {
    }

    public UserProject(String userId, String projectId, Enum userProjectStatus) {
        this.userId = userId;
        this.projectId = projectId;
        this.userProjectStatus = userProjectStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Enum getUserProjectStatus() {
        return userProjectStatus;
    }

    public void setUserProjectStatus(Enum userProjectStatus) {
        this.userProjectStatus = userProjectStatus;
    }


}
