package com.cccase.casebackend.controller;

import com.cccase.casebackend.pojo.vo.AccessoriesVo;
import com.cccase.casebackend.pojo.vo.UserBackpackVo;
import com.cccase.casebackend.service.OpenCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/openCase")
public class OpenCaseController {

    @Autowired
    private OpenCaseService openCaseService;


    @PostMapping("/openCase/{caseId}")
    public UserBackpackVo openCase(@PathVariable Integer caseId){
        return openCaseService.openCase(caseId);
    }

}
