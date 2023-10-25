package com.cccase.casebackend.controller;

import com.cccase.casebackend.pojo.vo.AccessoriesVo;
import com.cccase.casebackend.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/case")
public class CaseController {

    @Autowired
    private CaseService caseService;

    @GetMapping("/getCaseAccById/{caseId}")
    public List<AccessoriesVo> getCaseAccessoriesById(@PathVariable Integer caseId){
        return caseService.getCaseAccessoriesById(caseId);
    };


}
