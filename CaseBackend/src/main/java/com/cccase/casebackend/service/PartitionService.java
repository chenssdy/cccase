package com.cccase.casebackend.service;

import com.cccase.casebackend.pojo.Partition;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cccase.casebackend.pojo.vo.PartitionVo;

import java.util.List;

/**
* @author chens
* @description 针对表【tb_partition】的数据库操作Service
* @createDate 2023-10-14 14:58:55
*/
public interface PartitionService extends IService<Partition> {


    List<PartitionVo> getPartition();

    String gett();
}
