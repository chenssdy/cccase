package com.cccase.casebackend.service;

import com.cccase.casebackend.pojo.Accessories;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cccase.casebackend.pojo.vo.AccessoriesVo;

import java.util.List;

/**
* @author chens
* @description 针对表【tb_accessories】的数据库操作Service
* @createDate 2023-10-14 14:58:55
*/
public interface AccessoriesService extends IService<Accessories> {

    List<AccessoriesVo> getAccsByRRId(Integer id);
}
