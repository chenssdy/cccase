package com.chendys.webbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chendys.webbackend.pojo.Menu;
import com.chendys.webbackend.service.MenuService;
import com.chendys.webbackend.mapper.MenuMapper;
import org.springframework.stereotype.Service;

/**
* @author chens
* @description 针对表【tb_menu】的数据库操作Service实现
* @createDate 2023-05-30 18:20:41
*/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu>
    implements MenuService{

}




