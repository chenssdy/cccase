package com.cccase.casebackend.service;

import com.cccase.casebackend.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cccase.casebackend.pojo.UserBackpack;
import com.cccase.casebackend.pojo.vo.UserVo;

import java.util.List;

/**
* @author chens
* @description 针对表【tb_user】的数据库操作Service
* @createDate 2023-10-14 20:24:06
*/
public interface UserService extends IService<User> {


    Boolean OpenCase(Double price);

    UserBackpack setAccToBack(Integer accId);

    Boolean exchange(Integer integer);

    List<User> getUsersByRRId(Integer id);

    UserVo accExchangeBalance(Integer backpackId);

    UserVo retrieveAcc(Integer backpackId);

    UserVo getUser();
}
