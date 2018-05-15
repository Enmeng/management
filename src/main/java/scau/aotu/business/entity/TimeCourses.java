package scau.aotu.business.entity;

import scau.aotu.base.dao.annotation.Table;import scau.aotu.base.dao.entity.Unique;

import java.util.Date;

/**
 * Created by AutoSSM.
 */
@Table(name = "tomato_time_courses")
public class TimeCourses extends Unique {

    private String courseName;

    private String place;

    private Integer startWeek;

    private Integer endWeek;

    private Integer weekday;

    private String time;

    private Integer period;

    public TimeCourses() {
    }

    public TimeCourses(String courseName, String place, Integer startWeek, Integer endWeek, Integer weekday, String time, Integer period) {
        this.courseName = courseName;
        this.place = place;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
        this.weekday = weekday;
        this.time = time;
        this.period = period;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getStartWeek() {
        return startWeek;
    }

    public void setStartWeek(Integer startWeek) {
        this.startWeek = startWeek;
    }

    public Integer getEndWeek() {
        return endWeek;
    }

    public void setEndWeek(Integer endWeek) {
        this.endWeek = endWeek;
    }

    public Integer getWeekday() {
        return weekday;
    }

    public void setWeekday(Integer weekday) {
        this.weekday = weekday;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }


}
