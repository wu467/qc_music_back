package top.wwqi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.wwqi.utils.api.JsonResult;

@Controller
@RequestMapping("songs")
public class SongController {

    /**
     * 收藏歌曲
     * @param songMid 歌曲的唯一标识
     * @return
     */
    @RequestMapping("/favoriteSong")
    @ResponseBody
    public JsonResult favoriteSong(String songMid) {

        return new JsonResult("200","收藏成功！");
    }

    /**
     * 返回所有收藏歌曲
     * @return
     */
    @RequestMapping("/allFavoriteSong")
    @ResponseBody
    public JsonResult allFavoriteSong() {

        return new JsonResult("200","全部返回");
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
