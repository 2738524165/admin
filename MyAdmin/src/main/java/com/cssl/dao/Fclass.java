package com.cssl.dao;

import com.cssl.pojo.One_class;
import com.cssl.pojo.Tow_class;
import org.apache.ibatis.annotations.One;

import java.util.List;
import java.util.Map;

/**
 * 分类
 */
public interface Fclass {

    /**
     *一级分类
     */
    public List<One_class> showOne_class();


    /**
     * 显示2级分类
     * @return
     */
    public List<One_class>showOne_class2();

    /***
     * 根具一级的id查询二级分类
     * @param oid
     * @return
     */
    public List<One_class> showerji_class(int oid);

    /**
     * 三级分类
     * 根具二级的id查询三级分类
     * @return
     */
    public List<Tow_class> showtow_class(int oid);

    public Tow_class XainhsiFenleitow(int id);


    /**
     * 添加一二级分类
     * @param
     * @return
     */
    public  int  yijifl(One_class o);
    public  int    yijifl2(One_class o);


    /**
     * 添加三级分类
     * @param
     * @return
     */
    public  int  sjfl(Tow_class tow);


    /**
     * 查询所有分类
     * @return
     */
    public List<One_class> ShowFen();


    /**
     * 删除三级分类
     * @param tcid
     * @return
     */
    public int deleteTow(int tcid);


    /**
     * 分类管理修改查询数据
     * @param id
     * @return
     */
    public One_class ShowXGXianShi(int id);


    /**
     * 修改一二级分类
     * @param one
     * @return
     */
    public int updateyiji(One_class one);


    /**
     * 修改三级分类
     * @param tow
     * @return
     */
    public int updateTowsanji(Tow_class tow);



    /**
     * 判断分类地下是否有商品，有的话不能删除
     * @param tid
     * @return
     */
    public int Fenleidelete(int tid);

}
