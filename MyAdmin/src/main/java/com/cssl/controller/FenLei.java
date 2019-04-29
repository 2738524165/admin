package com.cssl.controller;

import com.cssl.pojo.One_class;
import com.cssl.pojo.Tow_class;
import com.cssl.serviceimpl.Fclassserviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/3/1 0001.
 */
@Controller
public class FenLei {
    @Autowired
    private Fclassserviceimpl fdao;

    /**
     * 显示一级分类
     *
     * @param request
     * @return
     */
    @RequestMapping("/FenLeis")
    public String one_class(HttpServletRequest request) {
        request.getSession().setAttribute("one", fdao.showOne_class());//保存一级分类
        return "product-add.html";
    }

    /**
     * 显示添加分类页面
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/FenLeiss2")
    public List<One_class> one_classs2(String id) {
        if (id == "" || id == null) {
            return fdao.showOne_class2();
        } else {
            return fdao.showOne_class();
        }
    }

    /**
     * 通过一级分类id查询二级分类，显示二级分
     *
     * @param request
     * @param oid
     * @param response
     * @return
     */
    @RequestMapping("/FenLeis2")
    @ResponseBody
    public List<One_class> one_class(HttpServletRequest request, int oid, HttpServletResponse response) {
        List<One_class> o = fdao.showerji_class(oid);
        return o;
    }


    /**
     * 通过二级分类id查询三级分类，显示三级分
     *
     * @param oid
     * @return
     */
    @RequestMapping("/FenLeis3")
    @ResponseBody
    public List<Tow_class> one_class(int oid) {
        List<Tow_class> o = fdao.showtow_class(oid);
        /*for (Tow_class t : o) {
            System.out.println(o.toString());
        }*/
        return o;
    }


    /**
     * 分类管理显示一级分类
     *
     * @param request
     * @return
     */
    @RequestMapping("/FenLeiGuanli")
    public String FenLeiGuanli(HttpServletRequest request) {
        request.getSession().setAttribute("Fenone", fdao.ShowFen());//保存一级分类
        List<One_class> maps = fdao.ShowFen();
        //System.out.println(maps.toString());
        return "Fenlei-list.html";
    }

    /**
     * 添加分类
     *
     * @param id
     * @param name
     * @return
     */
    @RequestMapping("/TianjiaaddF")
    @ResponseBody
    public int TianjiaaddF(String id, String name, String id2, String name2, String id3, String name3) {

        //添加根目录
        if (id != "" && id != null && name != "" && name != null) {
            One_class one1 = new One_class();
            one1.setOc_name(name);
            if (fdao.yijifl(one1) > 0) {
                return 1;
            }
        }
        //添加二级分类
        if (id2 != "" && id2 != null && name2 != "" && name2 != null) {
            One_class one2 = new One_class();
            one2.setOc_name(name2);
            one2.setOc_fid(Integer.valueOf(id2));
            if (fdao.yijifl2(one2) > 0) {
                return 1;
            }
        }

        //添加三级分类
        if (id3 != "" && id3 != null && name3 != "" && name3 != null) {
            Tow_class tow = new Tow_class();
            //System.out.println("三级级分类 " + name3);
            tow.setTc_content(name3);
            //System.out.println("二级分类id " + Integer.valueOf(id3));
            tow.setOc_id(Integer.valueOf(id3));
            if (fdao.sjfl(tow) > 0) {
                return 1;
            }
        }

        return 0;
    }


    /**
     * 删除分类
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteTows")
    public int deleteTows(int id) {
        //分类地下有商品的话不能删除
       if(fdao.Fenleidelete(id)==0){
            if (id != 0) {
                if (fdao.deleteTow(id) > 0) {
                    //三级分类删除成功
                    return  1;
                }
            }
        }
        return 0;
    }


    /**
     * 修改查询数据
     *
     * @param request
     * @return
     */
    @RequestMapping("/ShowFenLeicg")
    public String ShowFenLeicg(HttpServletRequest request, String id) {
        //System.out.println(id);
        request.getSession().setAttribute("sanjisjow", fdao.XainhsiFenleitow(Integer.valueOf(id)));
        request.getSession().setAttribute("erjishow", fdao.showOne_class());
        return "Fenlei-BianJi.html";
    }

    /**
     * 修改分类
     *
     * @return
     */
    @RequestMapping("/FenleiXg")
    @ResponseBody
    public int FenleiXg(String id, String name, String id2, String name2, String id3, String name3, String oid) {
        if (id != "" && id != null && name != "" && name != null) {
            //修改一级分类
            //System.out.println(id + "\t" + name);
            One_class o = new One_class();
            o.setOc_id(Integer.valueOf(id));
            o.setOc_name(name);
            return fdao.updateyiji(o);
        } else if (id2 != "" && id2 != null && name2 != "" && name2 != null) {
            //修改二级
            One_class o1 = new One_class();
            o1.setOc_id(Integer.valueOf(id2));
            o1.setOc_name(name2);
           // System.out.println(id2 + "\t" + name2);
            return fdao.updateyiji(o1);
        } else if (id3 != "" && id3 != null && name3 != "" && name3 != null && oid != "" && oid != null) {
            //修改三级
        Tow_class t=new Tow_class();
        t.setTc_content(name3);
        if(oid!=null){
            t.setOc_id(Integer.valueOf(oid));
        }else{
            t.setOc_id(0);
        }
        t.setTc_id(Integer.valueOf(id3));
          return fdao.updateTowsanji(t);
        }

        return 0;
    }
}