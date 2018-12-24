package com.imooc.sell;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggerTest {

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /*
     *  要使用日志先定义一个类
     */
    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);    //使用类的声明
    @Test
    public void test1(){
        logger.debug("debug...");           //debug不会输出  debug级别低于info
        logger.info("info.....");           //系统默认的日志级别是info，在info之上的就能输出出来
        logger.error("errot...");
    }
    //更简便的@SLF4j见loggerTest2
}
