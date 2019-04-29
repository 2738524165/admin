package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品评论表
 */
@Setter
@Getter
public class Discuss implements Serializable {
    private  int d_id;//评论id
    private String d_content;//评论内容
    private int u_id;//评论人id
    private  int cy_id;//评论商品id
    private  int d_star;//评论的星星有多少颗
    private Date d_time;//评论的时间
    private int d_bepraised;//评论被赞的次数
    private int d_isanonymous;//是否匿名评论1：是匿名评论2：不是匿名评论
    private int d_parent;//评论的父id
}
