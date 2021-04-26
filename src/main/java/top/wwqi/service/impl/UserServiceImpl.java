package top.wwqi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import top.wwqi.dao.UserMapper;
import top.wwqi.model.dto.LoginDTO;
import top.wwqi.model.dto.RegisterDTO;
import top.wwqi.model.entity.User;
import top.wwqi.service.UserService;
import top.wwqi.utils.api.JsonResult;

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
        User user1 = userMapper.findByName(dto.getName());
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
    public JsonResult<User> executeLogin(LoginDTO dto) {
        // 查询用户名及密码是否匹配
        User user = userMapper.findUser(dto);
        System.out.println("测试前：" + dto);
        if (StringUtils.isEmpty(user)) {
            return new JsonResult("300","登陆失败");
        }
        return new JsonResult(user,"登录成功！");
    }


}
