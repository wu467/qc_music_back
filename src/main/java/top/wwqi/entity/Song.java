package top.wwqi.entity;

import java.util.List;

/**
 * 歌曲实体类
 * 与User为多对多关系
 */
public class Song {
    private Integer songId;  //主键
    private String songMid;  //歌曲唯一标识
    private List[] allUser;  //收藏该歌曲的所有用户

    public Song() {
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

    public List[] getAllUser() {
        return allUser;
    }

    public void setAllUser(List[] allUser) {
        this.allUser = allUser;
    }
}
