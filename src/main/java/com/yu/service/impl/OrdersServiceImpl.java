package com.yu.service.impl;

import com.yu.dao.IOrdersDao;
import com.yu.model.Orders;
import com.yu.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName OrdersServiceImpl
 * @Description TODO
 * @Author yuzhuojun
 * Date 2020/9/25 9:36
 */
@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {
    @Autowired
    private IOrdersDao ordersDao;

    @Override
    public List<Orders> findAll() {
        return null;
    }
}
