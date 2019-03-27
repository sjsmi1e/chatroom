package com.smile.mapper;


import com.smile.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 返回所有用户基本信息
     * @return
     */
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "user_name",property = "userName"),
            @Result(column = "passwd",property = "passWd"),
            @Result(column = "user_tel",property = "userTel"),
            @Result(column = "user_sex",property = "userSex"),
            @Result(column = "user_age",property = "userAge"),
            @Result(column = "email",property = "email"),
            @Result(column = "img",property = "img")
    })
    @Select("select * from user")
    public List<User> seletAllUser();


    /**
     * 通过用户名匹配密码
     */
    @Select("select id from user where user_name=#{user_name} and passwd=#{passwd}")
    public Integer matchPasswd(@Param("user_name")String user_name,@Param("passwd")String passwd);

    /**
     * 通过id查个人信息
     */
    @Select("select * from user where id = #{id}")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "user_name",property = "userName"),
            @Result(column = "passwd",property = "passWd"),
            @Result(column = "user_tel",property = "userTel"),
            @Result(column = "user_sex",property = "userSex"),
            @Result(column = "user_age",property = "userAge"),
            @Result(column = "email",property = "email"),
            @Result(column = "img",property = "img")

    })
    public User selectUserById(@Param("id")int id);


    /**
     * 新增user
     */
    @Insert("insert into user values (default,#{user.userName},#{user.passWd}" +
            ",#{user.userTel},#{user.userSex},#{user.userAge},#{user.email},#{user.img})")
    public int addUser(@Param("user")User user);


    /**
     * 获取用户名
     */
    @Select("select user_name from user where user_name=#{user_name}")
    public String getUsername(@Param("user_name")String user_name);


    /**
     * 判断邮箱是否存在
     */
    @Select("select id from user where email=#{email}")
    public Integer getIdByEmail(@Param("email")String email);


    /**
     * 通过用户名获取邮箱
     */
    @Select("select email from user where user_name=#{user_name}")
    public String getEmailByname(@Param("user_name")String user_name);

    /**
     * 通过用户名获取信息
     */
    @Select("select * from user where user_name=#{user_name}")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "user_name",property = "userName"),
            @Result(column = "passwd",property = "passWd"),
            @Result(column = "user_tel",property = "userTel"),
            @Result(column = "user_sex",property = "userSex"),
            @Result(column = "user_age",property = "userAge"),
            @Result(column = "email",property = "email"),
            @Result(column = "img",property = "img")
    })
    public User getUserByName(@Param("user_name")String user_name);

}

