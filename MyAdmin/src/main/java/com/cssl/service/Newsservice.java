package com.cssl.service;

import com.cssl.pojo.News;

import java.util.List;
import java.util.Map;

/**
 * 新闻
 */
public interface Newsservice {
    /**
     * 显示信息信息
     * @return
     */
    public List<News> shownews(Map<String,Object> map);

    /**
     * 添加新闻
     * @param ns
     * @return
     */
    public int insertnews(News ns);


    /**
     * 修改之前查询
     * @param id
     * @return
     */
    public News newss(int id);


    /**
     * 修改数据
     * @param ns
     * @return
     */
    public int updatenews(News ns);


    /**
     * 根据删除数据
     * @param id
     * @return
     */
    public int deletenews(int id);
}
