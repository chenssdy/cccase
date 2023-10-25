package com.chendys.webbackend.controller;


import com.chendys.webbackend.pojo.Condition;
import com.chendys.webbackend.service.ConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/conditions")
public class ConditionController {

    @Autowired
    private ConditionService conditionService;

    @GetMapping("/get")
    public List<Condition> getList(){
        return conditionService.list();
    }
}
