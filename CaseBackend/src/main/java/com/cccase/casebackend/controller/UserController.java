package com.cccase.casebackend.controller;

import com.cccase.casebackend.pojo.vo.UserVo;
import com.cccase.casebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/accExchangeBalance/{backpackId}")
    public UserVo accExchangeBalance(@PathVariable Integer backpackId){
        return userService.accExchangeBalance(backpackId);
    }

    @PostMapping("/retrieveAcc/{backpackId}")
    public UserVo retrieveAcc(@PathVariable Integer backpackId){
        return userService.retrieveAcc(backpackId);
    }

    @GetMapping("/get")
    public UserVo getUser(){
        return userService.getUser();
    }
}
