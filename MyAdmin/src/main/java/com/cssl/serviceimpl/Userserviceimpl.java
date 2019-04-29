package com.cssl.serviceimpl;

import com.cssl.dao.Usersdao;
import com.cssl.pojo.Users;
import com.cssl.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/1/18 0018.
 */
@Service
public class Userserviceimpl implements Userservice {

    @Autowired
    private Usersdao udao;

    @Override
    public int updateadmin(String xadmin,String yadmin,String name) {
        return udao.updateadmin(xadmin,yadmin,name);
    }

    @Override
    public int countyong() {
        return udao.countyong();
    }

    @Override
    public int countadmin() {
        return udao.countadmin();
    }

    @Override
    public Users login(Users us) {
        return udao.login(us);
    }


    @Override
    public Users xinxi(String name) {
        return udao.xinxi(name);
    }

    @Override
    public List<Map<String,Object>> show(Map<String,Object> map){
        return  udao.show(map);
    }


    @Override
    public int tianjia(Users users) {
        return udao.tianjia(users);
    }


    @Override
    public int deleteyh(List<String> id) {
        return udao.deleteyh(id);
    }

    @Override
    public Users BianJi(int id) {
        return udao.BianJi(id);
    }

    @Override
    public int updateyh(Users users) {
        return udao.updateyh(users);
    }

    @Override
    public int updateyhqx(Users users) {
        return udao.updateyhqx(users);
    }

    @Override
    public int updateyhqx1(Users users) {
        return udao.updateyhqx1(users);
    }

    @Override
    public List<Map<String, Object>> qxcsshow() {
        return udao.qxcsshow();
    }

    @Override
    public int updateyhtjqx(Users users) {
        return udao.updateyhtjqx(users);
    }

    @Override
    public int yonghuyii(String name) {
        return udao.yonghuyii(name);
    }
}
