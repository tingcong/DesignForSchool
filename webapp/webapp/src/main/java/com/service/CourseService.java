package com.service;

import com.bean.Course;
import com.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zy on 2016/12/23.
 */
@Service
public class CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Transactional
    public Integer insertCourse(Course courseParam) {
        return courseMapper.insertCourse(courseParam);
    }


    @Transactional
    public List<Course> findAllCourse(){
        return courseMapper.findAllCourse();
    }

    @Transactional
    public Course findCourseByCourseId(String courseId){
        return courseMapper.findCourseByCourseId(courseId);
    }

    public List<Course> getCourseInfoByTeachNo(int teachNo){
        return courseMapper.getCourseInfoByTeachNo(teachNo);
    }
}
