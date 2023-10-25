package com.cccase.casebackend.controller;

import com.cccase.casebackend.pojo.dto.LoginDto;
import com.cccase.casebackend.pojo.vo.UserVo;
import com.cccase.casebackend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;


    @PostMapping
    public UserVo login(@RequestBody LoginDto loginDto){
        return loginService.login(loginDto);
    }
}
