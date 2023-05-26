package com.zhaocheng.animedownload.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (TbConfig)表实体类
 *
 * @author makejava
 * @since 2023-05-25 21:40:23
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper = true)
public class TbConfig extends Model<TbConfig> {
    private Integer id;
    private String key;
    private String value;
}

