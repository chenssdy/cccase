package com.chendys.webbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chendys.webbackend.mapper.*;
import com.chendys.webbackend.pojo.Condition;
import com.chendys.webbackend.pojo.RollRoom;
import com.chendys.webbackend.pojo.RollRoomAccessories;
import com.chendys.webbackend.pojo.dto.RollRoomDto;
import com.chendys.webbackend.pojo.vo.CaseVo;
import com.chendys.webbackend.pojo.vo.Page;
import com.chendys.webbackend.pojo.vo.RollRoomVo;
import com.chendys.webbackend.service.RollRoomAccessoriesService;
import com.chendys.webbackend.service.RollRoomService;
import com.chendys.webbackend.util.exception.Asserts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

/**
* @author chens
* @description 针对表【tb_roll_room】的数据库操作Service实现
* @createDate 2023-06-04 12:41:05
*/
@Service
public class RollRoomServiceImpl extends ServiceImpl<RollRoomMapper, RollRoom>
    implements RollRoomService{

    @Autowired
    private RollRoomMapper rollRoomMapper;

    @Autowired
    private RollRoomConditionMapper rollRoomConditionMapper;

    @Autowired
    private ConditionMapper conditionMapper;

    @Autowired
    private RollRoomParticipateMapper rollRoomParticipateMapper;

    @Autowired
    private RollRoomAccessoriesMapper rollRoomAccessoriesMapper;

    @Override
    public Page<RollRoomVo> getRollRoomList(Integer page, Integer num) {

        Page<RollRoomVo> rollRoomPage = new Page<>(page, num);

        List<RollRoomVo> rollRooms = rollRoomMapper.getPage(rollRoomPage.getOffset(), num);

        if(rollRooms.size() == 0){
            return null;
        }

        Integer integer = rollRoomMapper.selectCount(null);

        rollRooms.forEach(e -> {
            e.setConditions(conditionMapper.selectRollRoomConditions(e.getId()));
            e.setRollRoomParticipates(rollRoomParticipateMapper.selectRollRoomParticipates(e.getId()));
        });

        rollRoomPage.setList(rollRooms);
        rollRoomPage.setTotal(Long.valueOf(integer));
        rollRoomPage.setTotalPage(rollRoomPage.getTotalPage());

        return rollRoomPage;
    }

    @Override
    @Transactional
    public RollRoomVo createRollRoom(RollRoomDto roomDto) {


        RollRoomVo rollRoom = new RollRoomVo();

        rollRoom.setCoverImg(roomDto.getCoverImg());
        rollRoom.setOpeningHours(new Date(roomDto.getOpeningHours()));
        rollRoom.setEndTime(new Date(roomDto.getEndTime()));
        rollRoom.setName(roomDto.getName());

        int insert = rollRoomMapper.insert(rollRoom);

        if(insert <= 0){
            Asserts.fail("创建roll房失败,请联系管理员或者检查参数是否正确");
        }

        List<Integer> conditionsId = roomDto.getConditionsId();

        int i = rollRoomConditionMapper.addAll(conditionsId, rollRoom.getId());

        if(i <= 0){
            Asserts.fail("创建roll房失败,请联系管理员或者检查参数是否正确");
        }

        List<Condition> conditions = conditionMapper.selectRollRoomConditions(rollRoom.getId());

        rollRoom.setConditions(conditions);

        return rollRoom;
    }

    @Override
    public RollRoomAccessories addRollRoomAcc(Integer rid, Integer aid) {

        RollRoomAccessories rollRoomAccessories = new RollRoomAccessories();
        rollRoomAccessories.setRollRoomId(rid);
        rollRoomAccessories.setAccessoriesId(aid);

        int insert = rollRoomAccessoriesMapper.insert(rollRoomAccessories);

        if(insert <= 0){
            Asserts.fail("添加饰品失败,请联系管理员或者检查参数是否正确");
        }

        return rollRoomAccessories;
    }

    @Override
    public String deleteRollRoomAcc(Integer id) {

        int i = rollRoomAccessoriesMapper.deleteById(id);

        if(i <= 0){
            Asserts.fail("删除饰品失败,请联系管理员或者检查参数是否正确");
        }

        return "删除饰品成功";
    }

    @Override
    public RollRoomAccessories updateRollRoomAcc(Integer id, Integer aId) {

        RollRoomAccessories rollRoomAccessories = new RollRoomAccessories();
        rollRoomAccessories.setAccessoriesId(aId);
        rollRoomAccessories.setId(Long.valueOf(id));
        int i = rollRoomAccessoriesMapper.updateById(rollRoomAccessories);

        if(i <= 0){
            Asserts.fail("修改饰品失败,请联系管理员或者检查参数是否正确");
        }

        return rollRoomAccessories;
    }
}




