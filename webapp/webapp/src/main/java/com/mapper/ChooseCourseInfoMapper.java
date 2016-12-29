package com.mapper;

import com.bean.ChooseCourseInfo;
import com.bean.Student;

import java.util.List;

/**
 * Created by 聪 on 2016/12/26.
 */
public interface ChooseCourseInfoMapper {
    List<ChooseCourseInfo> selectCourseRecordByStuId(Student studentParam);

    Integer insertRecord(ChooseCourseInfo chooseCourseInfoParam);
    List<ChooseCourseInfo> findRecordByStuNo(Integer stuNo);
    List<ChooseCourseInfo> getRecordByTeachNo(int teachNo);
    List<ChooseCourseInfo> getRecordByCourseId(String courseId);
}
