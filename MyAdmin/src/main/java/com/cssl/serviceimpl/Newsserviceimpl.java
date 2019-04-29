package com.cssl.serviceimpl;

import com.cssl.dao.Newsdao;
import com.cssl.pojo.News;
import com.cssl.service.Newsservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/3/6 0006.
 */
@Service
public class Newsserviceimpl implements Newsservice {

    @Autowired
    private Newsdao ndao;

    @Override
    public List<News> shownews(Map<String,Object> map) {
        return ndao.shownews(map);
    }

    @Override
    public int insertnews(News ns) {
        return ndao.insertnews(ns);
    }

    @Override
    public News newss(int id) {
        return ndao.newss(id);
    }

    @Override
    public int updatenews(News ns) {
        return ndao.updatenews(ns);
    }

    @Override
    public int deletenews(int id) {
        return ndao.deletenews(id);
    }
}
