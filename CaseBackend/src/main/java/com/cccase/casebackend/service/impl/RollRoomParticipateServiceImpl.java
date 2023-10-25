package com.cccase.casebackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cccase.casebackend.pojo.RollRoomParticipate;
import com.cccase.casebackend.pojo.User;
import com.cccase.casebackend.service.RollRoomParticipateService;
import com.cccase.casebackend.mapper.RollRoomParticipateMapper;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

/**
* @author chens
* @description 针对表【tb_roll_room_participate】的数据库操作Service实现
* @createDate 2023-10-15 20:40:09
*/
@Service
public class RollRoomParticipateServiceImpl extends ServiceImpl<RollRoomParticipateMapper, RollRoomParticipate>
    implements RollRoomParticipateService{

    @Override
    public Boolean joinRollRoom(Integer rrId) {

        RollRoomParticipate rollRoomParticipate = new RollRoomParticipate();

        rollRoomParticipate.setUserId(Integer.valueOf(MDC.get("userId")));
        rollRoomParticipate.setRollRoomId(rrId);

        return this.save(rollRoomParticipate);
    }
}




