package com.cccase.casebackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cccase.casebackend.mapper.UserBackpackMapper;
import com.cccase.casebackend.pojo.Accessories;
import com.cccase.casebackend.pojo.User;
import com.cccase.casebackend.pojo.UserBackpack;
import com.cccase.casebackend.pojo.vo.UserBackpackVo;
import com.cccase.casebackend.pojo.vo.UserVo;
import com.cccase.casebackend.service.AccessoriesService;
import com.cccase.casebackend.service.UserService;
import com.cccase.casebackend.mapper.UserMapper;
import com.cccase.casebackend.util.exception.Asserts;
import lombok.Synchronized;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
* @author chens
* @description 针对表【tb_user】的数据库操作Service实现
* @createDate 2023-10-14 20:24:06
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserBackpackMapper backpackMapper;

    @Autowired
    private AccessoriesService accessoriesService;

    @Override
    @Synchronized
    public Boolean OpenCase(Double price) {

        User user = this.getById(Integer.valueOf(MDC.get("userId")));

        if(user.getBalance().doubleValue() - price < 0){
            Asserts.args("用户余额不足");
        }

        user.setBalance(BigDecimal.valueOf(user.getBalance().doubleValue() - price));

        user.setIntegral(user.getIntegral() + price.intValue());

        boolean save = this.updateById(user);

        if(!save){
            Asserts.fail("服务器繁忙,请稍后再试");
        }

        return true;
    }

    @Override
    public UserBackpack setAccToBack(Integer accId) {

        UserBackpack userBackpack = new UserBackpack();

        userBackpack.setUserId(Integer.valueOf(MDC.get("userId")));
        userBackpack.setAccessoriesId(accId);
        userBackpack.setStatus(1);

        int insert = backpackMapper.insert(userBackpack);

        if(insert <= 0){
            Asserts.fail("服务器繁忙,请稍后再试！");
        }

        return userBackpack;
    }

    @Override
    public Boolean exchange(Integer integer) {

        User user = this.getById(Integer.valueOf(MDC.get("userId")));

        if(user.getIntegral() - integer < 0){
            Asserts.args("用户积分不足");
        }

        user.setIntegral(user.getIntegral() - integer);

        boolean save = this.updateById(user);

        if(!save){
            Asserts.fail("服务器繁忙,请稍后再试");
        }

        return true;
    }

    @Override
    public List<User> getUsersByRRId(Integer id) {
        return userMapper.getUsersByRRId(id);
    }

    @Override
    @Transactional
    public UserVo accExchangeBalance(Integer backpackId) {

        Integer accId = syncAccExchangeIntegral(backpackId);

        Accessories accessories = accessoriesService.getById(accId);

        User user = this.getById(Integer.valueOf(MDC.get("userId")));

        user.setBalance(BigDecimal.valueOf(user.getBalance().doubleValue() + accessories.getPrice().doubleValue()));

        int update = userMapper.updateById(user);

        if(update <= 0){
            Asserts.fail("服务器繁忙");
        }

        UserVo userVo = new UserVo(user);

        List<UserBackpackVo> userBackpackVos = userMapper.getUserAccs(user.getId());

        userVo.setUserBackpackVos(userBackpackVos);

        return userVo;
    }

    @Override
    public UserVo retrieveAcc(Integer backpackId) {

        this.syncRetrieveAcc(backpackId);

        User user = this.getById(Integer.valueOf(MDC.get("userId")));

        UserVo userVo = new UserVo(user);

        List<UserBackpackVo> userBackpackVos = userMapper.getUserAccs(user.getId());

        userVo.setUserBackpackVos(userBackpackVos);

        return userVo;
    }

    @Override
    public UserVo getUser() {
        return null;
    }

    @Synchronized
    private void syncRetrieveAcc(Integer backpackId){

        UserBackpack userBackpack = backpackMapper.selectById(backpackId);

        userBackpack.setStatus(2);

        int i = backpackMapper.updateById(userBackpack);

        if(!(i > 0)){
            Asserts.fail("服务器繁忙");
        }
    }

    @Synchronized
    private Integer syncAccExchangeIntegral(Integer backpackId){

        UserBackpack userBackpack = backpackMapper.selectById(backpackId);

        if(Objects.isNull(userBackpack)){
            Asserts.fail("服务器繁忙");
        }

        int i = backpackMapper.deleteById(backpackId);

        if(i <= 0){
            Asserts.fail("服务器繁忙");
        }

        return userBackpack.getAccessoriesId();
    }

}




