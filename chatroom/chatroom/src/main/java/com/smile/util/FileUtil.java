package com.smile.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {

    private static String basepath = "/home/smi1e/testfile/image/";

    //文件名冲命名
    public static String reName(String filename){
        //设置格式
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        return df.format(new Date())+filename;
    }


    /**
     * 文件上传，返回文件地址或者错误信息
     */
    public static String upLoad(MultipartFile file,String fileName){
        File up = new File(basepath+fileName);
        try {
            file.transferTo(up);
            fileName = "http://47.93.221.192/image/"+fileName;
            return fileName;
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }
}
