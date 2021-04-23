package top.wwqi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.wwqi.entity.Notice;
import top.wwqi.service.NoticeService;

import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping("findAllNotice")
    public String testSpringMVC(Model model){
        System.out.println("表现层查询所有歌曲");

        //调用service的方法
        List<Notice> list = noticeService.findAllNotice();
        model.addAttribute("list",list);

        return "success";
    }
}
