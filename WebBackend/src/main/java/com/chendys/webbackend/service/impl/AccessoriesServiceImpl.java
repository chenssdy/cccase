package com.chendys.webbackend.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chendys.webbackend.pojo.Accessories;
import com.chendys.webbackend.service.AccessoriesService;
import com.chendys.webbackend.mapper.AccessoriesMapper;
import com.chendys.webbackend.util.exception.Asserts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author chens
* @description 针对表【tb_accessories】的数据库操作Service实现
* @createDate 2023-05-31 11:15:10
*/
@Service
public class AccessoriesServiceImpl extends ServiceImpl<AccessoriesMapper, Accessories>
    implements AccessoriesService{


    private final Logger logger = LoggerFactory.getLogger(AccessoriesServiceImpl.class);

    @Autowired
    private AccessoriesMapper accessoriesMapper;

    @Override
    public IPage<Accessories> getPage(Integer page, Integer num) {

        // 创建mybatis-plus分页对象并赋予页码与每页数据量
        logger.info("创建分页对象");
        Page<Accessories> pageDate = new Page<>(page, num);

        logger.info("查询数据库");
        IPage<Accessories> accessoriesIPage = accessoriesMapper.selectPage(pageDate, null);

        logger.info("返回数据");
        return accessoriesIPage;
    }

    @Override
    public Accessories updateAccessoriesById(Accessories accessories) {

        int i = accessoriesMapper.updateById(accessories);

        if(i <= 0){
            Asserts.fail("修改失败，请联系管理员或检查参数是否正确");
        }

        return accessories;
    }

    @Override
    public Accessories createAccessories(Accessories accessories) {

        int insert = accessoriesMapper.insert(accessories);

        if(insert <= 0){
            Asserts.fail("添加失败，请联系管理员或检查参数是否正确");
        }

        return accessories;
    }

    @Override
    public String deleteById(Integer id) {

        int i = accessoriesMapper.deleteById(id);

        if(i <= 0){
            Asserts.fail("删除失败，请联系管理员");
        }

        return "删除成功";
    }

    @Transactional
    @Override
    public String deleteByIds(List<Integer> ids) {

        int i = accessoriesMapper.deleteBatchIds(ids);

        if(i <= 0){
            Asserts.fail("删除失败，请联系管理员");
        }

        return "删除成功";
    }
}




