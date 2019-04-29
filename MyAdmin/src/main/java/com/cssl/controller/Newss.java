package com.cssl.controller;

import com.cssl.pojo.News;
import com.cssl.serviceimpl.Newsserviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.util.resources.cldr.kam.CalendarData_kam_KE;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 关于新闻
 */
@Controller
public class Newss {
    @Autowired
    private Newsserviceimpl ndao;


    /**
     * 查询新闻页面显示数据
     * @param request
     * @param logmin
     * @param
     * @param text
     * @param m
     * @return
     */
    @RequestMapping("/shownewss")
    public String ShowNewss(HttpServletRequest request, String logmin,  String text, Model m){

        request.getSession().setAttribute("news",ndao.shownews(new HashMap<>()));
        if(logmin!=""&&logmin!=null ||  text!=""&&text!=null){
            Map<String,Object>ma=new HashMap<>();
            ma.put("name","%"+text+"%");
            ma.put("shijin",logmin+"%");
            request.getSession().setAttribute("news",ndao.shownews(ma));
            m.addAttribute("logmin",logmin);
            m.addAttribute("text",text);
        }
        return "article-list.html";
    }


    /**
     * 添加信息
     * @param nr
     * @param biaoti
     * @return
     */
    @RequestMapping("/ADDxinwen")
    @ResponseBody
    public int ADDxinwen(String nr,String biaoti){
         if(nr!=""&&nr!=null&&biaoti!=""&&biaoti!=null){
             News n=new News();
             n.setN_time(new Date());
             n.setN_title(biaoti);
             n.setN_content(nr);
             if(ndao.insertnews(n)>0){
                 return 1;
             }
         }
        return 0;
    }


    /**
     * 修改之前查询数据
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/Bianji")
    public String Biaji(int id,HttpServletRequest request){
    request.getSession().setAttribute("showupdate",ndao.newss(id));
        return "article-Bianji-.html";
    }


    /**
     * 修改信息
     * @param id
     * @param nr
     * @param biaoti
     * @return
     */
    @RequestMapping("/updatenew")
    @ResponseBody
    public int updatenew(int id,String nr,String biaoti){
        if(id!=0&&nr!=""&&nr!=null&&biaoti!=""&&biaoti!=null){
            News n=new News();
            n.setN_id(id);
            n.setN_time(new Date());
            n.setN_title(biaoti);
            n.setN_content(nr);
            if(ndao.updatenews(n)>0){
                return 1;
            }
        }
        return 0;
    }


    /**
     * 查看详细
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/chakannr")
    public String chakan(int id,HttpServletRequest request){
        request.getSession().setAttribute("chakannrs",ndao.newss(id));
        return "aryicle-show.html";
    }


    /**
     * 删除新闻
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/deletenews")
    public int deletenews(int id){
        //System.out.println(id);
        if(id!=0){
            if(ndao.deletenews(id)>0){
                return 1;
            }
        }
        return 0;
    }



}
