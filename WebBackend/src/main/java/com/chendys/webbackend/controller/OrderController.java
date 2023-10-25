package com.chendys.webbackend.controller;


import com.chendys.webbackend.pojo.Sales;
import com.chendys.webbackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {


    @Autowired
    private OrderService orderService;


    /**
     * 获取指定天数内时段销售量
     * @param day 多少天内
     * @return
     */
    @GetMapping("/sales")
    public List<Sales> getSales(@RequestParam("day") Integer day){
        return orderService.getSales(day);
    }
}
