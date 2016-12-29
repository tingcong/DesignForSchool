package com.bean;

import java.util.Date;

/**
 * Created by 胡廷聪 on 2016/12/23.
 */
public class ChooseCourseInfo {
    private Integer id;
    private String courseId;
    private Integer stuNo;
    private java.util.Date chooseDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Integer getStuNo() {
        return stuNo;
    }

    public void setStuNo(Integer stuNo) {
        this.stuNo = stuNo;
    }

    public Date getChooseDate() {
        return chooseDate;
    }

    public void setChooseDate(Date chooseDate) {
        this.chooseDate = chooseDate;
    }
}
