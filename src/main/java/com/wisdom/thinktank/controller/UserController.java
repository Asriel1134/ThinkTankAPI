package com.wisdom.thinktank.controller;

import com.alibaba.fastjson.JSONObject;
import com.wisdom.thinktank.entity.User;
import com.wisdom.thinktank.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;


@RestController
public class UserController {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserServiceImpl userServer;

    @RequestMapping("/getuserlist")
    public List<User> getUserList()
    {
        return userServer.getUserList();
    }

    @RequestMapping("/getUserInfo")
    public User getUserInfo(User user)
    {
        return userServer.getUserInfo(user);
    }

    @PostMapping("/adduser")
    public String addUser(User user)
    {
        JSONObject registerJson = new JSONObject();

        if (userServer.isUserExist(user)){
            registerJson.put("result", -1);
            registerJson.put("info", "User already exists");
            registerJson.put("userinfo", "");
        } else {
            registerJson.put("result", 0);
            registerJson.put("info", userServer.addUser(user));
            registerJson.put("userinfo", userServer.login(user));
        }
        return registerJson.toJSONString();
    }

    @PostMapping("/login")
    public String login(User user){
        JSONObject loginJson = new JSONObject();

        if (!userServer.isUserExist(user)){
            loginJson.put("result", -1);
            loginJson.put("info", "User does not exist");
            loginJson.put("userinfo", "");
        } else {
            User result = userServer.login(user);
            if (result==null){
                loginJson.put("result", -3);
                loginJson.put("info", "Wrong user name or password");
                loginJson.put("userinfo", result);
            } else {
                loginJson.put("result", 0);
                loginJson.put("info", "Success");
                loginJson.put("userinfo", result);
            }
        }
        return loginJson.toJSONString();
    }

    @PostMapping("/reUsername")
    public String reUsername(User user){
        JSONObject reUsernameJson = new JSONObject();

        reUsernameJson.put("result", 0);
        reUsernameJson.put("info", userServer.reUsername(user));
        reUsernameJson.put("userInfo", getUserInfo(user));
        return reUsernameJson.toJSONString();
    }

    @PostMapping("/reGender")
    public String reGender(User user){
        JSONObject reGenderJson = new JSONObject();

        reGenderJson.put("result", 0);
        reGenderJson.put("info", userServer.reGender(user));
        reGenderJson.put("userInfo", getUserInfo(user));
        return reGenderJson.toJSONString();
    }

    @PostMapping("/rePassword")
    public String rePassword(String mail, String password, String newPassword){
        JSONObject rePasswordJson = new JSONObject();
        User user = new User();
        user.setPassword(password);
        user.setMail(mail);

        User result = userServer.login(user);
        if (result == null){
            rePasswordJson.put("result", -4);
            rePasswordJson.put("info", "Wrong password");
        } else {
            String info = userServer.rePassword(mail, newPassword);
            rePasswordJson.put("result", 0);
            rePasswordJson.put("info", info);
        }
        return rePasswordJson.toJSONString();
    }

    @PostMapping("/uploadPhoto")
    public String uploadPhoto(@RequestParam("file")MultipartFile file, User user){
        JSONObject uploadPhotoJson = new JSONObject();

        if (file.isEmpty()) {
            uploadPhotoJson.put("result", -8);
            uploadPhotoJson.put("info", "Upload failed, please select file");
            uploadPhotoJson.put("userInfo", getUserInfo(user));
            return uploadPhotoJson.toJSONString();
        }
        String fileName = file.getOriginalFilename();
        String filePath = "/var/www/html/userphoto/";
        System.out.println(filePath + fileName);
        File photo = new File(filePath + fileName);
        String info;
        try {
            file.transferTo(photo);
            info = userServer.rePhoto("http://106.12.74.90/userphoto/"+fileName, user.getMail());
            uploadPhotoJson.put("result", 0);
            uploadPhotoJson.put("info", info);
            uploadPhotoJson.put("userInfo", getUserInfo(user));
            return uploadPhotoJson.toJSONString();
        } catch (IOException e) {
            e.printStackTrace();
            info = "fail";
            uploadPhotoJson.put("result", -9);
            uploadPhotoJson.put("info", "fail");
            uploadPhotoJson.put("userInfo", getUserInfo(user));
            return uploadPhotoJson.toJSONString();
        }
    }
}