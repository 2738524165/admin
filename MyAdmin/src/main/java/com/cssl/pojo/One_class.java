package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 分类信息表
 */
@Setter
@Getter
@ToString
public class One_class implements Serializable {
    private int oc_id;//分类id
    private String oc_name;//分类名称
    private Integer oc_fid;//分类父id
    private  List<One_class> list;
    private  List<Tow_class> list2;
}
