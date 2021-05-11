package top.wwqi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.wwqi.model.dto.LoginDTO;
import top.wwqi.model.dto.RegisterDTO;
import top.wwqi.model.entity.User;
import top.wwqi.service.UserService;
import top.wwqi.utils.api.JsonResult;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

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
    public JsonResult<User> login(@RequestParam("loginDTO")String dto, HttpServletRequest request, HttpServletResponse response){
        System.out.println(dto);
        ObjectMapper mapper = new ObjectMapper();
        LoginDTO login = null;
        try {
            login = mapper.readValue(dto, LoginDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonResult<User> result = userService.executeLogin(login, request, response);

        //获取所有请求头名称
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            //根据名称获取请求头的值
            String value = request.getHeader(name);
            System.out.println(name+"---"+value);
        }

        return result;
    }


    /**
     * 注册时，验证邮箱是否已存在
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
    public String signOut(HttpSession session){
        session.removeAttribute("user");
        System.out.println(session.getAttributeNames());
        session.invalidate();
        return "redirect:/login";
    }

    /**
     * 上传头像
     */
    public void uploadAvatar(){

    }

    /**
     * 修改密码
     */
    public void resPassword(){

    }





}
