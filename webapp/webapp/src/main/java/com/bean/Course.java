package com.bean;

/**
 * Created by 胡廷聪 on 2016/12/14.
 */
public class Course {
    private Integer id;
    private String courseId;
    private String courseName;
    private int stuNum;
    private String courseTime;
    private Boolean multimedia;
    //任课老师的工号
    private int teachNo;

    public int getTeachNo() {
        return teachNo;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getStuNum() {
        return stuNum;
    }

    public void setStuNum(int stuNum) {
        this.stuNum = stuNum;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public Boolean getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(Boolean multimedia) {
        this.multimedia = multimedia;
    }

    public int setTeachNo() {
        return teachNo;
    }

    public void setTeachNo(int teachNo) {
        this.teachNo = teachNo;
    }
}