package com.zhaocheng.animedownload.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * (TbAnime)表实体类
 *
 * @author makejava
 * @since 2023-05-25 21:50:11
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper = true)
public class TbAnime extends Model<TbAnime> {
    private String id;              // 动漫id 作为Aria2 下载id
    private Integer animeGroupId;   // 动漫分组
    private String animeTitle;      // 动漫名称
    private String animeBtUrl;      // 动漫BT链接
    private Integer episodes;       // 当前集数
    private Double fileSize;        // 文件大小
    private Integer fileStatus;     // 文件状态
    private Date createTime;        // 创建时间
}

