package com.smile.controller;


import com.smile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/view")
public class ViewController {

    @Autowired
    UserService userService;

    /**
     * index页面
     */
    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }


    /**
     * 个人界面
     */
    @RequestMapping(value = "/person")
    public String person(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (cookies == null){
            return "index";
        }
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("id")){
                return "person";
            }
        }
        return "index";
    }



    /**
     * 注册页面
     */
    @RequestMapping(value = "/register")
    public String register(){
        return "register";
    }


    /**
     * 进入room页面
     */
    @RequestMapping(value = "/room")
    public String room(){
        return "room";
    }

}
