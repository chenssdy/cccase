package com.cccase.casebackend.controller;

import com.cccase.casebackend.pojo.vo.AccessoriesVo;
import com.cccase.casebackend.pojo.vo.IntegralExchangeVo;
import com.cccase.casebackend.service.IntegralExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/integralExchange")
public class IntegralExchangeController {


    @Autowired
    private IntegralExchangeService integralExchangeService;

    @GetMapping("/get")
    public List<IntegralExchangeVo> getIEAccessories(){
        return integralExchangeService.getIEAccessories();
    }

    @PostMapping("/exchange/{ieId}")
    public Boolean exchange(@PathVariable Integer ieId){
        return integralExchangeService.exchange(ieId);
    }
}
