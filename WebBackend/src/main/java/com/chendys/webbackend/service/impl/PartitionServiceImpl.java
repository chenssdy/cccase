package com.chendys.webbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chendys.webbackend.pojo.Partition;
import com.chendys.webbackend.pojo.dto.PartitionDto;
import com.chendys.webbackend.pojo.vo.Page;
import com.chendys.webbackend.pojo.vo.PartitionVo;
import com.chendys.webbackend.service.PartitionService;
import com.chendys.webbackend.mapper.PartitionMapper;
import com.chendys.webbackend.util.exception.Asserts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
* @author chens
* @description 针对表【tb_partition】的数据库操作Service实现
* @createDate 2023-06-10 16:24:50
*/
@Service
public class PartitionServiceImpl extends ServiceImpl<PartitionMapper, Partition>
    implements PartitionService{

    private static final Logger logger = LoggerFactory.getLogger(PartitionServiceImpl.class);

    @Autowired
    private PartitionMapper partitionMapper;

    @Override
    public Page<PartitionVo> getPage(Integer page, Integer num) {

        Page<PartitionVo> pPage = new Page<>(page, num);

        List<PartitionVo> partitionVos = partitionMapper.getPage(pPage.getOffset(), num);

        if(Objects.isNull(partitionVos)){
            return null;
        }

        Integer integer = partitionMapper.selectCount(null);

        pPage.setList(partitionVos);
        pPage.setTotal(Long.valueOf(integer));
        pPage.setTotalPage(pPage.getTotalPage());

        return pPage;
    }

    @Override
    public Partition create(PartitionDto partitionDto) {

        Partition partition = new Partition();

        partition.setName(partitionDto.getName());
        partition.setSort(partitionDto.getSort());

        QueryWrapper<Partition> wrapper = new QueryWrapper<>();
        wrapper.eq("name", partition.getName());

        Partition selectOne = partitionMapper.selectOne(wrapper);

        if(!Objects.isNull(selectOne)){
           return selectOne;
        }

        int insert = partitionMapper.insert(partition);

        if(insert <= 0){
            Asserts.fail("创建失败，请联系管理员或者检查参数是否正确");
        }

        return partition;
    }

    @Override
    public Partition update(Partition partition) {

        QueryWrapper<Partition> wrapper = new QueryWrapper<>();
        wrapper.eq("name", partition.getName()).ne("id", partition.getId());
        Partition selectOne = partitionMapper.selectOne(wrapper);

        if(!Objects.isNull(selectOne)){
            Asserts.fail("分区名重复");
        }

        int i = partitionMapper.updateById(partition);

        if(i <= 0){
            Asserts.fail("修改失败");
        }

        return partition;
    }


}




