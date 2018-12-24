package com.imooc.sell;

import lombok.extern.slf4j.*;
import lombok.extern.slf4j.XSlf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j

public class LoggerTest2 {
    @Test
    public void test1(){
//        log.debug("debug...");           //debug不会输出  debug级别低于info
//        log.info("info.....");           //系统默认的日志级别是info，在info之上的就能输出出来
//        log.error("errot...");
        String name = "imooc";
        String password = "123456";
        log.info("name: "+name+", password"+password);
        log.info("name:{},password:{}",name,password);

    }
}
