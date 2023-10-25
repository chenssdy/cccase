package com.cccase.casebackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cccase.casebackend.pojo.Partition;
import com.cccase.casebackend.pojo.vo.PartitionVo;
import com.cccase.casebackend.service.PartitionService;
import com.cccase.casebackend.mapper.PartitionMapper;
import com.cccase.casebackend.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author chens
* @description 针对表【tb_partition】的数据库操作Service实现
* @createDate 2023-10-14 14:58:55
*/
@Service
public class PartitionServiceImpl extends ServiceImpl<PartitionMapper, Partition>
    implements PartitionService{

    @Autowired
    private PartitionMapper partitionMapper;

    @Autowired
    private RedisService redisService;

    @Override
    public List<PartitionVo> getPartition() {

        Long size = redisService.lSize("home:partition");

        if(size > 0){

            List<Object> list = redisService.lRange("home:partition", 0, size);

            return list.stream().map(e -> {
                return (PartitionVo) e;
            }).collect(Collectors.toList());

        }

        List<PartitionVo> partitions = partitionMapper.getPartitions();

        partitions.forEach((e) -> {
            redisService.lPush("home:partition", e);
        });

        return partitions;
    }

    @Override
    public String gett() {
        return "null";
    }
}




