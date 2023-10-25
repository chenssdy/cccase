package com.chendys.webbackend.controller;


import com.chendys.webbackend.pojo.PkConfig;
import com.chendys.webbackend.service.PkConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pk")
public class RkController {

    @Autowired
    private PkConfigService pkConfigService;

    @GetMapping("/get")
    public PkConfig get(){
        return pkConfigService.list().get(0);
    }

    @PostMapping("/update")
    public PkConfig update(@RequestBody PkConfig pkConfig){
        return pkConfigService.updateConfig(pkConfig);
    }
}
