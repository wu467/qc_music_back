package top.wwqi.utils;

import java.util.Random;

/**
 * 生成六位随机验证码
 */
public class RandomCodeUtil {

    //生成的验证码
    private String yzm;

    public static String getRandom(){
        String code = "";
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int r = random.nextInt(10); //每次随机出一个数字（0-9）
            code = code + r;  //把每次随机出的数字拼在一起
        }
        return code;

    }

}
