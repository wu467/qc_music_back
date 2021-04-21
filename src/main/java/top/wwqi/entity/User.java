package top.wwqi.entity;

import java.util.List;

/**
 *  普通用户实体
 *  与Song为多对多关系
 */
public class User {
    private Integer userId;
    private String userName;
    private String userEmail;
    private String password;
    private List<Song> songList;    //该用户收藏的所有歌曲
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

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }
}
