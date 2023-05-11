package com.renjun.ems.service;


import com.renjun.ems.entity.User;



public interface UserService {

    void save(User user);

    User userLogin(String username, String password);

}
