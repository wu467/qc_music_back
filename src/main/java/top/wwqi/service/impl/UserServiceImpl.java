package top.wwqi.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import top.wwqi.dao.UserMapper;
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
import java.net.URLEncoder;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 注册用户
     * @param dto 前端注册页传过来的注册对象
     * @return
     */
    @Override
    public JsonResult executeRegister(RegisterDTO dto) {
        // 查询是否有相同的用户名或email
        User user1 = userMapper.findByName(dto.getUserName());
        User user2 = userMapper.findByEmail(dto.getEmail());

        if (!StringUtils.isEmpty(user1)) {
            return new JsonResult("300","注册失败，用户名已注册");
        } else if (!StringUtils.isEmpty(user2)) {
            return new JsonResult("300","注册失败，邮箱已注册");
        }
        // 执行注册
        userMapper.insertUser(dto);
        return new JsonResult("200","注册成功");
    }

    /**
     * 用户登录
     * @param dto
     * @return
     */
    @Override
    public JsonResult executeLogin(LoginDTO dto, HttpServletRequest request, HttpServletResponse response) {
        JsonResult result = new JsonResult<>();
        // 查询用户名及密码是否匹配
        User user = userMapper.findByName(dto.getUserName());
        System.out.println("测试前：" + dto);
        if (StringUtils.isEmpty(user)) {
            result.setCode(0);
            result.setMsg("用户名不存在！");
            return result;
        } else if (!user.getPassword().equals(dto.getPassword())) {
            result.setCode(0);
            result.setMsg("密码错误！");
            return result;
        } else {
            // 登陆成功
            result.setCode(200);
            result.setData(user);
            result.setMsg("登录成功");
            System.out.println("登录成功");
            System.out.println(result.getData());
            // 是否记住我
//          String rememberme = request.getParameter("rememberme");

            // 添加session
            request.getSession().setAttribute("user", user);

            //添加cookie
            //创建Cookie对象。并设置编码为utf8，解决存入cookie乱码问题
            Cookie nameCookie = null;
            Cookie idCookie = null;
            try {
                nameCookie = new Cookie("username", URLEncoder.encode(user.getUserName(), "UTF-8"));
                idCookie = new Cookie("userId", URLEncoder.encode(user.getUserId().toString(), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            // 设置可以通过程序（js脚本、applet等）获取cookie
            nameCookie.setHttpOnly(false);
            idCookie.setHttpOnly(false);
            //设置Cookie的有效期为1天
            nameCookie.setMaxAge(60 * 60 * 24);
            idCookie.setMaxAge(60 * 60 * 24);
            //设置根目录下的所有目录都可以共享信息
            nameCookie.setPath("/");
            idCookie.setPath("/");
            //响应给浏览器添加的cookie
            response.addCookie(idCookie);
            response.addCookie(nameCookie);

            return result;
        }
    }


    /**
     * 用户注册时验证邮箱是否已被注册
     * @param emailAddress  前端传过来的注册邮箱
     * @return
     */
    @Override
    public int checkEmail(String emailAddress) {
        User user = userMapper.findByEmail(emailAddress);
        if (StringUtils.isEmpty(user)){
            return 0;
        }
        return 1;
    }



}
