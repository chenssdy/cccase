package com.cccase.casebackend.service;

import com.cccase.casebackend.pojo.vo.AccessoriesVo;
import com.cccase.casebackend.pojo.vo.UserBackpackVo;

public interface OpenCaseService {

    UserBackpackVo openCase(Integer caseId);
}
