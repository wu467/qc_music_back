package top.wwqi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.wwqi.model.dto.LoginDTO;
import top.wwqi.model.dto.RegisterDTO;
import top.wwqi.model.entity.User;
import top.wwqi.service.UserService;
import top.wwqi.utils.api.JsonResult;

import java.io.IOException;

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
    public JsonResult<User> login(LoginDTO dto){
        JsonResult<User> result = userService.executeLogin(dto);
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
    public JsonResult signOut(){

        return null;
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
