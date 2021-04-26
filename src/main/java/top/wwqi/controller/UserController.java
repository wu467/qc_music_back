package top.wwqi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.wwqi.model.dto.LoginDTO;
import top.wwqi.model.dto.RegisterDTO;
import top.wwqi.model.entity.User;
import top.wwqi.service.UserService;
import top.wwqi.utils.api.JsonResult;

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
    public JsonResult register(RegisterDTO dto) {
        JsonResult result= userService.executeRegister(dto);
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




}
