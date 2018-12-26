package com.imooc.sell.utils;

import java.util.Random;

public class KeyUtil {

    /*
            生成唯一的住家
            格式：时间+随机数
     */
    public static synchronized  String genUniqueKey(){
        Random random = new Random();



        Integer number = random.nextInt(900000)+10;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
