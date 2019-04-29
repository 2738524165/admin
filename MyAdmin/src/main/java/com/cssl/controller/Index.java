package com.cssl.controller;

import com.cssl.pojo.Users;
import com.cssl.service.Userservice;
import com.cssl.serviceimpl.Ordersserviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;


/**
 * 首页相关
 */
@Controller
public class Index {

    @Autowired
    private Userservice userservice; //用户
    @Autowired
    private Ordersserviceimpl orderdao; //订单

    /**
     * 统计页面数据
     * @param request
     * @return
     */
    @RequestMapping("/aa")
    public String wdzm(HttpServletRequest request){
        //获取系时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        request.getSession().setAttribute("shijin",df.format(System.currentTimeMillis()));
        //统计用户数量 存入session
        request.getSession().setAttribute("countyonghu", userservice.countyong());
        //统计订单数量 存入session
        request.getSession().setAttribute(  "countOrders" , orderdao.countOrders());
        //统计总金额 存入session
        request.getSession().setAttribute(  "countjine" ,  orderdao.countjine()==null?0:orderdao.countjine() );
        return "wdzm.html";
    }

    /**
     * 查询index个人信息
     * @return
     */
    @RequestMapping("/xinxi")
    public String chaxinxinxi(HttpServletRequest request){
        Users name=(Users) request.getSession().getAttribute("u");
        request.getSession().setAttribute("xinxius", userservice.xinxi(name.getU_name()));//保存session
        return "admin-show.html";
    }


}
