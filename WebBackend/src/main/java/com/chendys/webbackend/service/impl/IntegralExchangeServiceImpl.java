package com.chendys.webbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chendys.webbackend.mapper.AccessoriesMapper;
import com.chendys.webbackend.pojo.Accessories;
import com.chendys.webbackend.pojo.IntegralExchange;
import com.chendys.webbackend.pojo.dto.IntegralExchangeDto;
import com.chendys.webbackend.pojo.vo.IntegralExchangeVo;
import com.chendys.webbackend.pojo.vo.Page;
import com.chendys.webbackend.pojo.vo.RollRoomVo;
import com.chendys.webbackend.service.AccessoriesService;
import com.chendys.webbackend.service.IntegralExchangeService;
import com.chendys.webbackend.mapper.IntegralExchangeMapper;
import com.chendys.webbackend.util.exception.Asserts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author chens
* @description 针对表【tb_integral_exchange】的数据库操作Service实现
* @createDate 2023-06-06 14:25:58
*/
@Service
public class IntegralExchangeServiceImpl extends ServiceImpl<IntegralExchangeMapper, IntegralExchange>
    implements IntegralExchangeService{

    private final Logger logger = LoggerFactory.getLogger(IntegralExchangeServiceImpl.class);

    @Autowired
    private IntegralExchangeMapper integralExchangeMapper;

    @Autowired
    private AccessoriesMapper accessoriesMapper;

    @Override
    public Page<IntegralExchangeVo> getPage(Integer page, Integer num, Integer status) {

        logger.info("创建分页类");
        Page<IntegralExchangeVo> pageVo = new Page<>(page, num);

        logger.info("查询数据");
        List<IntegralExchangeVo> integralExchanges = integralExchangeMapper.getPage(pageVo.getOffset(), num, status);

        logger.info("查询数据结果 ==> {}", integralExchanges.toString());
        if(integralExchanges.size() == 0){
            logger.info("无数据,返回null");
            return null;
        }

        logger.info("查询数据库总数据量");
        Integer integer = integralExchangeMapper.selectCount(null);

        logger.info("将数据添加至分页对象");
        pageVo.setList(integralExchanges);
        logger.info("设置分页对象数据总条数");
        pageVo.setTotal(Long.valueOf(integer));
        logger.info("设置分页对象总页数");
        pageVo.setTotalPage(pageVo.getTotalPage());

        logger.info("返回分页数据");
        return pageVo;
    }

    @Override
    public IntegralExchangeVo addIE(IntegralExchangeDto integralExchangeDto) {

        logger.info("添加可兑换饰品");
        IntegralExchangeVo integralExchangeVo = new IntegralExchangeVo();
        integralExchangeVo.setAccessoriesId(integralExchangeDto.getAccessoriesId());
        integralExchangeVo.setStock(integralExchangeDto.getStock());
        integralExchangeVo.setStatus(integralExchangeDto.getStatus());
        logger.info("创建与装配实体类");

        int i = integralExchangeMapper.addIE(integralExchangeVo);
        logger.info("执行sql");
        if(i <= 0){
            logger.error("添加失败了");
            Asserts.fail("添加失败，请联系管理员或检查参数是否正确");
        }

        return integralExchangeVo;
    }

    @Override
    public IntegralExchangeVo updateIE(IntegralExchange integralExchange) {

        int i = integralExchangeMapper.updateById(integralExchange);

        if(i <= 0){
            Asserts.fail("修改失败，请联系管理员或检查参数是否正确");
        }

        Accessories accessories = accessoriesMapper.selectById(integralExchange.getAccessoriesId());

        IntegralExchangeVo integralExchangeVo = new IntegralExchangeVo(integralExchange);
        integralExchangeVo.setAccessories(accessories);

        return integralExchangeVo;
    }

    @Override
    public String deleteIE(Integer id) {

        int i = integralExchangeMapper.deleteById(id);

        if(i <= 0){
            Asserts.fail("删除失败，请联系管理员或检查参数是否正确");
        }

        return "删除成功";
    }
}




