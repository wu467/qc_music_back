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
    public JsonResult register(@RequestParam("registerDTO")String dto,  HttpServletRequest request) {
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
