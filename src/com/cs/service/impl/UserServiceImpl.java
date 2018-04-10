package com.cs.service.impl;

import com.cskaoyan.bean.User;
import com.cskaoyan.dao.UserMapper;
import com.cskaoyan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserMapper dao ;


    @Override
    public User login(User user) {

        return dao.login(user);
    }

    @Override
    public int register(User user) {
        return dao.insertUser(user);
    }

    @Override
    public boolean isUsernameExist(String username) {
        return false;
    }

    @Override
    public User getUserById(int id) {
        return dao.queryUserByPrimaryKey(id);
    }

    @Override
    public int updateUserById(String username, String password) {
        return 0;
    }


//    @Transactional
//    @Override
//    public int updateUserById(User user) {
//        dao.updateByPrimaryKeySelective(user);
//
//        int i=1/0;
//
//        user.setUsername("xxx");
//        dao.updateByPrimaryKeySelective(user);
//        return  1;
//    }


}
