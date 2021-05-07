package top.wwqi.dao;

import org.apache.ibatis.annotations.*;
import top.wwqi.model.entity.Song;

import java.util.List;

/**
 * 歌曲 mapper
 */
public interface SongMapper {

    /**
     * 通过songMid查询歌曲sing_id
     * @param songMid
     * @return
     */
    @Select("SELECT songId FROM song WHERE songMid = #{songMid}")
    Integer findBySongMid(String songMid);

    /**
     * 返回所有收藏歌曲的songMid歌曲
     *
     * @return 歌曲集合
     */
    @Select("SELECT songMid FROM song2user, song WHERE song2user.song_id=song.songId AND song2user.user_id=#{userId}")
    List<String> findAllSong(int userId);

    /**
     * 收藏歌曲
     * 先将收藏的歌曲添加到表 song 中，然后获取song表的主键songId，
     * 再将songId和userId插入到关系表song2user中。
     * @return  歌曲
     */
    // 设置useGeneratedKeys为true，返回数据库自动生成的记录主键id
    @Options(useGeneratedKeys = true, keyProperty = "s.songId", keyColumn = "songId")
    @Insert("INSERT INTO song (songMid) VALUES (#{s.songMid}) ")
    void collect(@Param("s")Song song);

    /**
     * 取消用户收藏歌曲
     * @param songId
     * @param userId
     */
    @Delete("DELETE FROM song2user WHERE song_id=#{songId} AND user_id=#{userId}")
    void delCollect(@Param("songId") Integer songId, @Param("userId") int userId);

    /**
     * 中间表插入数据
     * 当方法的参数为两个及以上时就需要注解@Param("")来区分
     * @param userId
     * @param songId
     */
    @Insert("INSERT INTO song2user (song_id, user_id) VALUES (#{songId}, #{userId})")
    void insertSong2user(@Param("userId")int userId, @Param("songId") int songId);


}
