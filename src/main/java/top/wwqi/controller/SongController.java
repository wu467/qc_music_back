package top.wwqi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.wwqi.model.entity.Song;
import top.wwqi.service.SongService;
import top.wwqi.utils.api.JsonResult;

import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private SongService songService;

    /**
     * 收藏歌曲
     * @param songMid 歌曲的唯一标识
     * @param userId 用户的主键
     * @return
     *
     */
    @RequestMapping("/favoriteSong")
    @ResponseBody
    public JsonResult favoriteSong(int userId, String songMid) {
        Song song = new Song(songMid);
        songService.collect(song);
        System.out.println("测试===songId: "+song.getSongId());
        songService.insertSong2user(song.getSongId(), userId);

        return new JsonResult("200","收藏成功！");
    }

    /**
     * 返回用户所有收藏歌曲
     * @param userId
     * @return
     */
    @RequestMapping("/allFavoriteSong")
    @ResponseBody
    public JsonResult<List<Song>> allFavoriteSong(int userId) {
        List<String> allSong = songService.findAllSong(userId);
        return new JsonResult(allSong,"全部收藏歌曲");
    }

    /**
     * 取消收藏歌曲
     * @return
     */
    @RequestMapping("/cancelFavoriteSong")
    @ResponseBody
    public JsonResult cancelFavoriteSong() {

        return new JsonResult("200","取消收藏成功");
    }
}
