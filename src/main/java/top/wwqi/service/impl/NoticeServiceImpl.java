package top.wwqi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wwqi.dao.NoticeMapper;
import top.wwqi.model.entity.Notice;
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
        Boolean isShow; //是否显示通知
        try {
            noticeMapper.insertNotice(notice);
            System.out.println("Service层，添加系统通知");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("通知添加失败");
        }
    }

    /**
     * 根据通知id删除setTimer() {
     *                 if(this.timer == null) {
     *                     this.timer = setInterval( () => {
     *                         console.log('开始定时...每过一秒执行一次')
     *                     }, 1000)
     *                 }
     *             }
     * ————————————————
     * @param notice_id 系统通知id
     */
    @Override
    public void delNotice(int notice_id) {
        System.out.println("Service层，删除系统通知id:"+notice_id);

        try {
            noticeMapper.delNotice(notice_id);
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("删除失败");
        }
    }

    /**
     * 查找所有系统通知
     * @return
     */
    @Override
    public List<Notice> findAllNotice() {
        List<Notice> list = noticeMapper.findAllNotice();
        return list;
    }
}
