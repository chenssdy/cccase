package com.chendys.webbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chendys.webbackend.pojo.Condition;
import com.chendys.webbackend.service.ConditionService;
import com.chendys.webbackend.mapper.ConditionMapper;
import org.springframework.stereotype.Service;

/**
* @author chens
* @description 针对表【tb_condition】的数据库操作Service实现
* @createDate 2023-06-04 13:53:37
*/
@Service
public class ConditionServiceImpl extends ServiceImpl<ConditionMapper, Condition>
    implements ConditionService{

}




