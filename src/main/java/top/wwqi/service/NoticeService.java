package top.wwqi.service;

import top.wwqi.entity.Notice;

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
}
