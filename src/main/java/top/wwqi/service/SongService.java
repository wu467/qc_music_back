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
    List<Song> findAllSong();

    /**
     * 收藏歌曲
     *
     * @return  歌曲
     */
    Integer collect();

    /**
     * 取消收藏歌曲
     *
     * @return
     */
    Integer cancelCollect();
}
