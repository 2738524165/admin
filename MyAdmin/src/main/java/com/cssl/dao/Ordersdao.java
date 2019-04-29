package com.cssl.dao;

import com.cssl.pojo.Orders;

import java.util.List;
import java.util.Map;

/**
 *订单表
 */
public interface Ordersdao {
    /**
     * 统计订单
     * @return
     */
    public  int countOrders();

    /**
     * 统计金额
     * @return
     */
    public String countjine();


    /**
     * 显示订单信息
     * @return
     */
    public List<Orders> showorders(Map<String,Object> map);


    /**
     * 根据订单查询数据
     * @param id
     * @return
     */
    public Orders ddxgcs(String id);


    /**
     * 修改信息
     * @param o
     * @return
     */
    public int ddupdate(Orders o);


    /**
     * 查询订单表是否有商品有的话不能删除
     * @param cyid
     * @return
     */
    public int countorders_details(int cyid);


}
