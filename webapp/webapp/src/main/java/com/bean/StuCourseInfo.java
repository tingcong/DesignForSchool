package com.bean;

/**
 * Created by 聪 on 2016/12/27.
 */
public class StuCourseInfo {
    private String courseId;
    private String courseName;
    private String teachName;
    private String roomNo;


    public StuCourseInfo(String courseId, String courseName, String teachName, String roomNo) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.teachName = teachName;
        this.roomNo = roomNo;
    }

    public String getCourseId(String courseId) {
        return this.courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeachName() {
        return teachName;
    }

    public void setTeachName(String teachName) {
        this.teachName = teachName;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }
}
