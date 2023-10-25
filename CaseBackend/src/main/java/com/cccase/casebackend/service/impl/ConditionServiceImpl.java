package com.cccase.casebackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cccase.casebackend.pojo.Condition;
import com.cccase.casebackend.service.ConditionService;
import com.cccase.casebackend.mapper.ConditionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author chens
* @description 针对表【tb_condition】的数据库操作Service实现
* @createDate 2023-10-15 18:53:08
*/
@Service
public class ConditionServiceImpl extends ServiceImpl<ConditionMapper, Condition>
    implements ConditionService{

    @Autowired
    private ConditionMapper conditionMapper;

    @Override
    public List<Condition> getConditionByRRId(Integer id) {

        return conditionMapper.getConditionByRRId(id);
    }
}




