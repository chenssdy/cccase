package com.cccase.casebackend.service.impl;

import cn.hutool.core.collection.ListUtil;
import com.cccase.casebackend.pojo.Case;
import com.cccase.casebackend.pojo.User;
import com.cccase.casebackend.pojo.UserBackpack;
import com.cccase.casebackend.pojo.vo.AccessoriesVo;
import com.cccase.casebackend.pojo.vo.UserBackpackVo;
import com.cccase.casebackend.service.CaseService;
import com.cccase.casebackend.service.OpenCaseService;
import com.cccase.casebackend.service.UserService;
import com.cccase.casebackend.util.exception.Asserts;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class OpenCaseServiceImpl implements OpenCaseService {


    @Autowired
    private CaseService caseService;

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public UserBackpackVo openCase(Integer caseId) {

        Case openCase = caseService.getById(caseId);

        Boolean bool = userService.OpenCase(openCase.getPrice());

        List<AccessoriesVo> caseAccessoriesById = caseService.getCaseAccessoriesById(caseId);

        ArrayList<Integer> ids = new ArrayList<>();

        caseAccessoriesById.forEach(e -> {
            int num = (int) (e.getProbability() * 100);

            for (int i = 0; i < num; i++) {
                ids.add(e.getId());
            }
        });

        Collections.shuffle(ids);

        int random = (int) (Math.random() * 100);

        Integer integer = ids.get(random);

        AccessoriesVo accessoriesVo = null;

        List<AccessoriesVo> collect = caseAccessoriesById.stream().filter(e -> {
            if (e.getId().equals(integer)) {
                return true;
            }
            return false;
        }).collect(Collectors.toList());

        accessoriesVo = collect.get(0);

        UserBackpack userBackpack = userService.setAccToBack(accessoriesVo.getId());

        UserBackpackVo userBackpackVo = new UserBackpackVo();

        userBackpackVo.setBackpackId(userBackpack.getId());
        userBackpackVo.setStatus(userBackpack.getStatus());
        userBackpackVo.setAccessories(accessoriesVo);

        return userBackpackVo;
    }
}
