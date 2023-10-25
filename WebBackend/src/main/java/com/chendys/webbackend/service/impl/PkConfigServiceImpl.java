package com.chendys.webbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chendys.webbackend.pojo.PkConfig;
import com.chendys.webbackend.service.PkConfigService;
import com.chendys.webbackend.mapper.PkConfigMapper;
import com.chendys.webbackend.util.exception.Asserts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author chens
* @description 针对表【tb_pk_config】的数据库操作Service实现
* @createDate 2023-06-06 09:23:11
*/
@Service
public class PkConfigServiceImpl extends ServiceImpl<PkConfigMapper, PkConfig>
    implements PkConfigService{

    @Autowired
    private PkConfigMapper pkConfigMapper;

    @Override
    public PkConfig updateConfig(PkConfig pkConfig) {

        int i = pkConfigMapper.updateById(pkConfig);

        if(i <= 0){
            Asserts.fail("修改失败, 请联系管理员或检查参数是否正确");
        }

        return pkConfig;
    }
}




