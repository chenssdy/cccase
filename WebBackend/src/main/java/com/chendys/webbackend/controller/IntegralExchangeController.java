package com.chendys.webbackend.controller;

import com.chendys.webbackend.pojo.IntegralExchange;
import com.chendys.webbackend.pojo.dto.IntegralExchangeDto;
import com.chendys.webbackend.pojo.vo.IntegralExchangeVo;
import com.chendys.webbackend.pojo.vo.Page;
import com.chendys.webbackend.service.IntegralExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ies")
public class IntegralExchangeController {

    @Autowired
    private IntegralExchangeService integralExchangeService;

    /**
     * 获取一页兑换饰品数据
     * @param page
     * @param num
     * @param status
     * @return
     */
    @GetMapping("/list")
    public Page<IntegralExchangeVo> get(@RequestParam("page") Integer page,
                                        @RequestParam("num") Integer num,
                                        @RequestParam("status") Integer status){
        return integralExchangeService.getPage(page, num, status);
    }


    /**
     * 创建可兑换饰品
     * @param integralExchangeDto
     * @return
     */
    @PostMapping("/create")
    public IntegralExchangeVo addIE(@RequestBody IntegralExchangeDto integralExchangeDto){
        return integralExchangeService.addIE(integralExchangeDto);
    };


    /**
     * 修改积分兑换数据
     * @param integralExchange
     * @return
     */
    @PostMapping("/update")
    public IntegralExchangeVo updateIE(@RequestBody IntegralExchange integralExchange){
        return integralExchangeService.updateIE(integralExchange);
    };

    /**
     * 删除积分兑换数据
     * @param id
     * @return
     */
    @PostMapping("/del/{id}")
    public String deleteIE(@PathVariable Integer id){
        return integralExchangeService.deleteIE(id);
    };
 }
