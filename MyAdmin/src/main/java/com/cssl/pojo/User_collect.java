package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 用户收藏表
 */
@Setter
@Getter
public class User_collect implements Serializable {
    private int c_id;//收藏信息id
    private int c_pid;//收藏的商品id
    private int um_id;//收藏的店铺id
    private int u_id;//用户id
}
