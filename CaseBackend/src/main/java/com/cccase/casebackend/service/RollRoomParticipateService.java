package com.cccase.casebackend.service;

import com.cccase.casebackend.pojo.RollRoomParticipate;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author chens
* @description 针对表【tb_roll_room_participate】的数据库操作Service
* @createDate 2023-10-15 20:40:09
*/
public interface RollRoomParticipateService extends IService<RollRoomParticipate> {

    Boolean joinRollRoom(Integer rrId);
}
