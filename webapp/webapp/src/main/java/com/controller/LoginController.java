package com.controller;

import com.service.StudentService;
import com.service.TeacherService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zy on 2016/12/14.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService adminService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    /**
     *判断角色，学生或老师，是否有管理员权限
     * @param id    学号或教师工号
     * @return  职位  {position:student/teacher,isAdmin:0/1}
     */
    @RequestMapping("/isStuOrTeach({id})")
    @ResponseBody
    public Object isStuOrTeach(@PathVariable("id") int id){
        if(studentService.getStuInfoByStuNo(id)!=null){
            return studentService.getStuInfoByStuNo(id);
        }else if(teacherService.getTeachInfoByTeachNo(id)!=null){
            return teacherService.getTeachInfoByTeachNo(id);
        }else{
            return null;
        }
    }
    //登陆成功后跳转到主页
    @RequestMapping("/toHomePage")
    public String signIn() {
        System.out.println("signIn");
        return "/homepage";
    }
}
