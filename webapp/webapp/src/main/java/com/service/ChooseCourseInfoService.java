package com.service;

import com.bean.ChooseCourseInfo;
import com.mapper.ChooseCourseInfoMapper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 聪 on 2016/12/26.
 */
@Service
public class ChooseCourseInfoService {
    @Autowired
    private ChooseCourseInfoMapper chooseCourseInfoMapper;
    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ClassRoomService classRoomService;

    @Transactional
    public Integer insertRecord(ChooseCourseInfo chooseCourseInfoParam) {

        if (courseService.findCourseByCourseId(chooseCourseInfoParam.getCourseId()) != null) {
            if (studentService.getStuInfoByStuNo(chooseCourseInfoParam.getStuNo()) == null) {
                try {
                    return chooseCourseInfoMapper.insertRecord(chooseCourseInfoParam);
                } catch (RuntimeException e) {
                    throw new RuntimeException(e + "you  has choosed this course !");
                }
            } else {
                throw new RuntimeException("学生信息有误");
            }
        } else {
            throw new RuntimeException("该课程不存在");
        }
    }


    @Transactional
    public Object findRecordByStuNo(Integer stuNo) {
        JSONObject json = new JSONObject();
        JSONArray jsonArray=new JSONArray();
        try {
            //获取课程编号，课程名称
            List<ChooseCourseInfo> list_C = new ArrayList<ChooseCourseInfo>();
            list_C = chooseCourseInfoMapper.findRecordByStuNo(stuNo);


            JSONObject jsonObject = new JSONObject();
            for (ChooseCourseInfo tmp : list_C) {
    //           StuCourseInfo stuCourseInfo=new StuCourseInfo(
                //课程编号
                jsonObject.put("CourseId", tmp.getCourseId());
                //课程名称
                jsonObject.put("CourseName", courseService.findCourseByCourseId(tmp.getCourseId()).getCourseName());
                //任课老师
                jsonObject.put("TeachName", teacherService.getTeachInfoByTeachNo(courseService.findCourseByCourseId(tmp.getCourseId()).getTeachNo()).getTeachName());
                //上课地点
    //            jsonObject.put("RoomNo",classRoomService.findRoomByCourseId(tmp.getCourseId()).get(1).getRoomNo());
    //                   );
    //            list_SCI.add(stuCourseInfo);
                System.out.println(jsonObject);
                json.put(tmp.getCourseId(),jsonObject);
                jsonArray.add(jsonObject);
                jsonObject.clear();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return jsonArray;
    }

    @Transactional
    public List<ChooseCourseInfo> getRecordByTeachNo(int teachNo){
        return chooseCourseInfoMapper.getRecordByTeachNo(teachNo);
    }

    @Transactional
    public List<ChooseCourseInfo> getRecordByCourseId(String courseId){
        return chooseCourseInfoMapper.getRecordByCourseId(courseId);
    }
}
