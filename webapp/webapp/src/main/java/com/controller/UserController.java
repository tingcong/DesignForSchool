package com.controller;

import com.bean.User;
import com.service.StudentService;
import com.service.TeacherService;
import com.service.UserService;
import com.utils.EncryptionMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zy on 2016/12/15.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;


    @RequestMapping("showUserInfo.htm")
    @ResponseBody
    public User getUserById( Long id){
        return null;
    }


    @RequestMapping("checkUserPwd.htm")
    @ResponseBody
    public String checkPwd(HttpServletRequest request, HttpServletResponse response,Integer username, String password){
        User userParam=new User();
        userParam.setNo(username);
        userParam.setPassword(EncryptionMD5.MD5(password));
        if( userService.getUserInfo(userParam)!=null){
           if(isAdmin(username)){
               return "admin";
           }else if(studentService.getStuInfoByStuNo(username)!=null){
               return "student";
           }else if(teacherService.getTeachInfoByTeachNo(username)!=null){
               return "teacher";
           }else {
               throw new RuntimeException("the user is here ,but not know his Roles ");
           }
        }else {
            return "the user not exist";
        }
    }

    @RequestMapping("isAdmin.htm")
    @ResponseBody
    public Boolean isAdmin( Integer user_no){
        return userService.isAdmin(user_no);
    }

    @RequestMapping("goIndex")
    public String goIndix() {
        return "/index";
    }


    @RequestMapping("updatePwd")
    @ResponseBody
    public Integer updatePwd(Integer user_no,String user_password){
        User userParam=new User();
        userParam.setNo(user_no);
        userParam.setPassword(EncryptionMD5.MD5(user_password));
        return userService.updatePwd(userParam);
    }
}
