package com.smile.service;

import com.smile.mapper.UserMapper;
import com.smile.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements UserMapper{

    @Autowired
    UserMapper userMapper;


    @Override
    public List<User> seletAllUser() {
        return userMapper.seletAllUser();
    }

    @Override
    public Integer matchPasswd(String user_name, String passwd) {
        return userMapper.matchPasswd(user_name,passwd);
    }

    @Override
    public User selectUserById(int id) {
        return userMapper.selectUserById(id);
    }

    @Override
    @Transactional
    public int addUser(User user) {
        return userMapper.addUser(user);
    }


    public String getUsername(String user_name) {
        return userMapper.getUsername(user_name);
    }

    @Override
    public Integer getIdByEmail(String email) {
        return userMapper.getIdByEmail(email);
    }

    @Override
    public String getEmailByname(String user_name) {
        return userMapper.getEmailByname(user_name);
    }

    @Override
    public User getUserByName(String user_name) {
        return userMapper.getUserByName(user_name);
    }
}
