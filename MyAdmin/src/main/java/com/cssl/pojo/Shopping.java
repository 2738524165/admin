package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 购物车表
 */
@Setter
@Getter
public class Shopping implements Serializable {
    private  int sp_id ;//购物车id
    private int cy_id;//商品id
    private  int sp_quantity;//数量
    private  int u_id;//用户id
}
