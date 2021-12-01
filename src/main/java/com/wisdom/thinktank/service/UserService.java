package com.wisdom.thinktank.service;


import com.wisdom.thinktank.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

        List<User> getUserList();

        String addUser(User user);

        boolean isUserExist(User user);

        public User getUserInfo(User user);

        User login(User user);

        String reUsername(User user);
        
        String reGender(User user);

        String rePassword(String mail, String newPassword);

        String rePhoto(String photoUrl, String mail);
}
