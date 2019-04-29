package com.cssl.controller;

import com.cssl.pojo.Users;
import com.cssl.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
/**
 * 登录相关
 */
@Controller
public class Login {
    @Autowired
    private Userservice userservice;


    /**
     * 登录成功 跳转页面存入session值
     * @return
     */
   @RequestMapping("/logins")
    public  String logins(HttpServletRequest request, String UserName, String password, String CheckCode) {
       String yzm = (String) request.getSession().getAttribute("rand");
       Users s = new Users();
       s.setU_name(UserName);
       s.setU_pwd(password);
       //到数据库查询
       Users user = userservice.login(s);
       request.getSession().setAttribute("u", user);
       return "index.html";
   }

    /**
     * 登陆判断 验证
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public  int login(HttpServletRequest request, String UserName, String password, String CheckCode){
        if(UserName!=""&&UserName!=null&&password!=""&&password!=null&&CheckCode!=""&&CheckCode!=null){
            //从session获取验证码的值
            String yzm=(String)request.getSession().getAttribute("rand");
            Users s=new Users();
            s.setU_name(UserName);
            s.setU_pwd(password);
            //到数据库查询
            Users user= userservice.login(s);
            if(user!=null){
                if(!password.equals(user.getU_pwd()) || !UserName.equals(user.getU_name())){
                    return 3;
                }
                if(!yzm.equals(CheckCode)){
                    return 2;
                }
                if(user.getU_type().equals("2")){
                    //登录成功  超级管理员2
                    return 1;
                }

            }
        }
        //空值
        return 0;
    }



    /**
     *  修改密码
     * @param adminName 原密码
     * @param password 新密码
     * @return
     */
    @RequestMapping("/updatelogin")
    @ResponseBody
    public int  updatelogin(String adminName,String password,HttpServletRequest request){
        //session拿到登录时的存入的用户对象
        Users name=(Users) request.getSession().getAttribute("u");
       int jie= userservice.updateadmin(password,adminName,name.getU_name());
        if(jie>0){
            return 1;
        }
        return 0;
    }

    //退出
    @RequestMapping("/TuiChu")
    public String TuiChu (HttpServletRequest request){
        request.getSession().invalidate();
        return "login.html";
    }



    @RequestMapping("/getcount")
    @ResponseBody
    public  int getcount(HttpServletRequest request){
        ServletContext application = request.getServletContext();
        Integer count = (Integer)application.getAttribute("count");
        if(count==null){
            application.setAttribute("count", 1);
        }else{
            application.setAttribute("count", count+1);
        }
        int cou=(int)application.getAttribute("count");
       return cou;
    }



}
