package com.chendys.webbackend.service;

import com.chendys.webbackend.pojo.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chendys.webbackend.pojo.Sales;

import java.util.List;

/**
* @author chens
* @description 针对表【tb_order】的数据库操作Service
* @createDate 2023-05-31 18:14:47
*/
public interface OrderService extends IService<Order> {

    /**
     * 获取day天内时段销售量
     * @param day
     * @return
     */
    List<Sales> getSales(Integer day);
}
