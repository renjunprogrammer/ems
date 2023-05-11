package com.renjun.ems.dao;

import com.renjun.ems.entity.User;

public interface UserDao {

    //保存用户
    void save(User user);

    //登录用户
    User userLogin(String username, String password);
}
