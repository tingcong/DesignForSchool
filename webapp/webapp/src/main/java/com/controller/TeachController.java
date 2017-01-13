package com.controller;

import com.bean.Student;
import com.bean.Teacher;
import com.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by 胡廷聪 on 2016/12/22.
 */
@Controller
public class TeachController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("getTeachInfoByTeachNo")
    @ResponseBody
    public Teacher getTeachInfoByTeachNo(HttpServletRequest request, HttpServletResponse response, int teach_no){
        return teacherService.getTeachInfoByTeachNo(teach_no);
    }

    //查询已选该老师课程的学生名单
    @RequestMapping("getStuInfoByTeachNo.htm")
    @ResponseBody
        public List<Student> getStuInfoByTeachNo(HttpServletRequest request, HttpServletResponse response, int teach_no){
            return teacherService.getStuInfoByTeachNo(teach_no);
    }
}
