package com.smile.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.smile.VO.UserVO;
import com.smile.pojo.User;
import com.smile.service.UpdateUserService;
import com.smile.service.UserService;
import com.smile.util.FileUtil;
import com.smile.util.JsonUtil;
import com.smile.util.StringUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

//@Controller

@CrossOrigin(origins = {"*", "null"})
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UpdateUserService updateUserService;

    @RequestMapping(value = "/all")
    @ResponseBody
    public String allUser() throws JsonProcessingException {
        List<User>users = userService.seletAllUser();
        return JsonUtil.objectToJson(users);
    }


    /**
     * 登录
     * @param user_name
     * @param passwd
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST,produces = "text/json;charset=utf-8")
//  @RestController
    @ResponseBody
    public String login(String user_name,String passwd){
        System.out.println(user_name);
        System.out.println(passwd);
        Integer id = userService.matchPasswd(user_name,passwd);
        System.out.println(id);
        if( id != null){
            return "{\"id\":"+id+"}";
        }else {
            return "{\"message\":\"用户名密码错误\"}";
        }
    }


    /**
     * 注册
     */
    @RequestMapping(value = "/register")
    @ResponseBody
//  @RestController
    public String register(String user_name, String passwd,String email/* MultipartFile img,*/){
        User user=new User();
        user.setUserName(user_name);
        user.setPassWd(passwd);
        user.setUserTel("00000000000");
        user.setUserSex("女");
        user.setUserAge("99");
        if (email!=null && !email.equals("")){
            user.setEmail(email);
        }
        user.setImg("http://47.93.221.192/image/first.jpeg");
//        if (!img.isEmpty()){
//            //上传文件
//            user.setImg(FileUtil.upLoad(img,FileUtil.reName(img.getOriginalFilename())));
//        }

        //model.addAttribute("user",user);
            if (userService.addUser(user)==1){

                return "{\"id\":\""+userService.matchPasswd(user.getUserName(),user.getPassWd())+"\"}";
            }
            else {
                return "{\"message\":\"error\"}";
            }
    }

    /**
     * 通过用户名获取用户名
     */
    @RequestMapping(value = "/getusername")
    @ResponseBody
    public String getName(String username){
        //判断用户名是否存在

        if (userService.getUsername(username)!=null){
            return "{\"message\":\"用户名已存在\"}";
        }
        else {
            return "{\"message\":\"可以注册\"}";
        }
    }



//    /**
//     * 测试websocket
//     */
//    @RequestMapping(value = "/webtest",method = RequestMethod.GET,produces = "text/json;charset=utf-8")
//    @ResponseBody
//    public void web(HttpServletResponse response, HttpServletRequest request, @RequestParam("user_id")String user_id) throws IOException {
//
//        try {
//            request.setCharacterEncoding("utf-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        response.setCharacterEncoding("utf-8");
//
//        WebSocketServer.sendInfo("youren", user_id);
//        System.out.println("发送成功");
//    }

    /**
     * 进入聊天室
     */
    @RequestMapping(value = "/chat")
    public void chat(@RequestParam("id")int id,Model model){
        //通过id查找姓名
        String userName = userService.selectUserById(id).getUserName();
        model.addAttribute("username",userName);

    }

    /**
     * 获取用户信息
     */
    @RequestMapping(value = "/getUser")
    @ResponseBody
    public String getUser(@Param("id")int id){
        try {
            return JsonUtil.objectToJson(userService.selectUserById(id));
        } catch (JsonProcessingException e) {
            return "{\"message\":\"error\"}";
        }
    }

    /**
     * 邮箱是否存在
     */
    @RequestMapping("/emailisexit")
    @ResponseBody
    public String emailIsExit(@RequestParam("email")String email){
        Integer id = userService.getIdByEmail(email);
        if (id!=null)
            return "{\"message\":\""+id+"\"}";
        else
            return "{\"message\":\"可以注册\"}";
    }

    /**
     * 修改密码
     */
    @RequestMapping(value = "/updatepasswd")
    @ResponseBody
    public String upDatePasswd(@RequestParam("user_name")String user_name,@RequestParam("passwd")String passwd){
        if (passwd.equals("")||passwd==null){
            return "{\"message\":\"密码不能为空\"}";
        }else {
            if (updateUserService.updatePasswd(user_name,passwd))
                return "{\"message\":\"修改成功\"}";
            else
                return "{\"message\":\"修改失败\"}";
        }
    }

    /**
     * 修改用户名
     */
    public String upDateUserName(@RequestParam("id")int id,@RequestParam("user_name")String user_name){
        if (user_name.equals("")||user_name==null){
            return "{\"message\":\"用户名不能为空\"}";
        }else {
            if (updateUserService.updateUserName(user_name,id))
                return "{\"message\":\"修改成功\"}";
            else
                return "{\"message\":\"修改失败\"}";
        }
    }
    /**
     * 修改头像
     */
    @RequestMapping(value = "/updateImg",method = RequestMethod.POST)
    @ResponseBody
    public String upDateImg(@RequestParam("id")int id,@RequestParam("img") MultipartFile img){
        System.out.println("updateImg");
        if (img!=null){
            if (updateUserService.updateImg(FileUtil.upLoad(img,img.getOriginalFilename()),id))
                return "{\"message\":\"修改成功\"}";
            else
                return "{\"message\":\"修改失败\"}";
        }
        return "{\"message\":\"修改失败\"}";
    }

    /**
     * 修改性别
     */
    @RequestMapping("/updateSex")
    @ResponseBody
    public String upDateSex(@RequestParam("id")int id,@RequestParam("user_sex") String user_sex){
        if (user_sex.equals("")||user_sex==null){
            return "{\"message\":\"修改失败\"}";
        }else {
            if (updateUserService.updateUserSex(user_sex,id))
                return "{\"message\":\"修改成功\"}";
            else
                return "{\"message\":\"修改失败\"}";
        }
    }
    /**
     * 修改年龄
     */
    @RequestMapping(value = "/updateAge")
    @ResponseBody
    public String upDateImg(@RequestParam("id")int id,@RequestParam("user_age") String user_age){
        if (user_age.equals("")||user_age==null){
            return "{\"message\":\"年龄不能为空\"}";
        }else {
            if (StringUtil.isInteger(user_age)){
                if (updateUserService.updateUserAge(user_age,id))
                    return "{\"message\":\"修改成功\"}";
                else
                    return "{\"message\":\"修改失败\"}";
            }else {
                return "{\"message\":\"年龄必须为整数\"}";
            }
        }
    }


    /**
     * 通过用户名获取Email
     */
    @RequestMapping(value = "/getemail")
    @ResponseBody
    public String getEmail(@RequestParam("user_name")String user_name){
        return "{\"email\":\""+userService.getEmailByname(user_name)+"\"}";
    }

    /**
     * 通过用户名获取user
     */
    @RequestMapping(value = "/getuserbyname")
    @ResponseBody
    public String getUserByName(@RequestParam("user_name")String user_name){
        try {
            User u = userService.getUserByName(user_name);
            UserVO person = new UserVO(u.getId(),u.getUserName(),u.getImg());
            return JsonUtil.objectToJson(person);
        } catch (JsonProcessingException e) {
            return "{\"message\":\"error\"}";
        }
    }


    /**
     * 更新信息
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public String update(@RequestParam("id")String id,@RequestParam("user_tel")String user_tel,@RequestParam("user_sex")String user_sex,
                         @RequestParam("user_age")String user_age){
        //System.out.println(id);
        User u = userService.selectUserById(Integer.valueOf(id));
        u.setUserTel(user_tel);
        u.setUserSex(user_sex);
        u.setUserAge(user_age);
        updateUserService.updateAll(u);
        return "{\"message\":\"success\"}";
    }
}
