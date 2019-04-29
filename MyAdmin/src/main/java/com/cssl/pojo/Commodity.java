package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品信息表
 */
@Setter
@Getter
public class Commodity implements Serializable {
    private int cy_id;//商品id
    private String cy_name;//商品名称
    private String cy_introduction;//商品介绍
    private float cy_price;//商品价格
    private  int cy_sales;//商品销量
    private int cy_inventory;//商品库存
    private float cy_discount;//折扣
    private Date cy_shelftime;//上架时间
    private  String cy_placeoforigin;//产地
    private  int tc_id;//分类内容id
    private int um_id;//商家id
}
