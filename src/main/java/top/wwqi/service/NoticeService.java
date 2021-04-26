package top.wwqi.service;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.wwqi.model.entity.Notice;

import java.util.List;

@Repository
public interface NoticeService {
    /**
     * 添加系统通知
     * @return
     */
    void insertNotice(Notice notice);

    /**
     * 删除系统通知
     * @return
     */
    void delNotice(int notice_Id);

    /**
     * 获取所有系统通知
     * @return
     */
    @Select("select * from notice")
    List<Notice> findAllNotice();
}
