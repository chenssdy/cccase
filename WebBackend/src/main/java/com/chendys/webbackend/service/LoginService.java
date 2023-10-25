package com.chendys.webbackend.service;

import com.chendys.webbackend.pojo.Admin;
import com.chendys.webbackend.pojo.Menu;
import com.chendys.webbackend.pojo.vo.AdminVo;

import java.util.List;

/**
 * @author chens
 * @description 后台登录接口
 * @createDate 2023-05-30 16:45:52
 */
public interface LoginService {

    /**
     * 后台系统登录方法
     * @param admin 管理员类
     * @return 返回管理员信息
     */
    AdminVo login(Admin admin);

    /**
     * 退出登录
     * @return
     */
    AdminVo logout();

    /**
     * 获取管理员可见菜单
     * @return
     */
    List<Menu> getMenu();

    /**
     * 获取管理员权限列表
     * @return
     */
    List<String> getPermission();
}
