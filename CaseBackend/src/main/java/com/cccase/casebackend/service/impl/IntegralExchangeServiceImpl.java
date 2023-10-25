package com.cccase.casebackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cccase.casebackend.pojo.IntegralExchange;
import com.cccase.casebackend.pojo.UserBackpack;
import com.cccase.casebackend.pojo.vo.IntegralExchangeVo;
import com.cccase.casebackend.pojo.vo.PartitionVo;
import com.cccase.casebackend.service.IntegralExchangeService;
import com.cccase.casebackend.mapper.IntegralExchangeMapper;
import com.cccase.casebackend.service.RedisService;
import com.cccase.casebackend.service.UserService;
import com.cccase.casebackend.util.exception.Asserts;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author chens
* @description 针对表【tb_integral_exchange】的数据库操作Service实现
* @createDate 2023-10-15 11:33:37
*/
@Service
public class IntegralExchangeServiceImpl extends ServiceImpl<IntegralExchangeMapper, IntegralExchange>
    implements IntegralExchangeService{

    @Autowired
    private IntegralExchangeMapper integralExchangeMapper;

    @Autowired
    private RedisService redisService;

    @Autowired
    private UserService userService;

    @Override
    public List<IntegralExchangeVo> getIEAccessories() {

        Long size = redisService.lSize("integral_exchange:accessories");

        if(size > 0){

            List<Object> list = redisService.lRange("integral_exchange:accessories", 0, size);

            return list.stream().map(e -> {
                return (IntegralExchangeVo) e;
            }).collect(Collectors.toList());

        }

        List<IntegralExchangeVo> ieAccessories = integralExchangeMapper.getIEAccessories();

        ieAccessories.forEach((e) -> {
            redisService.lPush("integral_exchange:accessories", e);
        });

        return ieAccessories;
    }


    @Override
    @Transactional
    public Boolean exchange(Integer ieId) {

        Integer accId = checkStock(ieId);

        UserBackpack userBackpack = userService.setAccToBack(accId);

        return true;

    }

    @Synchronized
    public Integer checkStock(Integer ieId){

        IntegralExchange ie = this.getById(ieId);

        if(ie.getStock() - 1 < 0){
            Asserts.args("库存不足");
        }

        ie.setStock(ie.getStock() - 1);

        boolean b = this.updateById(ie);

        if(!b){
            Asserts.fail("服务器繁忙");
        }

        Boolean exchange = userService.exchange(ie.getIntegral());

        return ie.getAccessoriesId();
    }
}




