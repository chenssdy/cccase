package com.cccase.casebackend.service;

import com.cccase.casebackend.pojo.Accessories;
import com.cccase.casebackend.pojo.Case;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cccase.casebackend.pojo.vo.AccessoriesVo;

import java.util.List;

/**
* @author chens
* @description 针对表【tb_case】的数据库操作Service
* @createDate 2023-10-14 14:58:55
*/
public interface CaseService extends IService<Case> {


    List<AccessoriesVo> getCaseAccessoriesById(Integer caseId);
}
