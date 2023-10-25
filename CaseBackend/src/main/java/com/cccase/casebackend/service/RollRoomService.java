package com.cccase.casebackend.service;

import com.cccase.casebackend.pojo.RollRoom;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cccase.casebackend.pojo.vo.RollRoomVo;

import java.util.List;

/**
* @author chens
* @description 针对表【tb_roll_room】的数据库操作Service
* @createDate 2023-10-15 18:48:27
*/
public interface RollRoomService extends IService<RollRoom> {

    List<RollRoomVo> getRRs();

    Boolean joinRollRoom(Integer rrId);
}
