package com.zhaocheng.animedownload.utils;

import com.alibaba.fastjson2.JSON;
import org.springframework.util.ObjectUtils;

/**
 * @author zhaocheng
 * @Description
 * @project_name animeDownload
 * @package com.zhaocheng.animedownload.utils
 * @create 2023-05-25 17:56
 */
public class JsonUtil {

    /**
     * 将obj对象转为json字符串
     *
     * @param obj 任意对象
     * @return json字符串
     */
    public static String objToJson(Object obj) {
        if (ObjectUtils.isEmpty(obj)) return null;
        return JSON.toJSONString(obj);
    }

    public static void jsonToObj(String jsonStr) {

    }
}
