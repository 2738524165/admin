package com.cssl.serviceimpl;

import com.cssl.dao.Productdao;
import com.cssl.pojo.Product;
import com.cssl.service.Productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/3/2 0002.
 */
@Service
public class Productserviceimpl implements Productservice {
    @Autowired
    private Productdao pdao;

    @Override
    public int tinajiaimg(Product product) {
        return pdao.tinajiaimg(product);
    }

    @Override
    public int deletetu(List<String> id) {
        return pdao.deletetu(id);
    }

    @Override
    public int XGTP(Product p) {
        return pdao.XGTP(p);
    }
}
