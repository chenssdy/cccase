package com.chendys.webbackend.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chendys.webbackend.pojo.Accessories;
import com.chendys.webbackend.pojo.Case;
import com.chendys.webbackend.pojo.CaseAccessories;
import com.chendys.webbackend.pojo.CaseSales;
import com.chendys.webbackend.pojo.vo.CaseSalesVo;
import com.chendys.webbackend.pojo.vo.CaseVo;
import com.chendys.webbackend.pojo.vo.Page;
import com.chendys.webbackend.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cases")
public class CaseController {

    @Autowired
    private CaseService caseService;


    /**
     * 获取一页盲盒数据
     * @param page 页码
     * @param num 一页多少条数据
     * @return
     */
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('admin:case:list')")
    public Page<CaseVo> getCases(@RequestParam("page") Integer page, @RequestParam("num") Integer num){
        return caseService.getPage(page, num);
    }

    /**
     * 修改盲盒
     * @param case_
     * @return
     */
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('admin:case:update')")
    public Case updateCase(@RequestBody Case case_){
        return caseService.updateCase(case_);
    };

    /**
     * 添加盲盒
     * @param case_
     * @return
     */
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('admin:case:save')")
    public Case addCase(@RequestBody Case case_){
        return caseService.addCase(case_);
    };

    /**
     * 删除盲盒
     * @param id
     * @return
     */
    @PostMapping("/del/{id}")
    @PreAuthorize("hasAuthority('admin:case:delete')")
    public String delCase(@PathVariable Integer id){
        return caseService.delCase(id);
    };

    /**
     * 批量删除盲盒
     * @param ids 盲盒id
     * @return
     */
    @PostMapping("/delMultiple")
    @PreAuthorize("hasAuthority('admin:case:delete')")
    public String delMultiple(@RequestParam("ids") List<Integer> ids){
        return caseService.deleteByIds(ids);
    }

    /**
     * 添加盲盒中饰品
     * @param caseId
     * @return
     */
    @PostMapping("addCaseAcc")
    @PreAuthorize("hasAuthority('admin:case:save')")
    public CaseAccessories addCaseAcc(@RequestParam("case_id") Integer caseId, @RequestParam("acc_id") Integer accId){
        return caseService.addCaseAcc(caseId, accId);
    }

    /**
     * 删除盲盒中饰品
     * @param id
     * @return
     */
    @PostMapping("delCaseAcc/{id}")
    @PreAuthorize("hasAuthority('admin:case:delete')")
    public String delCaseAcc(@PathVariable Integer id){
        return caseService.delCaseAcc(id);
    }

    /**
     * 修改盲盒中饰品
     * @param id
     * @return
     */
    @PostMapping("updateCaseAcc")
    @PreAuthorize("hasAuthority('admin:case:update')")
    public CaseAccessories updateCaseAcc(@RequestParam("id") Integer id, @RequestParam("acc_id") Integer accId){
        return caseService.updateCaseAcc(id, accId);
    }

    /**
     * 获取盲盒top10榜单
     * @return
     */
    @GetMapping("/getCaseSalesTop")
    public List<CaseSalesVo> getCaseSalesTop(){
        return caseService.getCaseSalesTop();
    }

}
