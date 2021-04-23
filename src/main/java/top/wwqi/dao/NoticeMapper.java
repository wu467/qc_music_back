package top.wwqi.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.wwqi.entity.Notice;

import java.util.List;

/**
 * 系统通知的mapper
 */
@Repository
public interface NoticeMapper {

    /**
     * 添加系统通知
     * @return
     */
    void insertNotice(Notice notice);

    /**
     * 删除系统通知
     * @return
     */
    Integer delNotice(Integer notice_Id);

    /**
     * 获取所有系统通知
     * @return
     */
    @Select("select * from notice")
    List<Notice> findAllNotice();
}
