package top.wwqi.dao;

import top.wwqi.model.entity.Song;

import java.util.List;

/**
 * 歌曲 mapper
 */
public interface SongMapper {

    /**
     * 返回所有歌曲
     *
     * @return 歌曲集合
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
