package com.cccase.casebackend.mapper;

import com.cccase.casebackend.pojo.Partition;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cccase.casebackend.pojo.vo.PartitionVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author chens
* @description 针对表【tb_partition】的数据库操作Mapper
* @createDate 2023-10-14 14:58:55
* @Entity com.cccase.casebackend.pojo.Partition
*/
@Mapper
public interface PartitionMapper extends BaseMapper<Partition> {

    List<PartitionVo> getPartitions();
}




