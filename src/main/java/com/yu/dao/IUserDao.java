package com.yu.dao;

import com.yu.model.User;

public interface IUserDao {
    User selectUser(long id);
    User findUserByName(String userName);
    void saveUser(User user);
}
