package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 *  用户信息
 */
@Getter
@Setter
public class Users  implements Serializable {
    private int u_id;//用户id
    private String u_name;//用户名唯一
    private String u_pwd;//登陆密码
    private String u_phone;//手机号码
    private String u_pay_pwd;//支付密码
    private Date u_record_date;//注册时间
    private String u_type;//用户类型1：普通会员，2：超级管理员
    //新加列
    private String u_sex;//性别
    private String u_email;//邮箱
        private String u_address;//地址
    private String u_remark;//备注

}
