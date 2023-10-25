package com.chendys.webbackend.controller;


import com.chendys.webbackend.pojo.Homedata;
import com.chendys.webbackend.service.HomedataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {


    @Autowired
    private HomedataService homedataService;

    /**
     * 获取首页数据
     * @return
     */
    @GetMapping
    public List<Homedata> getHomeData(){
        return homedataService.list();
    }


}
