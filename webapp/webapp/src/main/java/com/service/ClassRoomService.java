package com.service;

import com.bean.ClassRoom;
import com.mapper.ClassRoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zy on 2016/12/23.
 */
@Service
@Transactional
public class ClassRoomService {
    @Autowired
    private ClassRoomMapper classRoomMapper;

      //开启事务，可以使用或者try{}catch(exception e){throw new runtimeException(e)}来捕获并回滚
    public Integer insertClassRoom(ClassRoom classRoomParam){
        if (classRoomMapper.selectClassRoomByRoomNo(classRoomParam) == null) {
            return classRoomMapper.insertClassRoom(classRoomParam);/**/
        } else {
            throw new RuntimeException("重复添加！");
        }
    }

    public Integer updateClassRoomStatus(ClassRoom classRoomParam){
        return classRoomMapper.updateClassRoomStatus(classRoomParam);
    }
    public Integer updateClassRoomCourse(ClassRoom classRoomParam){
        return classRoomMapper.updateClassRoomCourse(classRoomParam);
    }
    public ClassRoom selectClassRoomByRoomNo(ClassRoom classRoomParam){
        return classRoomMapper.selectClassRoomByRoomNo(classRoomParam);
    }
    public List<ClassRoom> selectAllClassRoom(){
        return classRoomMapper.selectAllClassRoom();
    }

    public List<ClassRoom> findRoomByCourseId(String courseId){
        return classRoomMapper.findRoomByCourseId(courseId);
    }
}
