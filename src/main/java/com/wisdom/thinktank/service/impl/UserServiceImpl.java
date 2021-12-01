package com.wisdom.thinktank.service.impl;

import com.wisdom.thinktank.entity.User;
import com.wisdom.thinktank.mapper.UserMapper;
import com.wisdom.thinktank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public String addUser(User user) {
        int i = userMapper.addUser(user);
        return "Registration success";
    }

    @Override
    public User getUserInfo(User user){
        return userMapper.isUserExist(user).get(0);
    }

    @Override
    public boolean isUserExist(User user) {
        return userMapper.isUserExist(user).size() != 0;
    }

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public String reUsername(User user) {
        int i = userMapper.reUsername(user);
        if (i==1){
            return "Rename successfully";
        } else {
            return "Rename failed";
        }
    }

    @Override
    public String reGender(User user) {
        int i = userMapper.reGender(user);
        if (i==1){
            return "Gender changed successfully";
        } else {
            return "Gender changed failed";
        }
    }

    @Override
    public String rePassword(String mail, String newPassword) {
        int i = userMapper.rePassword(mail, newPassword);
        if (i==1){
            return "Password changed successfully";
        } else {
            return "Password changed failed";
        }
    }

    @Override
    public String rePhoto(String photoUrl, String mail) {
        int i = userMapper.rePhoto(photoUrl, mail);
        if (i==1){
            return "Photo changed successfully";
        } else {
            return "Photo changed failed";
        }
    }
}
