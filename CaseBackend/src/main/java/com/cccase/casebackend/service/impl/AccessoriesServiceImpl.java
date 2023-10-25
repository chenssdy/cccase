package com.cccase.casebackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cccase.casebackend.pojo.Accessories;
import com.cccase.casebackend.pojo.vo.AccessoriesVo;
import com.cccase.casebackend.service.AccessoriesService;
import com.cccase.casebackend.mapper.AccessoriesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author chens
* @description 针对表【tb_accessories】的数据库操作Service实现
* @createDate 2023-10-14 14:58:55
*/
@Service
public class AccessoriesServiceImpl extends ServiceImpl<AccessoriesMapper, Accessories>
    implements AccessoriesService{

    @Autowired
    private AccessoriesMapper accessoriesMapper;

    @Override
    public List<AccessoriesVo> getAccsByRRId(Integer id) {

        return accessoriesMapper.getAccsByRRId(id);
    }
}




