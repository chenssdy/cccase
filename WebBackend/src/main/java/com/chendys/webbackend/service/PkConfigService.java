package com.chendys.webbackend.service;

import com.chendys.webbackend.pojo.PkConfig;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author chens
* @description 针对表【tb_pk_config】的数据库操作Service
* @createDate 2023-06-06 09:23:11
*/
public interface PkConfigService extends IService<PkConfig> {

    PkConfig updateConfig(PkConfig pkConfig);
}
