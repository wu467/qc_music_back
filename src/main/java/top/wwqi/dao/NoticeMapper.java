package top.wwqi.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.wwqi.model.entity.Notice;

import java.util.List;

/**
 * 系统通知的mapper
 */
@Repository
public interface NoticeMapper {

    /**
     * 添加系统通知
     * @param notice    //notice对象
     */
    @Insert("insert into notice (content, showNotice) values (#{n.content}, #{n.showNotice})")
    void insertNotice(@Param("n") Notice notice);


    /**
     * 删除系统通知
     * @param notice_Id //通知id
     * @return
     */
    @Delete("delete from notice where id = #{notice_id}")
    Integer delNotice(@Param("notice_id")int notice_Id);

    /**
     * 获取所有系统通知
     * @return
     */
    @Select("select * from notice")
    List<Notice> findAllNotice();
}
