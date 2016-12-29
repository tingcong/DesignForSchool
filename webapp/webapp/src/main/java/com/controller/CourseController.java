package com.controller;

import com.bean.Course;
import com.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by 胡廷聪 on 2016/12/26.
 */
@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("addCourse")
    @ResponseBody
    public Integer insertCourse(HttpServletRequest request, HttpServletResponse response,Course courseParam){
        courseParam.setCourseTime("2016-12-26 七八节");
        return courseService.insertCourse(courseParam);
    }

    @RequestMapping("showAllCourse")
    @ResponseBody
    public List<Course> findAllCourse(){
        return courseService.findAllCourse();
    }

    @RequestMapping("findCourseByCourseId")
    @ResponseBody
    public Course findCourseByCourseId(HttpServletRequest request,HttpServletResponse response,String courseId){
        return courseService.findCourseByCourseId(courseId);
    }

    @RequestMapping("getCourseInfoByTeachNo")
    @ResponseBody
    public List<Course> getCourseInfoByTeachNo(HttpServletRequest request,HttpServletResponse response,int teachNo){
        return courseService.getCourseInfoByTeachNo(teachNo);
    }
}
