package com.cccase.casebackend.controller;

import com.cccase.casebackend.pojo.vo.PartitionVo;
import com.cccase.casebackend.service.PartitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/partition")
public class PartitionController{

    @Autowired
    private PartitionService partitionService;

    @GetMapping("/get")
    public List<PartitionVo> get(){

        return partitionService.getPartition();
    }

    @GetMapping("/gett")
    public String gett(){
        return partitionService.gett();
    }
}
