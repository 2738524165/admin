package com.cssl.service;

import com.cssl.pojo.Product;

import java.util.List;

/**
 * Created by Administrator on 2019/3/2 0002.
 */
public interface Productservice {


    /**
     * 添加图片
     * @return
     */
    public int tinajiaimg(Product product);

    /**
     * 删除图片
     * @param id
     * @return
     */
    public int deletetu(List<String> id);

    /**
     * 修改图片
     * @param p
     * @return
     */
    public int XGTP(Product p);
}
