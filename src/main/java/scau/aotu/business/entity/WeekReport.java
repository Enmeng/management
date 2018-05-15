package scau.aotu.business.entity;

import scau.aotu.base.dao.annotation.Table;
import scau.aotu.base.dao.entity.Unique;

import java.util.Date;

/**
 * Created by AutoSSM.
 */
@Table(name = "tomato_week_report")
public class WeekReport extends Unique {
    private String userId;

    private String reportTitle;

    private Integer number;

    private Date createTime;

    private String reportContent;

    private String remark;

    private Enum reportStatus;

    private String projectId;

    public WeekReport() {
    }

    public WeekReport(String userId, String reportTitle, Integer number, Date createTime, String reportContent, String remark, Enum reportStatus, String projectId) {
        this.userId = userId;
        this.reportTitle = reportTitle;
        this.number = number;
        this.createTime = createTime;
        this.reportContent = reportContent;
        this.remark = remark;
        this.reportStatus = reportStatus;
        this.projectId = projectId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Enum getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(Enum reportStatus) {
        this.reportStatus = reportStatus;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }


}
