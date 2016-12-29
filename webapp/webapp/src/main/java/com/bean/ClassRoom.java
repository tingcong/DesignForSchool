package com.bean;

import javax.persistence.Table;

/**
 * Created by 胡廷聪 on 2016/12/14.
 */
@Table(name = "class_root")
public class ClassRoom {
    private Integer id;
    private String roomNo;
    private String status;
    private String courseId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}
