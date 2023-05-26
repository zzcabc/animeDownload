package com.zhaocheng.animedownload.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhaocheng
 * @Description
 * @project_name animeDownload
 * @package com.zhaocheng.animedownload.entity
 * @create 2023-05-25 18:22
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Aria2Entity {
    private String jsonrpc = "2.0";
    private String id;
    private String method;
    private List<Object> params;

    /**
     * 调用Aria2下载创建的对象
     *
     * @param token aria2的token
     * @param url   下载地址
     */
    public void setAddUrlParams(String token, String url) {
        setAddUrlParams(token, url, null);
    }

    /**
     * 调用Aria2下载创建的对象
     *
     * @param token    aria2的token
     * @param url      下载地址
     * @param fileName 重命名的文件名称
     */
    public void setAddUrlParams(String token, String url, String fileName) {
        setAddUrlParams(token, url, fileName, null, null);
    }

    /**
     * 调用Aria2下载创建的对象
     *
     * @param token     aria2的token
     * @param url       下载地址
     * @param fileName  重命名的文件名称
     * @param seedRatio 分享率
     * @param seedTime  分享时间限制
     */
    public void setAddUrlParams(String token, String url, String fileName, String seedRatio, String seedTime) {
        this.method = "aria2.addUri";
        List<Object> list = new ArrayList<>();
        list.add("token:" + token);
        List<String> urls = new ArrayList<>();
        urls.add(url);
        list.add(urls);
        if (!ObjectUtils.isEmpty(fileName) || !ObjectUtils.isEmpty(seedRatio) || !ObjectUtils.isEmpty(seedTime)) {
            Map<String, String> map = new HashMap<>();
            if (!ObjectUtils.isEmpty(fileName))
                map.put("out", fileName);
            if (!ObjectUtils.isEmpty(seedRatio))
                map.put("seed-ratio", seedRatio);
            if (!ObjectUtils.isEmpty(seedTime))
                map.put("seed-time", seedTime);
            list.add(map);
        }
        this.params = list;
    }
}
