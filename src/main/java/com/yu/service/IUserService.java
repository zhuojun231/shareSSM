package com.yu.service;

import com.yu.model.NoteResult;
import com.yu.model.User;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

public interface IUserService {
    public User selectUser(long userId);
    public User findUserByName(String userName);
    public void saveUser(User user);

    public NoteResult checkLogin(String name, String pwd) throws NoSuchAlgorithmException;
    public  NoteResult regist(String name, String password, String nickname) throws NoSuchAlgorithmException;
}
