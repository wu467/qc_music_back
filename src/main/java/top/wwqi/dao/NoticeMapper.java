package top.wwqi.dao;

import top.wwqi.entity.Notice;

/**
 * 系统通知的mapper
 */
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
}
