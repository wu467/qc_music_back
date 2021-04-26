package top.wwqi.model.entity;

import java.io.Serializable;

/**
 *  普通用户实体
 *  与Song为多对多关系
 */
public class User implements Serializable {
    private static final long serialVersionUID = -7671703873445055025L;
    private Integer userId;
    private String userName;
    private String userEmail;
    private String password;
    private String userPortraitPath; //存储头像的项目路径
    private Boolean userRole = false; //普通用户和管理员的标识，非数据库字段。true表示admin

    public User() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserPortraitPath() {
        return userPortraitPath;
    }

    public void setUserPortraitPath(String userPortraitPath) {
        this.userPortraitPath = userPortraitPath;
    }

    public Boolean getUserRole() {
        return userRole;
    }

    public void setUserRole(Boolean userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", password='" + password + '\'' +
                ", userPortraitPath='" + userPortraitPath + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}
