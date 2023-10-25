package com.chendys.webbackend.controller;

import com.chendys.webbackend.pojo.Partition;
import com.chendys.webbackend.pojo.dto.PartitionDto;
import com.chendys.webbackend.pojo.vo.Page;
import com.chendys.webbackend.pojo.vo.PartitionVo;
import com.chendys.webbackend.service.PartitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/partitions")
public class PartitionController {

    @Autowired
    private PartitionService partitionService;

    /**
     * 获取一页分区
     * @param page
     * @param num
     * @return
     */
    @GetMapping("/get")
    public Page<PartitionVo> getPage(@RequestParam("page") Integer page, @RequestParam("num") Integer num){
        return partitionService.getPage(page, num);
    };

    /**
     * 创建分区
     * @param partitionDto
     * @return
     */
    @PostMapping("/create")
    public Partition create(@RequestBody PartitionDto partitionDto){
        return partitionService.create(partitionDto);
    };

    /**
     * 修改分区
     * @param partition
     * @return
     */
    @PostMapping("/update")
    public Partition update(@RequestBody Partition partition){
        return partitionService.update(partition);
    };

}
