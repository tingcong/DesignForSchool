package com.service;

import com.bean.Student;
import com.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zy on 2016/12/19.
 */
@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ChooseCourseInfoService chooseCourseInfoService;

    public Student getStuInfoByStuNo(int stuNo){
        return studentMapper.getStuInfoByStuNo(stuNo);
    }

}
