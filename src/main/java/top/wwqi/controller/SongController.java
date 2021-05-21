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
     * 收藏歌曲和取消收藏歌曲
     * @param userId  用户主键
     * @param songMid  歌曲songMid
     * @return
     */
    @RequestMapping("/favoriteSong")
    @ResponseBody
    public JsonResult favoriteSong(@RequestParam("userId")int userId, @RequestParam("songMid")String songMid) {
        Song song = new Song(songMid);
        int songId = songService.collect(song);  //数据库表song中存在该歌曲则返回歌曲id，不存在则返回 -1
        System.out.println("SongController 返回的res2的结果为：   "+songId);
        if (songId == -1) {
            songService.insertSong2user(song.getSongId(), userId);
        } else {
            System.out.println("到else中来了");
            int res2 = songService.findByMiddle(userId, songId);    //向中间表查询看此用户是否已收藏此歌曲, 1用户已收藏， 0表示用户没收藏
            System.out.println("controller 返回的res2的结果为：   "+res2);
            if (res2 == 1) {
                //此时用户是取消收藏，中间表删除userId和songId所对应的数据
                songService.cancelCollect(userId, songId);
                return new JsonResult("201", "进行取消收藏");
            }
            // 向表中插入数据
            songService.insertSong2user(songId, userId);
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
    public JsonResult<List<Song>> allFavoriteSong(@RequestParam("userId")int userId) {
        List<String> allSong = songService.findAllSong(userId);
        return new JsonResult(allSong,"返回所有歌曲");
    }

}
