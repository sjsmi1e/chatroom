package com.smile.pojo;

import lombok.Data;

@Data//不需要写get和set
public class User {
    private Integer id;
    private String userName;
    private String passWd;
    private String userTel;
    private String userSex;
    private String userAge;
    private String email;
    private String img;

}
