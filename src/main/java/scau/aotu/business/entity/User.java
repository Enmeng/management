package scau.aotu.business.entity;

import scau.aotu.base.dao.annotation.Table;
import scau.aotu.base.dao.entity.Unique;
import java.util.Date;

/**
 * Created by AutoSSM.
 */
@Table(name = "tomato_user")
public class User extends Unique {

    private String username;

    private String number;

    private String password;

    private Date createTime;

    private Integer role;

    private Integer usable;

    private String nickname;

    private Integer gender;

    private String phoneNumber;

    private String email;

    private String qq;

    private String wechat;

    private String academy;

    private String major;

    private String clazz;

    private String enterYear;

    private String bornPlace;

    private Date birthday;

    private String dormitory;

    private String profession;

    private String avatar;

    public User() {
    }

    public User(String username, String number, String password, Date createTime, Integer role, Integer usable, String nickname, Integer gender, String phoneNumber, String email, String qq, String wechat, String academy, String major, String clazz, String enterYear, String bornPlace, Date birthday, String dormitory, String profession, String avatar) {
        this.username = username;
        this.number = number;
        this.password = password;
        this.createTime = createTime;
        this.role = role;
        this.usable = usable;
        this.nickname = nickname;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.qq = qq;
        this.wechat = wechat;
        this.academy = academy;
        this.major = major;
        this.clazz = clazz;
        this.enterYear = enterYear;
        this.bornPlace = bornPlace;
        this.birthday = birthday;
        this.dormitory = dormitory;
        this.profession = profession;
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getUsable() {
        return usable;
    }

    public void setUsable(Integer usable) {
        this.usable = usable;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getEnterYear() {
        return enterYear;
    }

    public void setEnterYear(String enterYear) {
        this.enterYear = enterYear;
    }

    public String getBornPlace() {
        return bornPlace;
    }

    public void setBornPlace(String bornPlace) {
        this.bornPlace = bornPlace;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDormitory() {
        return dormitory;
    }

    public void setDormitory(String dormitory) {
        this.dormitory = dormitory;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
