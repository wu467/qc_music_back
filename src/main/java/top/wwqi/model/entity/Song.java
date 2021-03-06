package top.wwqi.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 歌曲实体类
 * 与User为多对多关系
 */
public class Song implements Serializable {
    private static final long serialVersionUID = -3403484846021090945L;
    private Integer songId;  //主键
    private String songMid;  //歌曲唯一标识
    private List<User> allUser;  //收藏该歌曲的所有用户

    public Song(String songMid) {
        this.songMid = songMid;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public String getSongMid() {
        return songMid;
    }

    public void setSongMid(String songMid) {
        this.songMid = songMid;
    }

    public List<User> getAllUser() {
        return allUser;
    }

    public void setAllUser(List<User> allUser) {
        this.allUser = allUser;
    }
}
