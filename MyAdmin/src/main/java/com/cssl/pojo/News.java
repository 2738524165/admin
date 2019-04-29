package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 商城快讯表
 */
@Setter
@Getter
public class News implements Serializable {
    private int n_id;//新闻id
    private String n_title;//标题
    private Date  n_time;//发布时间
    private String n_content;//内容

}
