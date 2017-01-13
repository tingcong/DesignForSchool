package com.controller;

import com.bean.ClassRoom;
import com.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by zy on 2016/12/23.
 */
@Controller
public class ClassRoomController {
    @Autowired
    private ClassRoomService classRoomService;

    /**
     * 管理员增加教室，默认教室状态为空闲(不可用)，课程为无
     * @param roomNo
     * @return
     */
    @RequestMapping("addClassRoom")
    @ResponseBody
    public Integer insertClassRoom(String roomNo){
        ClassRoom classRoomParam=new ClassRoom();
        classRoomParam.setRoomNo(roomNo);
        return classRoomService.insertClassRoom(classRoomParam);
    }


    /**
     * 更改教室状态，可用或不可用(正在维修或正在使用中)
     * @param roomNo
     * @param status
     * @return
     */
    @RequestMapping("alterClassRoomStatus")
    @ResponseBody
    public Integer updateClassRoomStatus(String roomNo,String status){
        ClassRoom classRoomParam=new ClassRoom();
        classRoomParam.setRoomNo(roomNo);
        classRoomParam.setStatus(status);
        return classRoomService.updateClassRoomStatus(classRoomParam);
    }

    /**
     * 当老师选定教室上课时和课程结束后更改教室的课程状态
     * @param roomNo
     * @param courseId
     * @return
     */
    @RequestMapping("alterClassRoomCourse")
    @ResponseBody
    public Integer updateClassRoomCourse(String roomNo,String courseId){
        ClassRoom classRoomParam=new ClassRoom();
        classRoomParam.setRoomNo(roomNo);
        classRoomParam.setCourseId(courseId);
        return classRoomService.updateClassRoomCourse(classRoomParam);
    }

    @RequestMapping("findClassRoomByRoomNo")
    @ResponseBody
    public ClassRoom selectClassRoomByRoomNo(String roomNo){
        ClassRoom classRoomParam=new ClassRoom();
        classRoomParam.setRoomNo(roomNo);
        return classRoomService.selectClassRoomByRoomNo(classRoomParam);
    }

    @RequestMapping("findAllClassRoom.htm")
    @ResponseBody
    public List<ClassRoom> selectAllClassRoom(){
        return classRoomService.selectAllClassRoom();
    }

    @RequestMapping("findRoomByCourseId")
    @ResponseBody
    public List<ClassRoom> findRoomByCourseId(HttpServletRequest request, HttpServletResponse response,String courseId){
        return classRoomService.findRoomByCourseId(courseId);
    }
}
