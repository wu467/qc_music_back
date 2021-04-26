package top.wwqi.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.wwqi.model.dto.LoginDTO;
import top.wwqi.model.dto.RegisterDTO;
import top.wwqi.model.entity.User;

/**
 * 用户的mapper
 */
@Repository
public interface UserMapper {

    /**
     * 通过用户名查找用户
     * @param name
     * @return
     */
    @Select("select * from user where userName = #{name}")
    User findByName(@Param("name")String name);

    /**
     * 通过邮箱查找用户
     * @param email
     * @return
     */
    @Select("select * from user where userEmail = #{email}")
    User findByEmail(@Param("email")String email);


    /**
     * 登录时核对信息
     * @param dto 前端传过来的登录对象
     * @return
     */
    @Select("select * from user where userName = #{dto.name} and password = #{dto.password}")
    User findUser(@Param("dto") LoginDTO dto);

    /**
     * 注册 添加用户
     * @param dto
     */
    @Insert("insert into user (userName,userEmail,password,userRole) values (#{dto.name}, #{dto.email}, #{dto.password}, 0)")
    void insertUser(@Param("dto")RegisterDTO dto);
}
