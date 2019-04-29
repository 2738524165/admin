package com.cssl.serviceimpl;

import com.cssl.dao.Ordersdao;
import com.cssl.pojo.Orders;
import com.cssl.service.Ordersservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/2/27 0027.
 */
@Service
public class Ordersserviceimpl implements Ordersservice {
    @Autowired
    private Ordersdao dao;
    @Override
    public int countOrders() {
        return dao.countOrders();
    }

    @Override
    public String countjine() {
        return dao.countjine();
    }

    @Override
    public List<Orders> showorders(Map<String,Object> map) {
        return dao.showorders(map);
    }

    @Override
    public Orders ddxgcs(String id) {
        return dao.ddxgcs(id);
    }

    @Override
    public int ddupdate(Orders o) {
        return dao.ddupdate(o);
    }

    @Override
    public int countorders_details(int cyid) {
        return dao.countorders_details(cyid);
    }
}
