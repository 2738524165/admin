package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 商品详情信息表
 */
@Setter
@Getter
public class Cdetails implements Serializable {
    private  int cs_id;//商品详情id
    private  String cs_version ;//商品版本
    private  String cs_frontcamera ;//前置摄像头
    private  String cs_rearcamera ;//后置摄像头
    private  String cs_resolution ;//分辨率
    private  String cs_size ;//尺寸
    private  String cs_system ;//系统
    private  int cy_id ;//商品id
    private  float cy_weight ;//重量
}
