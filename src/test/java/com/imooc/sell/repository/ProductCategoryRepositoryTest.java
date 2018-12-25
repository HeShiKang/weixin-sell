package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest(){
        ProductCategory productCategory = repository.findOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    public void savaTest(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("女生最爱");
        productCategory.setCategoryType(3);
        repository.save(productCategory);
    }
    @Test
    @Transactional  //回滚，测试完将测试数据删除
    public void updateTest(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(2);
        productCategory.setCategoryName("男生生最爱");
        productCategory.setCategoryType(3);
        repository.save(productCategory);
    }
    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(2, 3, 4);

    }
}