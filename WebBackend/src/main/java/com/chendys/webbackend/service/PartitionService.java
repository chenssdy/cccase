package com.chendys.webbackend.service;

import com.chendys.webbackend.pojo.Partition;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chendys.webbackend.pojo.dto.PartitionDto;
import com.chendys.webbackend.pojo.vo.Page;
import com.chendys.webbackend.pojo.vo.PartitionVo;

/**
* @author chens
* @description 针对表【tb_partition】的数据库操作Service
* @createDate 2023-06-10 16:24:50
*/
public interface PartitionService extends IService<Partition> {


    /**
     * 获取一页分区
     * @param page
     * @param num
     * @return
     */
    Page<PartitionVo> getPage(Integer page, Integer num);


    /**
     * 创建分区
     * @param partitionDto
     * @return
     */
    Partition create(PartitionDto partitionDto);

    /**
     * 修改分区
     * @param partition
     * @return
     */
    Partition update(Partition partition);
}
