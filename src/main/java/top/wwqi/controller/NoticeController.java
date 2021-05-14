package top.wwqi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.wwqi.model.entity.Notice;
import top.wwqi.service.NoticeService;
import top.wwqi.utils.api.JsonResult;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    /**
     * 查找所有系统通知
     * @return
     */
    @RequestMapping("findAllNotice")
    @ResponseBody
    public JsonResult<List<Notice>> findAllNotice(HttpServletRequest request){
        System.out.println("表现层查询所有系统通知 test");
        //调用service的方法
        List<Notice> list = noticeService.findAllNotice();

        //获取cookie
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length > 0){
            System.out.println("------------系统通知------------");
            for (Cookie cookie : cookies){
                try {
                    System.out.println(URLDecoder.decode(cookie.getName(), "UTF-8")  + "-----" + URLDecoder.decode(cookie.getValue(),"UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }

        return new JsonResult<>(list,"查询所有通知");
    }

    /**
     * 添加系统通知
     * @param notice
     * @return
     */
    @RequestMapping("insertNotice")
    @ResponseBody
    public JsonResult insertNotice(Notice notice){
        System.out.println("表现层 插入 系统通知");
        String content = notice.getContent();
        Boolean showNotice = notice.getShowNotice();
        //调用service的方法
        noticeService.insertNotice(notice);
        return new JsonResult(200,"添加成功");
    }

    /**
     * 删除系统通知
     * @param id 系统通知id
     * @return
     */
    @RequestMapping("delNotice")
    @ResponseBody
    public JsonResult deleteNotice(int id){
        //调用service的方法
        noticeService.delNotice(4);
        return new JsonResult(200,"删除成功");
    }


}
