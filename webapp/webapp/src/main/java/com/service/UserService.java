package com.service;

import com.bean.User;
import com.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zy on 2016/12/14.
 */
@Service
@Transactional
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public User getUserInfo(User userParam){
        return userMapper.getUser(userParam);
    }
    public Boolean isAdmin(Integer user_no){
        return  userMapper.isAdmin(user_no);
    }
    public Integer updatePwd(User userParam){
        return userMapper.updatePwd(userParam);
    }
}
