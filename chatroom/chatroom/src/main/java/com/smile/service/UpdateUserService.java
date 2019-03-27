package com.smile.service;

import com.smile.mapper.UpdateUser;
import com.smile.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UpdateUserService implements UpdateUser {
    @Autowired
    UpdateUser updateUser;


    @Override
    public boolean updatePasswd(String user_name, String passwd) {
        return updateUser.updatePasswd(user_name,passwd);
    }

    @Override
    public boolean updateUserName(String user_name, int id) {
        return updateUser.updateUserName(user_name,id);
    }

    @Override
    public boolean updateUserSex(String user_sex, int id) {
        return updateUser.updateUserSex(user_sex,id);
    }

    @Override
    public boolean updateUserAge(String user_age, int id) {
        return updateUser.updateUserAge(user_age,id);
    }

    @Override
    public boolean updateImg(String img, int id) {
        return updateUser.updateImg(img,id);
    }

    @Override
    public boolean updateAll(User user) {
        return updateUser.updateAll(user);
    }
}
