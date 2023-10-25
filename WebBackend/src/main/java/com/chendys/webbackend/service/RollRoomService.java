package com.chendys.webbackend.service;

import com.chendys.webbackend.pojo.RollRoom;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chendys.webbackend.pojo.RollRoomAccessories;
import com.chendys.webbackend.pojo.dto.RollRoomDto;
import com.chendys.webbackend.pojo.vo.Page;
import com.chendys.webbackend.pojo.vo.RollRoomVo;

import java.util.List;

/**
* @author chens
* @description 针对表【tb_roll_room】的数据库操作Service
* @createDate 2023-06-04 12:41:05
*/
public interface RollRoomService extends IService<RollRoom> {

    /**
     * 获roll房列表
     * @param page
     * @param num
     * @return
     */
    Page<RollRoomVo> getRollRoomList(Integer page, Integer num);

    /**
     * 创建roll房
     * @param roomDto
     * @return
     */
    RollRoomVo createRollRoom(RollRoomDto roomDto);

    /**
     * 添加roll房饰品
     * @param
     * @return
     */
    RollRoomAccessories addRollRoomAcc(Integer rid, Integer aid);

    /**
     * 删除roll房饰品
     * @param
     * @return
     */
    String deleteRollRoomAcc(Integer id);

    /**
     * 修改roll房饰品
     * @param
     * @return
     */
    RollRoomAccessories updateRollRoomAcc(Integer id, Integer aId);

}
