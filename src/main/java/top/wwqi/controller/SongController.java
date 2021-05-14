package top.wwqi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
     * @param userId  用户主键
     * @param songMid  歌曲songMid
     * @return
     */
    @RequestMapping("/favoriteSong")
    @ResponseBody
    public JsonResult favoriteSong(@RequestParam("userId")int userId, @RequestParam("songMid")String songMid) {
        Song song = new Song(songMid);
        int res = songService.collect(song);  //数据库表song中存在该歌曲则返回歌曲id，不存在则返回 -1
        if (res == -1) {
            songService.insertSong2user(song.getSongId(), userId);
        } else {
            songService.insertSong2user(res, userId);
        }
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
        return new JsonResult(allSong,"返回所有歌曲");
    }

    /**
     * 取消收藏歌曲
     * @param userId
     * @param songMid
     * @return
     */
    @RequestMapping("/cancelFavoriteSong")
    @ResponseBody
    public JsonResult cancelFavoriteSong(int userId, String songMid) {
        songService.cancelCollect(userId, songMid);

        return new JsonResult("200","取消收藏成功");
    }
}
