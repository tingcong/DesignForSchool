package com.mapper;

import com.bean.User;

/**
 * Created by zy on 2016/12/14.
 */
public interface UserMapper {
    User getUser(User userParam);
    Boolean isAdmin(Integer id);
    Integer updatePwd(User userParam);
}
