package com.zhaocheng.animedownload.entity;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author zhaocheng
 * @Description
 * @project_name animeDownload
 * @package com.zhaocheng.animedownload.entity
 * @create 2023-05-26 15:42
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
public class AnimeEntity {
    private String animeName;           // 动漫名称
    private String animeSubtitlesGroup; // 字幕组
    private String animeTitle;          // 动漫标题
    private String animeDownloadUrl;    // BT链接
    private String animeInfo;           // 动漫简介
    private String animeUrl;            // 动漫URL地址
    private String animeEpisodes;       // 当前集数
    private Integer animeFileSize;      // 文件大小
}
