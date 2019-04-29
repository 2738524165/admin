package com.cssl.dao;

import com.cssl.pojo.Users;

import java.util.List;
import java.util.Map;


/**
 * 用户信息dao
 *
 */
public interface Usersdao {
    /**
     * 后台登录
     * @param us
     * @return
     */
    public Users login(Users us);


    /**
     * 统计用户
     * @return
     */
    public int  countyong();

    /**
     * 统计管理员
     * @return
     */
    public int  countadmin();

    /**
     * 修改密码
     * @return
     */
    public int updateadmin(String xadmin,String yadmin,String name);


    /**
     * 根据name查询信息
     * @param name
     * @return
     */
    public  Users xinxi(String name);


    /**
     * 查询用户所有信息
     * @return
     */
    public List<Map<String,Object>> show(Map<String,Object> map);


    /**
     * 添加信息
     * @param users
     * @return
     */
    public int tianjia(Users users);


    /**
     * 删除信息
     * @param id
     * @return
     */
    public int deleteyh(List<String> id);

    /**
     * 更具id查询用户信息
     * @param id
     * @return
     */
    public Users BianJi(int id);

    /**
     * 用户修改数据
     * @param users
     * @return
     */
    public int updateyh(Users users);


    /**
     * 用户权限修改数据
     * @param users
     * @return
     */
    public int updateyhqx(Users users);


    /**
     * 用户添加修改权限
     * @param users
     * @return
     */
    public int updateyhtjqx(Users users);

    /**
     * 用户权限删除信息 把权限修改为0 不显示页面
     * @param users
     * @return
     */
    public int updateyhqx1(Users users);



    /**
     * 查询权限等于0所有信息
     * @return
     */
    public List<Map<String,Object>> qxcsshow();

    /**
     * 查询用户名是否唯一
     * @param name
     * @return
     */
    public int yonghuyii(String name);

}
