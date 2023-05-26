package com.zhaocheng.animedownload.utils;

import com.zhaocheng.animedownload.SystemEnum;
import com.zhaocheng.animedownload.entity.AnimeEntity;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author zhaocheng
 * @Description
 * @project_name animeDownload
 * @package com.zhaocheng.animedownload.utils
 * @create 2023-05-26 16:27
 */
public class SystemUtil {

    private static final BigDecimal SIZE_STANDARD_HEXADECIMAL = new BigDecimal(1024);
    private static final BigDecimal B_TO_MB_HEXADECIMAL = new BigDecimal(1024 * 1024);


    public static BigDecimal fileSizeToMB(String fileSize) {
        BigDecimal bigDecimal = new BigDecimal(fileSize);
        return bigDecimal.divide(B_TO_MB_HEXADECIMAL, RoundingMode.CEILING);
    }
    public static BigDecimal fileSizeToMB(int fileSize) {
        BigDecimal bigDecimal = new BigDecimal(fileSize);
        return bigDecimal.divide(B_TO_MB_HEXADECIMAL, RoundingMode.CEILING);
    }




    public static void animeEntityConvert(SystemEnum.RssType rssType, AnimeEntity animeEntity){
        switch (rssType){
            case MIKANANI:

        }
    }

    public static void mikananiAnimeEntityConvert(AnimeEntity animeEntity){
        AnimeEntity record = new AnimeEntity();
    }
}
