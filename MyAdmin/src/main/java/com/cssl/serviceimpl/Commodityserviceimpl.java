package com.cssl.serviceimpl;

import com.cssl.dao.Commoditydao;
import com.cssl.pojo.Cdetails;
import com.cssl.pojo.Commodity;
import com.cssl.service.Commodityservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/3/1 0001.
 */
@Service
public class Commodityserviceimpl implements Commodityservice {
    @Autowired
    private Commoditydao comdao;

    @Override
    public List<Map<String, Object>> show(Map<String, Object> map) {
        return comdao.show(map);
    }

    @Override
    public int TJSP(Commodity commodity) {
        return comdao.TJSP(commodity);
    }

    @Override
    public int TJSPXQ(Cdetails c) {
        return comdao.TJSPXQ(c);
    }

    @Override
    public int deletesp(List<String> id) {
        return comdao.deletesp(id);
    }

    @Override
    public int deletexq(List<String> id) {
        return comdao.deletexq(id);
    }

    @Override
    public Map<String, Object> spxgcx(int id) {
        return comdao.spxgcx(id);
    }

    @Override
    public int SPXG(Commodity commodity) {
        return comdao.SPXG(commodity);
    }

    @Override
    public List<Commodity> SPCXXS() {
        return comdao.SPCXXS();
    }

    @Override
    public Commodity SPSLCS(int id) {
        return comdao.SPSLCS(id);
    }

    @Override
    public int SPKCXG(Commodity c) {
        return comdao.SPKCXG(c);
    }

    @Override
    public int Deletespkc(int id) {
        return comdao.Deletespkc(id);
    }

}
