package com.imooc.sell.repository;


import com.imooc.sell.dataobject.ProductInfo;
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
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123465");
        productInfo.setProductName("皮蛋粥");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("超级好喝的周");
        productInfo.setProductIcon("htto://xxxxx.jphg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);

        ProductInfo result = repository.save(productInfo);
    }
    @Test
    public void findByProductStatus() throws Exception{
        List<ProductInfo> productInfoList = repository.findByProductStatus(0);
        System.out.println(productInfoList);
    }
}
