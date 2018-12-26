package com.imooc.sell.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"库存不正确")
    ;

    private Integer code;

    private String msg;

    ResultEnum(int i, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
