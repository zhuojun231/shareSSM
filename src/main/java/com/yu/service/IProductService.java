package com.yu.service;

import com.yu.model.NoteResult;
import com.yu.model.Product;

import java.util.List;

public interface IProductService {
    public List<Product> findProduct();

    void saveProduct(Product product);

    NoteResult delPro(String[] ids);

    NoteResult findProById(String proId);
}
