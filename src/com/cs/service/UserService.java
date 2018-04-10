package com.cs.service;

import com.cskaoyan.bean.User;

public interface UserService {

         User   login(User user);

         int register(User user);

         boolean isUsernameExist(String username);

         User getUserById(int id);

         int updateUserById(String username, String password);
}
