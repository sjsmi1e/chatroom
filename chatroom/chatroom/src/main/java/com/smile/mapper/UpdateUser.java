package com.smile.mapper;


import com.smile.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface UpdateUser {
    /**
     * 修改密码
     */
    @Update("update user set passwd = #{passwd} where user_name = #{user_name} ")
    public boolean updatePasswd(@Param("user_name")String user_name,@Param("passwd")String passwd);

    /**
     * 修改用户名
     */
    @Update("update user set user_name = #{user_name} where id = #{id} ")
    public boolean updateUserName(@Param("user_name")String user_name,@Param("id")int id);

    /**
     * 修改性别
     */
    @Update("update user set user_sex = #{user_sex} where id = #{id} ")
    public boolean updateUserSex(@Param("user_sex")String user_sex,@Param("id")int id);
    /**
     * 修改年龄
     */
    @Update("update user set user_age = #{user_age} where id = #{id} ")
    public boolean updateUserAge(@Param("user_age")String user_age,@Param("id")int id);
    /**
     * 修改头像
     */
    @Update("update user set img = #{img} where id = #{id} ")
    public boolean updateImg(@Param("img")String img,@Param("id")int id);

    /**
     * 修改信息
     */
    @Update("update user set user_tel = #{user.userTel},user_sex = #{user.userSex},user_age = #{user.userAge} where id = #{user.id} ")
    public boolean updateAll(@Param("user")User user);
}
