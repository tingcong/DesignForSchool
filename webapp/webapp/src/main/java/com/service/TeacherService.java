package com.service;

import com.bean.ChooseCourseInfo;
import com.bean.Course;
import com.bean.Student;
import com.bean.Teacher;
import com.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zy on 2016/12/19.
 */
@Service
public class TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private ChooseCourseInfoService chooseCourseInfoService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentService studentService;

    public Teacher getTeachInfoByTeachNo(int teachNo) {
        return teacherMapper.getTeachInfoByTeachNo(teachNo);
    }

    @Transactional
    public List<Student> getStuInfoByTeachNo(int teachNo) {
        //存放学生信息
        List<Student> list_Stu=new ArrayList<Student>();

        List<Course> list=new ArrayList<Course>();
        list=courseService.getCourseInfoByTeachNo(teachNo);
        //存放该老师所有课程的id
        Set<String> set=new HashSet<String>();
        for(Course tmp:list){
            List<ChooseCourseInfo> list_CCI=new ArrayList<ChooseCourseInfo>();
            //根据课程编号找到所有的选课记录，从中提取学号信息
            list_CCI=chooseCourseInfoService.getRecordByCourseId(tmp.getCourseId());
            for(ChooseCourseInfo p:list_CCI){
                //根据学生学号找到学生所有信息学，并列出学生信息
                list_Stu.add(studentService.getStuInfoByStuNo(p.getStuNo()));
            }
        }
        return list_Stu;
    }
}
