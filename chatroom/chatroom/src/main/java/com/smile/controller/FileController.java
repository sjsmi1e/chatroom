package com.smile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/file")
public class FileController {


    @RequestMapping(value = "/upheadimg")
    public String upHeadImg(@RequestParam("file")MultipartFile file){
        return "";
    }


}
