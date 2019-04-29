package com.cssl.controller;

import com.alibaba.fastjson.JSONObject;
import com.cssl.pojo.Cdetails;
import com.cssl.pojo.Product;
import com.cssl.serviceimpl.Commodityserviceimpl;
import com.cssl.serviceimpl.Fclassserviceimpl;
import com.cssl.serviceimpl.Ordersserviceimpl;
import com.cssl.serviceimpl.Productserviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

/**
 * 商品
 */
@Controller
public class Commodity {
    @Autowired
    private Commodityserviceimpl comdaol; //商品信息

    @Autowired
    private Productserviceimpl pdao;//图片

    @Autowired
    private Fclassserviceimpl fdao;//分类

    @Autowired
    private Ordersserviceimpl odao;//订单



    /**
     * 显示商品信息 和条件查询
     *
     * @param request
     * @param datemin
     * @param
     * @param text
     * @param Model
     * @return
     */
    @RequestMapping("/spshow")
    public String spshow(HttpServletRequest request, String datemin,   String text, Model Model) {
        // System.out.println("小 ：" + datemin + "\t" + "大 ：" + datemax + "\t 文本：" + text);
        //存入session中 如果传入空的map代表查询所有数据
        request.getSession().setAttribute("spshow", comdaol.show(new HashMap<>()));
        List<Map<String, Object>> mms = comdaol.show(new HashMap<>());
        if (datemin != null && datemin != "" ||    text != null && text != "") {
            //条件查询
            Map<String, Object> map2 = new HashMap<>();
            map2.put("name", "%" + text + "%");
            map2.put("shijin", datemin+"%");
            //保存到session
            request.getSession().setAttribute("spshow", comdaol.show(map2));
            //查询到了，那刚刚的查询的值给返回给出去
            Model.addAttribute("datemin", datemin);
            Model.addAttribute("text", text);
          /* List <Map<String, Object>> mms= comdaol.show(map2);
            for (Map<String,Object> mm:mms){
                System.out.println(mm.toString());
            }*/
        }
        return "product-list.html";
    }



    /**
     * 上传图片 写入到文件
     *
     * @param
     * @return
     */
    @RequestMapping("/SCPath")
    public void work(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 1);
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (multipartResolver.isMultipart(request)) {// 是否是 multipart
            MultipartHttpServletRequest multirequest = (MultipartHttpServletRequest) request;
            Iterator<?> iterator = multirequest.getFileNames();
            while (iterator.hasNext()) {
                MultipartFile file = multirequest.getFile(iterator.next().toString());
                if (file != null) {
                    String filename = file.getOriginalFilename();
                    String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                    String filetype = "";
                    if (filename.indexOf(".") > -1) {
                        filetype = filename.substring(filename.lastIndexOf("."));
                    }
                  String path = "D:\\学习资料\\Y2结业项目\\后台项目\\MyAdmin\\src\\main\\resources\\static\\img\\" + uuid + filetype;
                  // String path = "/opt/MyAdmin/static/img/" + uuid + filetype;
                    File newfile = new File(path);
                    if (!newfile.getParentFile().exists()) {
                        //如果目标文件不存在就创建父目录
                        newfile.getParentFile().mkdirs();
                    }
                    file.transferTo(new File(path));
                    jsonObject.put("code", 0);
                    jsonObject.put("msg", uuid + filetype);
                }
            }
        }
        response.setHeader("Content-Type", "textml");
        response.getWriter().write(jsonObject.toString());
    }




    /**
     * 添加商品信息
     *
     * @param
     * @param spname
     * @param sanji
     * @param price
     * @param kucun
     * @param diqu
     * @param
     * @param beizhu
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    @RequestMapping("/Tianjiaysp")
    @ResponseBody
    public int Tianjiaysp(String spname, String sanji,String tupath, int price, int kucun, String diqu, String beizhu) {
        //  System.out.println(spname+"\t"+sanji+"\t"+price+"\t"+"kucun"+kucun+"\t"+diqu+"\t"+yanse+"\t"+beizhu);
        // 添加
        com.cssl.pojo.Commodity com = new com.cssl.pojo.Commodity();
        com.setCy_name(spname);//商品名称
        com.setCy_price(price);//商品价格
        com.setCy_placeoforigin(diqu);//地区
        com.setCy_shelftime(new Date());//发布时间
        com.setCy_introduction(beizhu);//商品介绍
        if (sanji != null && sanji != "") {
            com.setTc_id(Integer.valueOf(sanji));//三级分类id
        }
        com.setCy_discount(0);//折扣
        com.setCy_sales(0);//库存
        com.setUm_id(0);//商家id
        com.setCy_inventory(kucun);
        int jie = comdaol.TJSP(com);
        /**
         *商品详情
         */
        Cdetails cd = new Cdetails();
        cd.setCy_id(com.getCy_id());
        cd.setCs_frontcamera("");
        cd.setCs_version("");
        cd.setCs_rearcamera("");
        cd.setCs_resolution("");
        cd.setCs_size("");
        cd.setCs_system("");
        cd.setCy_weight(0);
        int jie3 = comdaol.TJSPXQ(cd);

        //添加图片表
        Product tu = new Product();//图图片
        tu.setP_color("");//颜色
        tu.setP_image(tupath);//图片路径
        tu.setCs_id(cd.getCs_id());//商品详情id
        int jie2 = pdao.tinajiaimg(tu);
        if (jie == 1 && jie2 == 1 && jie3 == 1) {
            return 1;
        }
        return 0;
    }


    /**
     * 删除商品
     *
     * @param id
     * @param tuid
     * @return
     */
    @RequestMapping("/delteshow")
    @ResponseBody
    public int delteshow(String id, String tuid) {
        if(odao.countorders_details(Integer.valueOf(id))==0){
 String[] c1 = tuid.split(",");
        List<String> userListtuid = Arrays.asList(c1);
        String[] c = id.split(",");
        List<String> userList = Arrays.asList(c);
        if (userList != null && userListtuid != null) {
            int jie2 = pdao.deletetu(userListtuid);
            if (jie2 > 0) {
                int jie = comdaol.deletexq(userListtuid);
                if (jie > 0) {
                    ///System.out.println(userList.toString());
                    int jie1 = comdaol.deletesp(userList);
                    if (jie > 0 && jie2 > 0 && jie1 > 0) {
                        //成功
                        return 1;
                    }
                }
            }
        }
        }else {
            return 3;
        }
        return 0;
    }

    /**
     * 修改商品之前查询数据
     *
     * @param request
     * @return
     */
    @RequestMapping("/SpBianJi")
    public String SpBianJi(HttpServletRequest request, int id) {
        request.getSession().setAttribute("one", fdao.showOne_class());//保存一级分类
        request.getSession().setAttribute("spxg", comdaol.spxgcx(id));
        Map<String, Object> m = comdaol.spxgcx(id);
        //System.out.println(m.toString());
        return "product-BianJi.html";
    }

    /**
     * 修改商品
     *
     * @return
     */
    @RequestMapping("/SpXuiGai")
    @ResponseBody
    public int SpXuiGai(int pid,  int sanji,String tupath, int id, String spname, String price, int kucun, String diqu, String beizhu) {
        //System.out.println(tupath);
  /*     System.out.println("pid:"+pid+"\t imgname :"+imgname+"\t id："+id+"\t spname:"+spname+"\t"+"price:"+price+"\t"+"kucun :"+kucun+"\t diqu: "+diqu+"\t beizhu"+beizhu);
*/
        //System.out.println("sanji:"+sanji);
        if (pid != 0 && id != 0 && spname != null && spname != "" && price !=""&&price!=null&&kucun !=0 && diqu != "" && diqu != null && beizhu != "" && beizhu != null) {
            //修改图片表
            Product tu = new Product();//图图片
            tu.setP_image(tupath);//图片路径
            tu.setP_id(pid);//图片id
            com.cssl.pojo.Commodity com = new com.cssl.pojo.Commodity();
            com.setCy_id(id);//商品id
            com.setCy_name(spname); //商品名称
            com.setCy_price(Float.valueOf(price)); //价格
            com.setTc_id(sanji);//三级分类id
            com.setCy_sales(0);//折扣
            com.setCy_inventory(kucun);//库存
            com.setCy_placeoforigin(diqu);//地址
            com.setCy_introduction(beizhu);//介绍
            int jie2 = pdao.XGTP(tu); //图片表提交数据修改
             int jie = comdaol.SPXG(com); //商品表提交数据修改
            if (jie > 0&& jie2>0) {
                return 1;
            }
            return 0;
        }
        return 0;
    }


    /**
     * 商品库存数量 主页
     * @param request
     * @return
     */
    @RequestMapping("/Kucunshulaing")
    public String Kucunshulaing(HttpServletRequest request,String text,Model model){
        request.getSession().setAttribute("kmms",comdaol.show(new HashMap<>()));
        if(text!=null&&text!=""){
            Map<String,Object> mpa=new HashMap<>();
            mpa.put("name","%"+text+"%");
            request.getSession().setAttribute("kmms",comdaol.show(mpa));
            model.addAttribute("text",text);
        }
        return "Kucun-list.html";
    }

    /**
     * 添加商品库存之前查询数据
     * @return
     */
    @RequestMapping("/ADDkucun")
    public String ADDkucun(HttpServletRequest request){
        request.getSession().setAttribute("optkucun",  comdaol.SPCXXS());
        return "Kucun-add.html";
    }


    /**
     * 添加商品库存提交
     * @return
     */
    @ResponseBody
    @RequestMapping("/KucunAdd")
    public int KucunAdd(int id,int kucun){
        if(id!=0&&kucun!=0){
            com.cssl.pojo.Commodity c=new com.cssl.pojo.Commodity();
            c.setCy_id(id);
            c.setCy_sales(kucun);
            int jie=comdaol.SPKCXG(c);
            if(jie>0){
                return 1;
            }
        }
        return 0;
    }


    /**
     * 商品库存修改之前查询显示
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/updateshow")
    public String updateshow(int id,HttpServletRequest request){
        //System.out.println(id);
        request.getSession().setAttribute("updateshow",comdaol.SPSLCS(id));
         return "Kucun-BianJi.html";

    }

    /**
     * 商品库存修改
     * @param id
     * @param
     * @return
     */
    @RequestMapping("/updatexg")
    @ResponseBody
    public int updatexg(int id,int kucun){
        if(kucun!=0&&id!=0){
            com.cssl.pojo.Commodity c=new com.cssl.pojo.Commodity();
            c.setCy_id(id);
            c.setCy_sales(kucun);
             if(comdaol.SPKCXG(c)>0){
                    return 1;
                }
        }
        return 0;
    }


    @ResponseBody
    @RequestMapping("/Deletespkc")
    public int deltekucun(int id){
        //System.out.println(id);
        if(id!=0){
            int j=comdaol.Deletespkc(id);
            if(j>0){
                return 1;
            }
        }
        return 0;
    }



}