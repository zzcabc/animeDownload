package com.zhaocheng.animedownload.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * (TbAnimeGroup)表实体类
 *
 * @author makejava
 * @since 2023-05-25 21:49:09
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper = true)
public class TbAnimeGroup extends Model<TbAnimeGroup> {
    private Integer id;                 // 动漫分组id
    private String animeName;           // 动漫名称
    private String animeInfo;           // 动漫简介
    private String animeUrl;            // 动漫URL
    private Integer animeTotalEpisodes; // 动漫总集数
    private Integer animeEpisodes;      // 已有集数
    private Date createTime;            // 创建时间
}

