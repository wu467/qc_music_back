package top.wwqi.service;

import top.wwqi.model.entity.Song;

import java.util.List;

/**
 * 歌曲Service
 */
public interface SongService {

    /**
     * 返回用户所有歌曲
     *
     * @return
     */
    List<String> findAllSong(int userId);

    /**
     * 收藏歌曲
     *
     * @return  歌曲
     */
    int collect(Song song);

    /**
     * 取消收藏歌曲
     *
     * @return
     */
    void cancelCollect(int userId, int songId);

    /**
     * 中间表插入数据
     * @param songId
     * @param userId
     */
    void insertSong2user(int songId, int userId);
}
