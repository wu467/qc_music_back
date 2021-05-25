package top.wwqi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.wwqi.model.dto.LoginDTO;
import top.wwqi.model.dto.RegisterDTO;
import top.wwqi.model.entity.User;
import top.wwqi.service.UserService;
import top.wwqi.utils.JsonResult;
import top.wwqi.utils.MailUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * @param dto
     * @return
     */
    @RequestMapping(value ="/register", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult register(@RequestParam("registerDTO")String dto) {
        System.out.println("前端传过来的DTO"+dto);
        ObjectMapper mapper = new ObjectMapper();
        RegisterDTO register = null;
        try {
            register = mapper.readValue(dto, RegisterDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonResult result= userService.executeRegister(register);

        return result;
    }

    /**
     * 用户登录
     * @param dto
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult<User> login(@RequestParam("loginDTO")String dto, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        System.out.println(dto);
        ObjectMapper mapper = new ObjectMapper();
        LoginDTO login = null;
        try {
            login = mapper.readValue(dto, LoginDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonResult<User> result = userService.executeLogin(login, request, response);

        //测试：待删除  获取cookie
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies){
                System.out.println("--------------------------------");
                System.out.println(URLDecoder.decode(cookie.getName(), "UTF-8")  + "-----" + URLDecoder.decode(cookie.getValue(),"UTF-8"));
                System.out.println("--------------------------------");
            }
        }

        return result;
    }


    /**
     * 注册时，异步验证邮箱是否已存在(即当用户填完邮箱后就会执行，第一时间验证邮箱是否注册)
     * @return  1 为已存在， 0为不存在
     */
    @RequestMapping(value = "/checkEmail", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult checkEmail(@RequestParam("emailAddress") String emailAddress){
        System.out.println("传来的邮箱为："+emailAddress);
        int res = userService.checkEmail(emailAddress);
        return new JsonResult(200,res,"邮箱是否存在");
    }

    /**
     * 用户退出登录
     *
     * @return
     */
    @RequestMapping(value = "/signOut", method = RequestMethod.GET)
    public String signOut(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {

        //获取cookie
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length > 0){
            System.out.println("------------退出登录------------");
            for (Cookie cookie : cookies){
                System.out.println(URLDecoder.decode(cookie.getName(), "UTF-8")  + "-----" + URLDecoder.decode(cookie.getValue(),"UTF-8"));
            }
        }


        //清除cookie信息
        for (Cookie cookie :cookies){//遍历所有Cookie
            if(cookie.getName().equals("username") || cookie.getName().equals("password")){//找到对应的cookie
                cookie.setMaxAge(0);//Cookie并不能根本意义上删除，只需要这样设置为0即可
                cookie.setPath("/");//很关键，设置成跟写入cookies一样的，全路径共享Cookie
                response.addCookie(cookie);//重新响应
                System.out.println("清除cookie信息");
            }
            System.out.println("遍历");
            System.out.println(cookie.getName());
        }

        return "success";
    }

    /**
     * 发送验证码到用户邮箱,返回生成的验证码
     * @param toEmailAddress
     */
    public void sendVerificationCode(String toEmailAddress){
        MailUtils.sendMail(toEmailAddress, ,"晴川音乐");
    }

    /**
     * 修改密码
     * @param newPassword
     * @param email
     * @param password
     *
     * 修改密码前先获取当前用户邮箱，后台随机生成六位验证码存储下来并发送到用户邮箱，前端获取验证码按钮禁用60s。用户提交
     * 修改后，将传过来的验证码与后端生成的验证码比对，相同则执行更新操作。
     */
    @RequestMapping("/resPassword")
    @ResponseBody
    public void resPassword(String newPassword, String email, String password){
        try {
            int result = userService.modifyPasswordByEmail(newPassword, email, password);
            if (result == 1){
                new JsonResult(200, "密码修改成功");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}

