package com.renjun.ems.service.serivceImpl;

import com.renjun.ems.dao.UserDao;
import com.renjun.ems.entity.User;
import com.renjun.ems.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public void save(User user) {
        user.setId(UUID.randomUUID().toString());
        userDao.save(user);
    }

    @Override
    public User userLogin(String username, String password) {
        User user = userDao.userLogin(username,password);
        return user;
    }
}
