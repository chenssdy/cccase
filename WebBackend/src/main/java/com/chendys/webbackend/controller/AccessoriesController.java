package com.chendys.webbackend.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chendys.webbackend.pojo.Accessories;
import com.chendys.webbackend.service.AccessoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accessories")
public class AccessoriesController {

    @Autowired
    private AccessoriesService accessoriesService;


    /**
     * 获取一页饰品数据
     * @param page
     * @param num
     * @return
     */
    @GetMapping("/page")
    @PreAuthorize("hasAuthority('admin:accessories:list')")
    public IPage<Accessories> getPage(@RequestParam("page") Integer page, @RequestParam("num") Integer num){
        return accessoriesService.getPage(page, num);
    }

    /**
     * 修改饰品
     * @param accessories 饰品信息
     * @return
     */
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('admin:accessories:list')")
    public Accessories update(@RequestBody Accessories accessories){
        return accessoriesService.updateAccessoriesById(accessories);
    }

    /**
     * 添加饰品
     * @param accessories 饰品信息
     * @return
     */
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('admin:accessories:save')")
    public Accessories create(@RequestBody Accessories accessories){
        return accessoriesService.createAccessories(accessories);
    }

    /**
     * 删除饰品
     * @param id 饰品id
     * @return
     */
    @PostMapping("/del/{id}")
    @PreAuthorize("hasAuthority('admin:accessories:delete')")
    public String del(@PathVariable Integer id){
        return accessoriesService.deleteById(id);
    }

    /**
     * 批量删除饰品
     * @param ids 饰品id
     * @return
     */
    @PostMapping("/delMultiple")
    @PreAuthorize("hasAuthority('admin:accessories:delete')")
    public String delMultiple(@RequestParam("ids") List<Integer> ids){
        return accessoriesService.deleteByIds(ids);
    }
}
