package com.yu.service;

import com.yu.model.Orders;

import java.util.List;

public interface IOrdersService {
    List<Orders> findAll();
}
