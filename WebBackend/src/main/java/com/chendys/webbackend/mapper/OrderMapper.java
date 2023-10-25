package com.chendys.webbackend.mapper;

import com.chendys.webbackend.pojo.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chendys.webbackend.pojo.Sales;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

/**
* @author chens
* @description 针对表【tb_order】的数据库操作Mapper
* @createDate 2023-05-31 18:14:47
* @Entity com.chendys.webbackend.pojo.Order
*/
@Mapper
public interface OrderMapper extends BaseMapper<Order> {


    List<Sales> getSales(@Param("day") Integer day);
}




