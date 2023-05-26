package com.zhaocheng.animedownload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication(exclude = {JdbcTemplateAutoConfiguration.class})
public class AnimeDownloadApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnimeDownloadApplication.class, args);
    }

}
