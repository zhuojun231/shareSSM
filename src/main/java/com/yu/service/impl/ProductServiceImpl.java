package com.yu.service.impl;

import com.yu.dao.IProductDao;
import com.yu.model.NoteResult;
import com.yu.model.Product;
import com.yu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ProductServiceImpl
 * @Description TODO
 * @Author yuzhuojun
 * Date 2020/9/21 14:29
 */
@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    IProductDao proDao ;
    @Override
    public List<Product> findProduct() {
        List<Product> products = proDao.findProduct();
        return products;
    }

    /**
     *  商品的新增
     * @param product
     */
    @Override
    public void saveProduct(Product product) {
        proDao.savePro(product);
    }

    /**
     *  商品的删除
     * @param ids
     * @return
     */
    @Override
    public NoteResult delPro(String[] ids) {
        NoteResult result = new NoteResult();
        proDao.delProById(ids);
        return null;
    }


    /**
     *  根据proId查询产品
     * @param proId
     * @return
     */
    @Override
    public NoteResult findProById(String proId) {
        NoteResult result  = new NoteResult();
        Product pro = proDao.findProductById(proId);
        System.out.println("ProductServiceImpl,findProById==>:"+pro.toString());
        return null;
    }

    public static void main(String[] args) {

    }
}
