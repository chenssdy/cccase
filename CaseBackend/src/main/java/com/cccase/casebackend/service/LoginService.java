package com.cccase.casebackend.service;

import com.cccase.casebackend.pojo.dto.LoginDto;
import com.cccase.casebackend.pojo.vo.UserVo;

public interface LoginService {


    UserVo login(LoginDto dto);
}
