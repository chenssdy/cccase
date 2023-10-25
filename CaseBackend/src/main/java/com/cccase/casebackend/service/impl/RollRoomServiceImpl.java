package com.cccase.casebackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cccase.casebackend.pojo.RollRoom;
import com.cccase.casebackend.pojo.vo.IntegralExchangeVo;
import com.cccase.casebackend.pojo.vo.RollRoomVo;
import com.cccase.casebackend.service.*;
import com.cccase.casebackend.mapper.RollRoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author chens
* @description 针对表【tb_roll_room】的数据库操作Service实现
* @createDate 2023-10-15 18:48:27
*/
@Service
public class RollRoomServiceImpl extends ServiceImpl<RollRoomMapper, RollRoom>
    implements RollRoomService{


    @Autowired
    private RollRoomMapper rollRoomMapper;

    @Autowired
    private AccessoriesService accessoriesService;

    @Autowired
    private ConditionService conditionService;

    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private RollRoomParticipateService rollRoomParticipateService;

    @Override
    public List<RollRoomVo> getRRs() {

        Long size = redisService.lSize("roll_room:list");

        if(size > 0){

            List<Object> list = redisService.lRange("roll_room:list", 0, size);

            return list.stream().map(e -> {
                return (RollRoomVo) e;
            }).collect(Collectors.toList());

        }

        List<RollRoomVo> rrs = rollRoomMapper.getRRs();

        rrs.forEach(e -> {
            e.setAccessoriesVos(accessoriesService.getAccsByRRId(e.getId()));
            e.setConditions(conditionService.getConditionByRRId(e.getId()));
            e.setUsers(userService.getUsersByRRId(e.getId()));
            redisService.lPush("roll_room:list", e);
        });

        return rrs;
    }

    @Override
    public Boolean joinRollRoom(Integer rrId) {

        return rollRoomParticipateService.joinRollRoom(rrId);
    }
}




