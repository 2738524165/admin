package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 订单详情表
 */
@Setter
@Getter
public class Orders_details implements Serializable {
    private int od_id;//详情id
    private String o_number;//订单号
    private int cy_id;//商品id
    private float od_pirce;//价格
    private  int od_quantity;//购买数量
}
