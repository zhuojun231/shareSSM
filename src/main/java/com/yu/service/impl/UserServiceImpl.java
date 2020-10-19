package com.yu.service.impl;

import com.yu.dao.IUserDao;
import com.yu.model.NoteResult;
import com.yu.model.User;
import com.yu.service.IUserService;
import com.yu.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author yuzhuojun
 * Date 2020/9/14 11:25
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;//注入

    @Override
    public User selectUser(long userId) {
        return userDao.selectUser(userId);
    }


    @Override
    public User findUserByName(String userName) {
        return userDao.findUserByName(userName);
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public NoteResult checkLogin(String name, String pwd) throws NoSuchAlgorithmException {
        NoteResult result = new NoteResult();
        User user = userDao.findUserByName(name);
        if (user == null) {
            result.setStatus(0);
            result.setMsg("用户名不存在");
            return result;
        }
        //将用户输入的pwd密码加密
        String md5_pwd = Md5Utils.string2Md5(pwd);
        //与数据库密码比对
        if (!user.getPassword().equals(md5_pwd)) {
            result.setStatus(2);
            result.setMsg("密码不正确");
            return result;
        }
        result.setStatus(1);
        result.setMsg("校验成功");
        result.setData(user.getId());//返回userID
        return result;
    }

    @Override
    public NoteResult regist(String name, String password, String email) throws NoSuchAlgorithmException {
        NoteResult result = new NoteResult();
        //检测用户名是否被占用
        User hash_user = userDao.findUserByName(name);
        if (hash_user != null) {
            result.setStatus(0);
            result.setMsg("用户名已被占用，重新注册");
            return result;
        }
        User user = new User();
        user.setUsername(name);
        String md5_pwd = Md5Utils.string2Md5(password);
        user.setPassword(md5_pwd);
        user.setEmail(email);
        //调用userDao保存
        userDao.saveUser(user);
        result.setStatus(1);
        result.setMsg("注册成功");
        return result;
    }
}
