package com.smile.VO;

import lombok.Data;

@Data
public class UserVO {
    private Integer id;
    private String userName;
    private String img;

    public UserVO(Integer id, String userName, String img) {
        this.id = id;
        this.userName = userName;
        this.img = img;
    }

    public UserVO(String userName, String img) {
        this.userName = userName;
        this.img = img;
    }
}
