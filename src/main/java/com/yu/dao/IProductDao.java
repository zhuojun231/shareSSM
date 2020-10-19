package com.yu.dao;

import com.yu.model.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IProductDao {
    //根据id查询产品
    @Select("select * from product where id = #{proId}")
    Product findProductById(String proId);

    //查询所有产品
    List<Product> findProduct();

    //产品的新增
    void savePro(Product pro);

    //产品的删除
    void delProById(String[] ids);
}
