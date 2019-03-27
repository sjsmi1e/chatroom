package com.smile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：smile丶
 * @date ：Created in 19-3-16 上午11:37
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
@CrossOrigin(origins = {"*", "null"})
@Controller
@RequestMapping("/view")
public class ViewController {


    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
