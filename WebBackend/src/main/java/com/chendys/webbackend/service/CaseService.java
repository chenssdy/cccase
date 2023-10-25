package com.chendys.webbackend.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chendys.webbackend.pojo.Case;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chendys.webbackend.pojo.CaseAccessories;
import com.chendys.webbackend.pojo.CaseSales;
import com.chendys.webbackend.pojo.vo.CaseSalesVo;
import com.chendys.webbackend.pojo.vo.CaseVo;
import com.chendys.webbackend.pojo.vo.Page;

import java.util.List;

/**
* @author chens
* @description 针对表【tb_case】的数据库操作Service
* @createDate 2023-06-01 10:19:31
*/
public interface CaseService extends IService<Case> {


    /**
     * 获取盲盒top10榜单
     * @return
     */
    List<CaseSalesVo> getCaseSalesTop();

    /**
     * 获取一页盲盒数据
     * @param page 页码
     * @param num 一页多少条数据
     * @return
     */
    Page<CaseVo> getPage(Integer page, Integer num);

    /**
     * 修改盲盒
     * @param case_
     * @return
     */
    Case updateCase(Case case_);

    /**
     * 添加盲盒
     * @param case_
     * @return
     */
    Case addCase(Case case_);

    /**
     * 删除盲盒
     * @param id
     * @return
     */
    String delCase(Integer id);

    /**
     * 批量删除盲盒
     * @param ids 饰品id
     * @return
     */
    String deleteByIds(List<Integer> ids);

    /**
     * 添加盲盒中饰品
     * @param caseId
     * @return
     */
    CaseAccessories addCaseAcc(Integer caseId, Integer accId);

    /**
     * 删除盲盒中饰品
     * @param id
     * @return
     */
    String delCaseAcc(Integer id);

    /**
     * 修改盲盒中饰品
     * @param caseAccId
     * @param accId
     * @return
     */
    CaseAccessories updateCaseAcc(Integer caseAccId, Integer accId);
}
