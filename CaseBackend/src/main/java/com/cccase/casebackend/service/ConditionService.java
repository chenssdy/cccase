package com.cccase.casebackend.service;

import com.cccase.casebackend.pojo.Condition;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author chens
* @description 针对表【tb_condition】的数据库操作Service
* @createDate 2023-10-15 18:53:08
*/
public interface ConditionService extends IService<Condition> {

    List<Condition> getConditionByRRId(Integer id);
}
