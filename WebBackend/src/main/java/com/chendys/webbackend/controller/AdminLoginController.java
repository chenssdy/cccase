package com.chendys.webbackend.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chendys.webbackend.pojo.Admin;
import com.chendys.webbackend.pojo.Menu;
import com.chendys.webbackend.pojo.vo.AdminVo;
import com.chendys.webbackend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 **/
@RestController
@RequestMapping("/admin")
public class AdminLoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public AdminVo Login(@RequestBody Admin user){
        System.out.println(user);
        return loginService.login(user);
    }

    @GetMapping("/user/logout")
    public AdminVo Logout(){
        System.out.println("logout");
        return loginService.logout();
    }

    @GetMapping("/getMenu")
    public List<Menu> getAdminMenu(){
        return loginService.getMenu();
    }

    @GetMapping("/getPermission")
    public List<String> getPermission(){
        return loginService.getPermission();
    }
}
