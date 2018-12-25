package com.imooc.sell.dataobject;



import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 类目
 */
@Entity
@DynamicUpdate      //动态更新，create,upatetime 不用这个属性update时间不会动态改变
@Data       //包含生成get。set toString 方法
public class ProductCategory {
    /** 类目Id。*/
    @Id
    @GeneratedValue
    private Integer categoryId;

    /** 类目名字 */
    private String categoryName;

    /** 类目编号 .*/
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;


}
