package com.cssl.controller;

import com.cssl.pojo.Users;
import com.cssl.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

/**
 * 用户管理
 */
@Controller
public class Userc {
    @Autowired
    private Userservice userservice;

    /**
     * 查询显示用户信息
     * @param request
     * @return
     */
    @RequestMapping("/YongHuGuanLi")
    public String YongHuGuanLi(HttpServletRequest request,String datemin, String text,Model Model){
/*
        System.out.println("小 ："+datemin+"\t"+"大 ："+datemax+"\t 文本："+text);*/
        //存入session中 如果传入空的map代表查询所有数据
        request.getSession().setAttribute("show", userservice.show(new HashMap<>()));
         if(datemin!=null&&datemin!=""|| text!=null&&text!=""){
             //条件查询
             Map<String,Object> map2=new HashMap<>();
             map2.put("name","%"+text+"%");
             map2.put("shijin",datemin+"%");
             request.getSession().setAttribute("show", userservice.show(map2));
             Model.addAttribute("datemin",datemin) ;
             Model.addAttribute("text",text) ;
             List<Map<String,Object>> list=userservice.show(map2);
             /*for (Map<String,Object> map1 : list) {
                 System.out.println(map1.toString());
             }*/
         }
        return "member-list.html";
    }

    /**
     * 添加用户信息
     * @param username
     * @param password
     * @param pay_pwd
     * @param sex
     * @param mobile
     * @param email
     * @param city
     * @param beizhu
     * @return
     */
    @RequestMapping("/TianJiaAdd")
    @ResponseBody
    public int TianJiaAdd(String username,String password,String pay_pwd,String sex,String mobile,String email,String city,String beizhu){
       // System.out.println(username+"\t"+password+"\t"+pay_pwd+"\t"+sex+"\t"+mobile+"\t"+email+"\t"+city    +"\t"+"\t"+beizhu);
       if(username!="" || username!=null && password!=""&&password!=null &&pay_pwd!=""&&pay_pwd!=null &&sex!=""&&sex!=null &&mobile!=""&&mobile!=null &&email!=""&&email!=null &&city!=""&&city!=null  ){
        Users user=new Users();
        user.setU_name(username);
        user.setU_pwd(password);
        user.setU_pay_pwd(pay_pwd);
        user.setU_sex(sex);
        user.setU_phone(mobile);
        user.setU_remark(beizhu);
        user.setU_address(city);
        user.setU_type("0"); //默认没有权限 表示用户
        user.setU_email(email);
        user.setU_record_date(new Date());
        int jie=userservice.tianjia(user);
             if(jie>0){
                  //添加成功
                return 1;
             }
        }
    return 0;
    }

    /**
     * 删除和批量删除
     * @param id
     * @return
     */
    @RequestMapping("/Deleteyh")
    @ResponseBody
    public String Deleteyh(String id){
        String[] c = id.split(",");
        List<String> userList = Arrays.asList(c);
            if(userList!=null) {
                int jie = userservice.deleteyh(userList);
                if (jie > 0) {
                    //成功
                    return "1";
                }
            }
        return  "0";
    }

    /**
     * 根据id查询。编辑修改显示信息
     * @return
     */
    @RequestMapping("/BianJi")
        public String BianJi(int id,HttpServletRequest request){
        if(id!=0){
           request.getSession().setAttribute("bjus",userservice.BianJi(id));
        }
        return "member-bainji.html";
    }

    /**
     * 编辑修改信息
     * @return
     */
    @RequestMapping("/BianJiXuiGai")
    @ResponseBody
    public int BianJiXuiGai(int id,String username,String password,String pay_pwd,String sex,String mobile,String email,String city,String beizhu){
        // System.out.println(username+"\t"+password+"\t"+pay_pwd+"\t"+sex+"\t"+mobile+"\t"+email+"\t"+city    +"\t"+"\t"+beizhu);
        if(username!="" || username!=null && password!=""&&password!=null &&pay_pwd!=""&&pay_pwd!=null &&sex!=""&&sex!=null &&mobile!=""&&mobile!=null &&email!=""&&email!=null &&city!=""&&city!=null  ){
            Users user=new Users();
            user.setU_id(id);
            user.setU_name(username);
            user.setU_pwd(password);
            user.setU_pay_pwd(pay_pwd);
            user.setU_sex(sex);
            user.setU_phone(mobile);
            user.setU_remark(beizhu);
            user.setU_address(city);
                user.setU_type("1"); //默认普通管理员
            user.setU_email(email);
            user.setU_record_date(new Date());
            //调业务层
            int jie=userservice.updateyh(user);
            if(jie>0){
                //修改成功
                return 1;
            }
        }
        return 0;
    }

    /**
     * 查询index个人信息
     * @return
     */
    @RequestMapping("/YongHuxinxi")
    public String chaxinxinxi(String name,HttpServletRequest request){
       // System.out.println(name);
        request.getSession().setAttribute("YongHuxinxi", userservice.xinxi(name));//保存session
        return "member-show.html";
    }

    /**
     * 权限管理界面
     * @param request
     * @param datemin
     * @param
     * @param text
     * @param Model
     * @return
     */
    @RequestMapping("/YongHuQX")
    public String YongHuQX(HttpServletRequest request,String datemin,String text,Model Model) {

        //System.out.println("小 ："+datemin+"\t"+"大 ："+datemax+"\t 文本："+text);
        //存入session中 如果传入空的map代表查询所有数据
        request.getSession().setAttribute("show1", userservice.show(new HashMap<>()));
        if (datemin != null && datemin != "" || text != null && text != "") {
            //条件查询
            Map<String, Object> map2 = new HashMap<>();
            map2.put("name", "%" + text + "%");
            map2.put("shijin", datemin + "%");
            //保存到session
            request.getSession().setAttribute("show1", userservice.show(map2));
            //查询到了，那刚刚的查询的值给返回给出去
            Model.addAttribute("datemin", datemin);
            Model.addAttribute("text", text);
        }
            return "admin-permission.html";
    }

    /**
     * 权限页面 根据id查询显示
     * @return
     */
        @RequestMapping("/QX")
    public String QX(int id,HttpServletRequest request){
        if(id!=0){
            request.getSession().setAttribute("QX",userservice.BianJi(id));
        }
        return "admin-BianjI.html";
    }

    /**
     * 修改提交时
     * @paruam
     * @param
     * @return
     */
    @RequestMapping("/QXTJ")
    @ResponseBody
    public String QXTJ(int uid,String qx,String username){
        if(uid!=0&&qx!=""&&qx!=null&&username!=null){
            Users us=new Users();
            us.setU_id(uid);
            us.setU_type(qx);
            us.setU_name(username);
            int jie=userservice.updateyhqx(us);
            if(jie>0){
                //修改成功
                return "1";
            }
        }
        return "0";
    }

    /**
     * 权限页面删除 就是修改数据
     * @paruam
     * @param
     * @return
     */
    @RequestMapping("/QXSC")
    @ResponseBody
    public String QXSC(int id){
        if(id!=0){
            Users us=new Users();
            us.setU_id(id);
            us.setU_type("0");
                int jie=userservice.updateyhqx1(us);
            if(jie>0){
                //删除成功
                return "1";
            }
        }
        return "0";
    }

    /**
     * 权限页面添加前查询
     * @paruam
     * @param
     * @return
     */
    @RequestMapping("/QXCS")
    public String QXCS(HttpServletRequest request){
        //保存到sesion 显示到下拉类表
        request.getSession().setAttribute("QXxl",userservice.qxcsshow());
      /* List<Map<String,Object>>map= userservice.qxcsshow();
        for (Map<String,Object> mm:map) {
            System.out.println(mm.toString());
        }*/
        return "admin-add.html";
    }

    /**
     * 权限页面添加提交
     * @param
     * @param qx
     * @param username
     * @return
     */
    @RequestMapping("/QXTianJjia")
    @ResponseBody
    public String QXTianJjia(String qx,String username){
        //System.out.println(qx+"\t"+qx);
        if(qx!=null&&username!=null){
            Users us=new Users();
            us.setU_type(qx);
            us.setU_name(username);
            int jie=userservice.updateyhtjqx(us);
            if(jie>0){
                //修改成功
                return "1";
            }
        }
        return "0";
    }


    /**
     * 判断是否是否存在
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping("/Username")
    public int Username(String name){
       if( userservice.yonghuyii(name)==0){
           return 1;
       }
        return 0;
    }






}
