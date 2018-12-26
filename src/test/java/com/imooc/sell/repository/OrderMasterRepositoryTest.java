package com.imooc.sell.repository;


import com.imooc.sell.dataobject.OrderMaster;
import org.aspectj.weaver.ast.Or;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository repository;

    private final  String OPENID = "110110";
    @Test
    public  void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setBuyerName("烧鸡");
        orderMaster.setOrderId("12346556");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerPhone("123145649875");
        orderMaster.setBuyerAddress("imooc");
        orderMaster.setBuyerOpenid("110110");
        orderMaster.setOrderAmount(new BigDecimal(23));
        OrderMaster result = repository.save(orderMaster);
    }

    @Test
    public void findByBuyerOpenid() throws  Exception{
        PageRequest request = new PageRequest(0,3);

        Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID,request);

    }
}
