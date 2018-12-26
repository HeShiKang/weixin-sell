package com.imooc.sell.repository;


import com.imooc.sell.dataobject.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("12356789");
        orderDetail.setOrderId("111111111");
        orderDetail.setProductIcon("4546546556");
        orderDetail.setProductId("12313213");
        orderDetail.setProductPrice(new BigDecimal(123));
        orderDetail.setProductName("狗子");
        orderDetail.setProductQuantity(12);
        OrderDetail result = repository.save(orderDetail);

    }
    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetailList = repository.findByOrderId("111111111");
    }
}
