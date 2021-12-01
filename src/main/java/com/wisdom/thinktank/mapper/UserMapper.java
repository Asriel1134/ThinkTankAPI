package com.wisdom.thinktank.mapper;

import com.wisdom.thinktank.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public interface UserMapper {

    @Select("select userid,username from user order by userid desc")
    List<User> getUserList();

    @Insert("insert into user(mail,username,password) values(#{mail},#{username},SHA1(#{password}))")
    int addUser(User user);

    @Select("select * from user where mail = #{mail}")
    List<User> isUserExist(User user);
    
    @Select("SELECT userid, mail, username, photo, gender from `user` WHERE mail = #{mail} AND `password` =  SHA1(#{password})")
    User login(User user);

    @Update("UPDATE user SET username = #{username} WHERE mail = #{mail};")
    int reUsername(User user);

    @Update("UPDATE user SET gender = #{gender} WHERE mail = #{mail};")
    int reGender(User user);

    @Update("UPDATE user SET password = SHA1(#{newPassword}) WHERE mail = #{mail};")
    int rePassword(String mail, String newPassword);

    @Update("UPDATE user SET photo = #{photoUrl} WHERE mail = #{mail}")
    int rePhoto(String photoUrl, String mail);
}
