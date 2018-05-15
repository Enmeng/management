package scau.aotu.business.entity;

import scau.aotu.base.dao.annotation.Table;
import scau.aotu.base.dao.entity.Unique;

import java.util.Date;

/**
 * Created by AutoSSM.
 */
@Table(name = "tomato_user_resume")
public class UserResume extends Unique {
    private String userId;

    private String resumePath;

    public UserResume() {
    }

    public UserResume(String userId, String resumePath) {
        this.userId = userId;
        this.resumePath = resumePath;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getResumePath() {
        return resumePath;
    }

    public void setResumePath(String resumePath) {
        this.resumePath = resumePath;
    }


}
