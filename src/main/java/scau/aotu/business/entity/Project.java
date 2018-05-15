package scau.aotu.business.entity;

import scau.aotu.base.dao.annotation.Table;
import scau.aotu.base.dao.entity.Unique;

import java.util.Date;

/**
 * Created by AutoSSM.
 */
@Table(name = "tomato_project")
public class Project extends Unique {
    private String userId;

    private Date createTime;

    private String projectTitle;

    private String projectContent;

    private Integer applyCount;

    private Enum projectStatus;

    private String chargeUser;

    private String postArrange;

    public Project() {
    }

    public Project(String userId, Date createTime, String projectTitle, String projectContent, Integer applyCount, Enum projectStatus, String chargeUser, String postArrange) {
        this.userId = userId;
        this.createTime = createTime;
        this.projectTitle = projectTitle;
        this.projectContent = projectContent;
        this.applyCount = applyCount;
        this.projectStatus = projectStatus;
        this.chargeUser = chargeUser;
        this.postArrange = postArrange;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getProjectContent() {
        return projectContent;
    }

    public void setProjectContent(String projectContent) {
        this.projectContent = projectContent;
    }

    public Integer getApplyCount() {
        return applyCount;
    }

    public void setApplyCount(Integer applyCount) {
        this.applyCount = applyCount;
    }

    public Enum getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(Enum projectStatus) {
        this.projectStatus = projectStatus;
    }

    public String getChargeUser() {
        return chargeUser;
    }

    public void setChargeUser(String chargeUser) {
        this.chargeUser = chargeUser;
    }

    public String getPostArrange() {
        return postArrange;
    }

    public void setPostArrange(String postArrange) {
        this.postArrange = postArrange;
    }


}
