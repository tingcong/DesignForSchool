package com.controller;

import com.bean.Student;
import com.service.CourseService;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 胡廷聪 on 2016/12/15.
 */
@Controller
public class StuController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @RequestMapping("getStuInfoByStuNo")
    @ResponseBody
    public Student getStuInfoByStuNo(HttpServletRequest request, HttpServletResponse response,int stuNo){
        return studentService.getStuInfoByStuNo(stuNo);
    }

}
