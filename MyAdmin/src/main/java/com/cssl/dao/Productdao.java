package com.cssl.dao;

import com.cssl.pojo.Product;

import java.util.List;

/**
 * 图片
 */
public interface Productdao {
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
