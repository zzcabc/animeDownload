package com.zhaocheng.animedownload.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhaocheng.animedownload.entity.TbConfig;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @author zhaocheng
 * @Description
 * @project_name animeDownload
 * @package com.zhaocheng.animedownload.service
 * @create 2023-05-25 18:16
 */

@Log4j2
@Service
public class Aria2Service {
    @Autowired
    private TbConfigService tbConfigService;
    private String aria2Url = null;
    private String aria2Token = null;

    private String getAria2Url() {
        QueryWrapper<TbConfig> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("key", "aria2-url");
        TbConfig one = tbConfigService.getOne(queryWrapper);
        log.info("获取Aria2 Url:{}", one.getValue());
        return one.getValue();
    }

    private String getAria2Token() {
        QueryWrapper<TbConfig> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("key", "aria2-token");
        TbConfig one = tbConfigService.getOne(queryWrapper);
        log.info("获取Aria2 Token:{}", one.getValue());
        return one.getValue();
    }


}
