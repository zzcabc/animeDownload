package com.zhaocheng.animedownload.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhaocheng.animedownload.dao.TbAnimeDao;
import com.zhaocheng.animedownload.entity.TbAnime;
import com.zhaocheng.animedownload.service.TbAnimeService;
import org.springframework.stereotype.Service;

/**
 * (TbAnime)表服务实现类
 *
 * @author makejava
 * @since 2023-05-25 21:50:11
 */
@Service("tbAnimeService")
public class TbAnimeServiceImpl extends ServiceImpl<TbAnimeDao, TbAnime> implements TbAnimeService {

}

