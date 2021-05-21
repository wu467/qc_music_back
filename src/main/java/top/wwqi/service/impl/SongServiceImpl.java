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
        return allSong;
    }

    /**
     * 收藏歌曲
     * @param song
     * @return
     */
    @Override
    public int collect(Song song) {
        // 收藏歌曲前先根据songMid查询数据库中是否已存在该歌曲
        Integer songId = songMapper.findBySongMid(song.getSongMid());
        System.out.println("搜索的songid："+songId);
        if (songId == null) {
            songMapper.collect(song);
            return -1;      // 不存在则返回 -1
        }
        return songId;      // 存在则返回歌曲 songId
    }

    /**
     * 取消收藏歌曲
     * 根据songMid查询出song_id，再通过传过来的user_id在表song2user中删除匹配的数据
     * @return
     */
    @Override
    public void cancelCollect(int userId, int songId) {
        try {
            songMapper.delCollect(userId,songId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 中间表插入数据
     * @param songId
     * @param userId
     */
    @Override
    public void insertSong2user(int songId, int userId) {
        songMapper.insertSong2user(userId, songId);
    }

    /**
     * 从数据库中间表查询,1表示用户已收藏，0表示没有收藏
     * @param userId
     * @param songId
     * @return
     */
    @Override
    public int findByMiddle(int userId, int songId) {
        System.out.println(userId +"  "+ songId);
        Integer midId = songMapper.findByMiddle(userId, songId);
        System.out.println("midId为：   "+midId);
        if (midId == null){
            return 0;
        }
        return 1;
    }
}
