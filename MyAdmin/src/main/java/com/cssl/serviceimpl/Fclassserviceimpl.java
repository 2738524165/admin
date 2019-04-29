package com.cssl.serviceimpl;

import com.cssl.dao.Fclass;
import com.cssl.pojo.Commodity;
import com.cssl.pojo.One_class;
import com.cssl.pojo.Tow_class;
import com.cssl.service.Fclassservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/3/1 0001.
 */
@Service
public class Fclassserviceimpl implements Fclassservice {
    @Autowired
    private Fclass fdao;

    @Override
    public List<One_class> showOne_class() {
        return fdao.showOne_class();
    }

    @Override
    public List<One_class> showOne_class2() {
        return fdao.showOne_class2();
    }

    @Override
    public List<One_class> showerji_class(int oid) {
        return fdao.showerji_class(oid);
    }

    @Override
    public List<Tow_class> showtow_class(int oid) {
        return fdao.showtow_class(oid);
    }


    @Override
    public int yijifl(One_class o) {
        return fdao.yijifl(o);
    }

    @Override
    public int yijifl2(One_class o) {
        return fdao.yijifl2(o);
    }

    @Override
    public int sjfl(Tow_class tow) {
        return fdao.sjfl(tow);
    }

    @Override
    public  Tow_class  XainhsiFenleitow(int id) {
        return fdao.XainhsiFenleitow(id);
    }

    @Override
    public List<One_class> ShowFen() {
        return fdao.ShowFen();
    }

    @Override
    public int deleteTow(int tcid) {
        return fdao.deleteTow(tcid);
    }



    @Override
    public One_class ShowXGXianShi(int id) {
        return fdao.ShowXGXianShi(id);
    }

    @Override
    public int updateyiji(One_class one) {
        return fdao.updateyiji(one);
    }

    @Override
    public int updateTowsanji(Tow_class tow) {
        return fdao.updateTowsanji(tow);
    }

    @Override
    public int Fenleidelete(int tid) {
        return fdao.Fenleidelete(tid);
    }
}
