package com.chendys.webbackend.service.impl;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chendys.webbackend.pojo.Order;
import com.chendys.webbackend.pojo.Sales;
import com.chendys.webbackend.service.OrderService;
import com.chendys.webbackend.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
* @author chens
* @description 针对表【tb_order】的数据库操作Service实现
* @createDate 2023-05-31 18:14:47
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Sales> getSales(Integer day) {


        return orderMapper.getSales(day);
    }

    public static void main(String[] args) {
        // 获取当前日期
        LocalDateTime currentDate = LocalDateTime.now();
        System.out.println(currentDate);

        LocalDateTime localDateTime = currentDate.minusDays(7);


        long l = localDateTime.toInstant(ZoneOffset.UTC).toEpochMilli();

        Date date = new Date(l);


    }
}




