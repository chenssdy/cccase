package com.cccase.casebackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cccase.casebackend.mapper.AccessoriesMapper;
import com.cccase.casebackend.pojo.Case;
import com.cccase.casebackend.pojo.vo.AccessoriesVo;
import com.cccase.casebackend.pojo.vo.PartitionVo;
import com.cccase.casebackend.service.CaseService;
import com.cccase.casebackend.mapper.CaseMapper;
import com.cccase.casebackend.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author chens
* @description 针对表【tb_case】的数据库操作Service实现
* @createDate 2023-10-14 14:58:55
*/
@Service
public class CaseServiceImpl extends ServiceImpl<CaseMapper, Case>
    implements CaseService{


    @Autowired
    private AccessoriesMapper accessoriesMapper;

    @Autowired
    private RedisService redisService;

    @Override
    public List<AccessoriesVo> getCaseAccessoriesById(Integer caseId) {

        Long size = redisService.lSize("case:accessories:" + caseId);

        if(size > 0){

            List<Object> list = redisService.lRange("case:accessories:" + caseId, 0, size);

            return list.stream().map(e -> {
                return (AccessoriesVo) e;
            }).collect(Collectors.toList());

        }

        List<AccessoriesVo> accessoriesVos = accessoriesMapper.getCaseAccessoriesById(caseId);

        accessoriesVos.forEach((e) -> {
            redisService.lPush("case:accessories:" + caseId, e);
        });


        return accessoriesVos;
    }
}




