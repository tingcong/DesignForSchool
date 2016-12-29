package com.mapper;

import com.bean.Course;

import java.util.List;

/**
 * Created by zy on 2016/12/14.
 */
public interface CourseMapper  {
    Integer insertCourse(Course courseParam);
    List<Course> findAllCourse();
    Course findCourseByCourseId(String CourseId);

    List<Course> getCourseInfoByTeachNo(int teachNo);
}
