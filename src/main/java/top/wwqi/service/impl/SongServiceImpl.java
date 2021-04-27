package top.wwqi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wwqi.dao.SongMapper;
import top.wwqi.model.entity.Song;
import top.wwqi.service.SongService;

import java.util.List;

/**
 * 歌曲Service实现
 */
@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongMapper songMapper;

    /**
     * 返回用户所有收藏歌曲
     * @param userId
     * @return
     */
    @Override
    public List<String> findAllSong(int userId) {
        List<String> allSong = songMapper.findAllSong(userId);
        return null;
    }

    /**
     * 收藏歌曲
     * @param song
     * @return
     */
    @Override
    public void collect(Song song) {
        songMapper.collect(song);
    }

    /**
     * 取消收藏歌曲
     * @return
     */
    @Override
    public Integer cancelCollect() {
        return null;
    }

    /**
     * 中间表插入数据
     * @param songId
     * @param userId
     */
    @Override
    public void insertSong2user(Integer songId, int userId) {
        songMapper.insertSong2user(userId, songId);
    }
}
