package com.zhaocheng.animedownload.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhaocheng.animedownload.dao.TbConfigDao;
import com.zhaocheng.animedownload.entity.TbConfig;
import com.zhaocheng.animedownload.service.TbConfigService;
import org.springframework.stereotype.Service;

/**
 * (TbConfig)表服务实现类
 *
 * @author makejava
 * @since 2023-05-25 21:40:23
 */
@Service("tbConfigService")
public class TbConfigServiceImpl extends ServiceImpl<TbConfigDao, TbConfig> implements TbConfigService {

}

