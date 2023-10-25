package com.chendys.webbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chendys.webbackend.mapper.CaseAccessoriesMapper;
import com.chendys.webbackend.mapper.CaseSalesMapper;
import com.chendys.webbackend.pojo.Case;
import com.chendys.webbackend.pojo.CaseAccessories;
import com.chendys.webbackend.pojo.vo.CaseAccessoriesVo;
import com.chendys.webbackend.pojo.vo.CaseSalesVo;
import com.chendys.webbackend.pojo.vo.CaseVo;
import com.chendys.webbackend.pojo.vo.Page;
import com.chendys.webbackend.service.CaseService;
import com.chendys.webbackend.mapper.CaseMapper;
import com.chendys.webbackend.util.exception.Asserts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
* @author chens
* @description 针对表【tb_case】的数据库操作Service实现
* @createDate 2023-06-01 10:19:31
*/
@Service
public class CaseServiceImpl extends ServiceImpl<CaseMapper, Case>
    implements CaseService{

    @Autowired
    private CaseSalesMapper caseSalesMapper;

    @Autowired
    private CaseMapper caseMapper;

    @Autowired
    private CaseAccessoriesMapper caseAccessoriesMapper;

    @Override
    public List<CaseSalesVo> getCaseSalesTop() {

        return caseSalesMapper.selectSalesTop();
    }

    @Override
    public Page<CaseVo> getPage(Integer page, Integer num) {

        Page<CaseVo> casePage = new Page<>();
        casePage.setPageNum(page);
        casePage.setPageSize(num);

        page = (page - 1) * num;

        List<CaseVo> cases = caseMapper.getPage(page, num);

        if(cases.size() == 0){
            return null;
        }

        Integer integer = caseMapper.selectCount(null);

        cases.forEach(e -> {
            e.setCaseAccessoriesList(caseAccessoriesMapper.selectAccByCaseId(e.getId()));
        });

        casePage.setList(cases);
        casePage.setTotal(Long.valueOf(integer));
        casePage.setTotalPage(casePage.getTotalPage());

        return casePage;
    }

    @Transactional
    @Override
    public Case updateCase(Case case_) {

        int update = caseMapper.updateById(case_);

        if(update <= 0){
            Asserts.fail("修改失败，请联系管理员或检查参数是否正确");
        }

        return case_;
    }

    @Transactional
    @Override
    public Case addCase(Case case_) {
        int i = caseMapper.insert(case_);

        if(i <= 0){
            Asserts.fail("添加失败，请联系管理员或检查参数是否正确");
        }

        return case_;
    }

    @Transactional
    @Override
    public String delCase(Integer id) {
        int i = caseMapper.deleteById(id);


        return "删除成功";
    }

    @Override
    public String deleteByIds(List<Integer> ids) {
        int i = caseMapper.deleteBatchIds(ids);

        if(i <= 0){
            Asserts.fail("删除失败，请联系管理员");
        }

        return "删除成功";
    }

    @Override
    public CaseAccessories addCaseAcc(Integer caseId, Integer accId) {

        CaseAccessories caseAccessories = new CaseAccessories();
        caseAccessories.setCaseId(caseId);
        caseAccessories.setAccessoriesId(accId);

        int i = caseAccessoriesMapper.insert(caseAccessories);

        if(i <= 0){
            Asserts.fail("添加失败，请联系管理员或检查参数是否正确");
        }

        return caseAccessories;

    }

    @Override
    public String delCaseAcc(Integer id) {

        int delete = caseAccessoriesMapper.deleteById(id);

        if(delete <= 0){
            Asserts.fail("删除失败，请联系管理员");
        }

        return "删除成功";

    }

    @Override
    public CaseAccessories updateCaseAcc(Integer caseAccId, Integer accId) {

        CaseAccessories caseAccessories = new CaseAccessories();

        caseAccessories.setId(caseAccId);
        caseAccessories.setAccessoriesId(accId);

        int i = caseAccessoriesMapper.updateById(caseAccessories);

        if(i <= 0){
            Asserts.fail("修改失败，请联系管理员");
        }

        return caseAccessories;

    }
}




