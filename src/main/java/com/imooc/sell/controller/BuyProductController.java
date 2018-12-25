package com.imooc.sell.controller;

import com.imooc.sell.VO.ProductInfoVO;
import com.imooc.sell.VO.ProductVO;
import com.imooc.sell.VO.ResultVO;
import com.imooc.sell.dataobject.ProductCategory;
import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.service.IProductCategoryService;
import com.imooc.sell.service.ProductService;
import com.imooc.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
public class BuyProductController {

     @Autowired
     private ProductService productService;

    @Autowired
    private IProductCategoryService categoryService;
    @GetMapping("/list")
    public  ResultVO list(){
        //1，查询所有的上架商品
        List<ProductInfo>  productInfos = productService.findUpAll();

        //2，查询类目（一次性查询）
//        List<Integer> cateTypeList = new ArrayList<>();
        //传统方法
//        for(ProductInfo productInfo : productInfos){
//            cateTypeList.add(productInfo.getCategoryType());
//        }

        //精简方法(java 8,lambda)
        List<Integer> cateTypeList = productInfos.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategories = categoryService.findByCategoryTypeIn(cateTypeList);

        //3 数据拼装
        /**
         *  1. 查出所有商品类目
         *  2.
         */
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory: productCategories){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());


            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo : productInfos){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }



        return ResultVOUtil.success(productVOList);
//        List<ProductInfoVO> productInfoList = new ArrayList<>();
//        productInfoList.add(productInfoVO);
//        productVO.setProductInfoVOList(productInfoList);
//
//
//        resultVO.setData(productVO);



    }

}
