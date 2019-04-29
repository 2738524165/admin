package com.cssl.service;

import com.cssl.pojo.Cdetails;
import com.cssl.pojo.Commodity;

import java.util.List;
import java.util.Map;

/**
 *商品业务
 */
public interface Commodityservice {

    /**
     * 查询商品主页显示数据
     * @return
     */
    public List<Map<String,Object>> show(Map<String,Object> map);

    /**
     * 添加商品信息
     * @param
     * @return
     */
    public  int  TJSP(Commodity commodity);
    /**
     * 添加商品详情
     * @param c
     * @return
     */
    public int TJSPXQ(Cdetails c);
    /**
     * 删除和批量删除
     * @param id
     * @return
     */
    public int deletesp(List<String> id);
    public int deletexq(List<String> id);


    /**
     * 修改之前查询数据
     * @param id
     * @return
     */
    public Map<String,Object> spxgcx(int id);

    /**
     * 商品修改
     * @param commodity
     * @return
     */
    public int SPXG(Commodity commodity);


    /**
     * 商品库存时候添加显示数据
     * @return
     */
    public List<Commodity> SPCXXS();

    /**
     *商品库存时候修改显示数据
     * @param id
     * @return
     */
    public Commodity SPSLCS(int id);

    /**
     * 商品库存数量修改
     * @param c
     * @return
     */
    public int SPKCXG(Commodity c);


    /**
     * 删除库存信息
     * @param id
     * @return
     */
    public int Deletespkc(int id);



}
