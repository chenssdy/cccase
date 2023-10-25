package com.chendys.webbackend;

import com.chendys.webbackend.pojo.Partition;
import com.chendys.webbackend.pojo.RollRoom;
import com.chendys.webbackend.pojo.dto.IntegralExchangeDto;
import com.chendys.webbackend.pojo.dto.PartitionDto;
import com.chendys.webbackend.pojo.dto.RollRoomDto;
import com.chendys.webbackend.pojo.vo.*;
import com.chendys.webbackend.service.IntegralExchangeService;
import com.chendys.webbackend.service.PartitionService;
import com.chendys.webbackend.service.RollRoomService;
import com.chendys.webbackend.service.UserService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@MapperScan("com.chendys.mapper.*")
public class WebBackendApplicationTests {


//    @Test
    public void test(@Autowired RollRoomService rollRoomService){

        RollRoomDto rollRoomDto = new RollRoomDto();

        rollRoomDto.setCoverImg("test");
        rollRoomDto.setName("test");
//        rollRoomDto.setEndTime(new Date(new java.util.Date().getTime()));
//        rollRoomDto.setOpeningHours(new Date(new java.util.Date().getTime()));

        List<Integer> list = new ArrayList<>();

        list.add(4);
        list.add(9);

        rollRoomDto.setConditionsId(list);

        rollRoomService.createRollRoom(rollRoomDto);
    }

//    @Test
    public void test1(@Autowired RollRoomService rollRoomService){

        Page<RollRoomVo> rollRoomList = rollRoomService.getRollRoomList(1, 10);

        System.out.println(rollRoomList);
    }

//    @Test
    public void test2(@Autowired IntegralExchangeService integralExchangeService){

//        Page<IntegralExchangeVo> page = integralExchangeService.getPage(1, 10);

//        System.out.println(page);
    }


//        @Test
    public void test3(@Autowired IntegralExchangeService integralExchangeService){
        IntegralExchangeDto integralExchangeDto = new IntegralExchangeDto();
        integralExchangeDto.setAccessoriesId(5);
        integralExchangeDto.setStock(2);
        integralExchangeDto.setStatus(2);
        integralExchangeService.addIE(integralExchangeDto);

    }


//    @Test
    public void test4(@Autowired PartitionService partitionService){

//        Page<PartitionVo> page = partitionService.getPage(1, 10);

//        PartitionDto partitionDto = new PartitionDto();
//        partitionDto.setName("测试1");
//        partitionDto.setSort(2);
//
//        Partition partition = partitionService.create(partitionDto);

        Partition partition = new Partition();
        partition.setId(2);
        partition.setSort(10);
        partition.setName("测试1");

        Partition update = partitionService.update(partition);

        System.out.println();
    }

    @Test
    public void test4(@Autowired UserService userService){

//        Page<UserVo> page = userService.getPage(1, 10);

        Integer integer = userService.updateUserStatus(1, 2);

        System.out.println();
    }
}