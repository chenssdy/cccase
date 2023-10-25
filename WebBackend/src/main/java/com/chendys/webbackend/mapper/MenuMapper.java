package com.chendys.webbackend.mapper;

import com.chendys.webbackend.pojo.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author chens
* @description 针对表【tb_menu】的数据库操作Mapper
* @createDate 2023-05-30 18:20:41
* @Entity com.chendys.webbackend.pojo.Menu
*/
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 查询管理员菜单列表
     * @param permissions
     * @return
     */
    List<Menu> selectAdminMenu(@Param("permissions") List<String> permissions);
}




