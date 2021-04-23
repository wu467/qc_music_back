package top.wwqi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wwqi.dao.NoticeMapper;
import top.wwqi.entity.Notice;
import top.wwqi.service.NoticeService;

import java.util.List;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;  //注入mapper对象

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
//        System.out.println("Service层，删除系统通知id:"+notice_Id);
    }

    @Override
    public List<Notice> findAllNotice() {
        List<Notice> list = noticeMapper.findAllNotice();
        return list;
    }
}
