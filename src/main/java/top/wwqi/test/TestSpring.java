package top.wwqi.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.*;
import org.testng.annotations.Test;
import top.wwqi.service.NoticeService;

public class TestSpring {

    /**
     * 测试spring是否搭建成功
     */
    @Test
    public void test1(){
        //加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //获取对象
        NoticeService ns = (NoticeService) ac.getBean("noticeService");
        //调用方法
        ns.delNotice(1);
    }
}
