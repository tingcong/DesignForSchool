package com.mapper;

import com.bean.ClassRoom;

import java.util.List;

/**
 * Created by zy on 2016/12/14.
 */
public interface ClassRoomMapper  {
    Integer insertClassRoom(ClassRoom classRoomParam);
    Integer updateClassRoomStatus(ClassRoom classRoomParam);
    Integer updateClassRoomCourse(ClassRoom classRoomParam);
    ClassRoom selectClassRoomByRoomNo(ClassRoom classRoomParam);
    List<ClassRoom> selectAllClassRoom();
    List<ClassRoom> findRoomByCourseId(String courseId);
}
