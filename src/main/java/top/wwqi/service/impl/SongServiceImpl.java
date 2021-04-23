package top.wwqi.service.impl;

import org.springframework.stereotype.Service;
import top.wwqi.entity.Song;
import top.wwqi.service.SongService;

import java.util.List;

/**
 * 歌曲Service实现
 */
@Service
public class SongServiceImpl implements SongService {

    @Override
    public List<Song> findAllSong() {
        System.out.println("查找所有歌曲");
        return null;
    }

    @Override
    public Integer collect() {
        return null;
    }

    @Override
    public Integer cancelCollect() {
        return null;
    }
}
