package com.cccase.casebackend.mapper;

import com.cccase.casebackend.pojo.RollRoom;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cccase.casebackend.pojo.vo.RollRoomVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author chens
* @description 针对表【tb_roll_room】的数据库操作Mapper
* @createDate 2023-10-15 18:48:27
* @Entity com.cccase.casebackend.pojo.RollRoom
*/
@Mapper
public interface RollRoomMapper extends BaseMapper<RollRoom> {

    List<RollRoomVo> getRRs();
}




