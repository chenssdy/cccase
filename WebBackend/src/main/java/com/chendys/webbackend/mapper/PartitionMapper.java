package com.chendys.webbackend.mapper;

import com.chendys.webbackend.pojo.Partition;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chendys.webbackend.pojo.vo.PartitionVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author chens
* @description 针对表【tb_partition】的数据库操作Mapper
* @createDate 2023-06-10 16:24:50
* @Entity com.chendys.webbackend.pojo.Partition
*/
@Mapper
public interface PartitionMapper extends BaseMapper<Partition> {


    List<PartitionVo> getPage(@Param("offset") Integer offset,@Param("num") Integer num);
}




