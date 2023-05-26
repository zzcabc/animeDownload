package com.zhaocheng.animedownload.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhaocheng.animedownload.entity.TbAnime;
import org.apache.ibatis.annotations.Mapper;

/**
 * (TbAnime)表数据库访问层
 *
 * @author makejava
 * @since 2023-05-25 21:50:11
 */
@Mapper
public interface TbAnimeDao extends BaseMapper<TbAnime> {

}

