package top.wwqi.service.impl;

import org.springframework.stereotype.Service;
import top.wwqi.entity.Notice;
import top.wwqi.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {

    /**
     * 添加系统通知
     */
    @Override
    public void insertNotice(Notice notice) {
        System.out.println("Service层，添加系统通知");
    }

    /**
     * 根据通知id删除
     * @param notice_Id
     */
    @Override
    public void delNotice(int notice_Id) {
        System.out.println("Service层，删除系统通知");

    }
}
