package com.smile.controller;

import com.smile.util.MailValid;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：smile丶
 * @date ：Created in 19-3-16 下午4:27
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
@CrossOrigin(origins = {"*", "null"})
@RequestMapping("/email")
@RestController
public class EmailController {

    @RequestMapping("/isval")
    public String emailIsVal(String email){
        System.out.println("email is val");
        if (MailValid.valid(email, "47.93.221.192"))
            return  "{\"message\":\"success\"}";
        else
            return  "{\"message\":\"error\"}";
    }
}
