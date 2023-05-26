package com.zhaocheng.animedownload.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author zhaocheng
 * @Description
 * @project_name animeDownload
 * @package com.zhaocheng.animedownload.service
 * @create 2023-05-25 22:20
 */
@Component
public class SchedulingTask {
    @Scheduled(cron = "0/5 * * * * ?")
    public void scheduledTask() {
    }
}
