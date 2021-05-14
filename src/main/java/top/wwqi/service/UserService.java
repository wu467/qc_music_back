package top.wwqi.service;

import org.springframework.stereotype.Repository;
import top.wwqi.model.dto.LoginDTO;
import top.wwqi.model.dto.RegisterDTO;
import top.wwqi.model.entity.User;
import top.wwqi.utils.api.JsonResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Repository
public interface UserService {

    /**
     * 执行用户注册
     * @param dto
     * @return
     */
    JsonResult executeRegister(RegisterDTO dto);

    /**
     * 用户登录
     * @param dto
     * @param request
     * @param response
     * @return
     */
    JsonResult executeLogin(LoginDTO dto, HttpServletRequest request, HttpServletResponse response);

    /**
     * 检查用户注册时邮箱是否重复
     * @param emailAddress
     * @return
     */
    int checkEmail(String emailAddress);


}
