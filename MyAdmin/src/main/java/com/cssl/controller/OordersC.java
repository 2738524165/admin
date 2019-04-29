package com.cssl.controller;

import com.cssl.pojo.Orders;
import com.cssl.serviceimpl.Ordersserviceimpl;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 订单页面
 */
@Controller
public class OordersC {
    @Autowired
    private Ordersserviceimpl odao;

    /**
     * 显示订单页面信息
     * @param request
     * @param datemin
     * @param
     * @param text
     * @param model
     * @return
     */
    @RequestMapping("/showOrders")
    public String showOrders(HttpServletRequest request, String datemin, String text,Model model){
        List<Orders> map=odao.showorders(new HashMap<>());
        request.getSession().setAttribute("dingdand",map);
       // System.out.println(datemin);
        if (datemin != null && datemin != "" || text != null && text != "") {
            //条件查询
            Map<String, Object> map2 = new HashMap<>();
            map2.put("name", "%" + text + "%");
            map2.put("shijin",  datemin + "%");
            //保存到session
            request.getSession().setAttribute("dingdand", odao.showorders(map2));
            //查询到了，那刚刚的查询的值给返回给出去
            model.addAttribute("datemin", datemin);
            model.addAttribute("text", text);
        }
        return "orders-list.html";
    }


    @RequestMapping("/XGDDCS")
    public String XGDDCS(String id,HttpServletRequest request){
        Orders o=odao.ddxgcs(id);
        //保存到session
        //System.out.println(o.toString());
        request.getSession().setAttribute("ddo", o);
        return "orders-BianjI.html";
    }

    @RequestMapping("/XGDD")
    @ResponseBody
    public int dingdangxuigai(int xinid,String id){
       // System.out.println("新的状态 "+xinid+"\t 订单编号 "+id);
        if(xinid!=0&&id!=""&&id!=null){
        Orders o=new Orders();
        o.setO_number(id);
        o.setO_type(xinid);
        if(odao.ddupdate(o)>0){
            return 1;
        }

        }
        return 0;
    }



}
