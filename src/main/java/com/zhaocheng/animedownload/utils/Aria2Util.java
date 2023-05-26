package com.zhaocheng.animedownload.utils;

import com.zhaocheng.animedownload.entity.Aria2Entity;

/**
 * @author zhaocheng
 * @Description
 * @project_name animeDownload
 * @package com.zhaocheng.animedownload.utils
 * @create 2023-05-25 18:20
 */
public class Aria2Util {

    public static void addUri(String token, String id, String uri, String fileName) throws Exception {
        Aria2Entity addUriEntity = new Aria2Entity();
        addUriEntity.setId(id);
        addUriEntity.setAddUrlParams(token, uri, fileName);
        HttpUtil.doHttpPostNoProxy("http://10.10.10.12:6800/jsonrpc", JsonUtil.objToJson(addUriEntity));
    }

    public static void main(String[] args) throws Exception {

    }
}
