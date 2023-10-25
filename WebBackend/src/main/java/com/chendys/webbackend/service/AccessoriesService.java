package com.chendys.webbackend.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chendys.webbackend.pojo.Accessories;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author chens
* @description 针对表【tb_accessories】的数据库操作Service
* @createDate 2023-05-31 11:15:10
*/
public interface AccessoriesService extends IService<Accessories> {

    /**
     * 获取一页饰品数据
     * @param page
     * @param num
     * @return
     */
    IPage<Accessories> getPage(Integer page, Integer num);

    /**
     * 修改饰品
     * @param accessories 饰品信息
     * @return
     */
    Accessories updateAccessoriesById(Accessories accessories);

    /**
     * 添加饰品
     * @param accessories 饰品信息
     * @return
     */
    Accessories createAccessories(Accessories accessories);

    /**
     * 删除饰品
     * @param id 饰品id
     * @return
     */
    String deleteById(Integer id);

    /**
     * 批量删除饰品
     * @param ids 饰品id
     * @return
     */
    String deleteByIds(List<Integer> ids);
}
