package com.controller;

import com.bean.ChooseCourseInfo;
import com.service.ChooseCourseInfoService;
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
public class ChooseCourseInfoController {


    @Autowired
    private ChooseCourseInfoService chooseCourseInfoService;


    /**
     * 学生选课调用
     * @param chooseCourseInfoParam
     * @return
     */
    @RequestMapping("addChooseCourseRecord")
    @ResponseBody
    public Integer insertRecord(HttpServletRequest request, HttpServletResponse response,ChooseCourseInfo chooseCourseInfoParam){

        return chooseCourseInfoService.insertRecord(chooseCourseInfoParam);
    }


    @RequestMapping("findRecordByStuNo.htm")
    @ResponseBody
    public Object findRecordByStuNo(HttpServletRequest request, HttpServletResponse response, Integer stuNo){
        return chooseCourseInfoService.findRecordByStuNo(stuNo);
    }


    @RequestMapping("getRecordByTeachNo")
    @ResponseBody
    public Object findRecordByStuNo(HttpServletRequest request, HttpServletResponse response, int teachNo){
        return chooseCourseInfoService.getRecordByTeachNo(teachNo);
    }


    @RequestMapping("getRecordByCourseId")
    @ResponseBody
    public List<ChooseCourseInfo> getRecordByCourseId(String courseId){
        return chooseCourseInfoService.getRecordByCourseId(courseId);
    }
}
