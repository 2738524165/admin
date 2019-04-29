package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 品牌信息表
 */
@Setter
@Getter
public class Flat implements Serializable {
    private int f_id;//品牌编号
    private String f_name;//品牌名称
    private int oc_id;//一级分类id
    private String f_image;//品牌图片
}
