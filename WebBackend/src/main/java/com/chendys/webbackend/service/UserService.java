package com.chendys.webbackend.service;

import com.chendys.webbackend.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chendys.webbackend.pojo.vo.Page;
import com.chendys.webbackend.pojo.vo.UserVo;

/**
* @author chens
* @description 针对表【tb_user】的数据库操作Service
* @createDate 2023-06-14 19:23:11
*/
public interface UserService extends IService<User> {

    /**
     * 查询一页用户数据
     * @param page
     * @param num
     * @return
     */
    Page<UserVo> getPage(Integer page, Integer num);

    /**
     * 修改用户状态
     * @param userId
     * @param status
     * @return
     */
    Integer updateUserStatus(Integer userId, Integer status);
}
