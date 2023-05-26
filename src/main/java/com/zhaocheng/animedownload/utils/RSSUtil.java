package com.zhaocheng.animedownload.utils;

import com.zhaocheng.animedownload.ItemException;
import com.zhaocheng.animedownload.SystemEnum;
import com.zhaocheng.animedownload.entity.AnimeEntity;
import lombok.extern.log4j.Log4j2;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.util.ObjectUtils;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author zhaocheng
 * @Description
 * @project_name animeDownload
 * @package com.zhaocheng.animedownload.utils
 * @create 2023-05-25 21:58
 */
@Log4j2
public class RSSUtil {
    public static void main(String[] args) throws Exception {

        HttpResponse<String> stringHttpResponse = HttpUtil.doHttpGetDefaultProxy("https://mikanani.me/RSS/MyBangumi?token=dg5EeatIaYwdDPoz6xKcxTdxAMeJsKlHGz8NfpLKSdA%3d");
        if (HttpUtil.checkHttpResponseSuccess(stringHttpResponse)) {
            String body = stringHttpResponse.body();

            System.out.println(JsonUtil.objToJson(parsingRss(SystemEnum.RssType.MIKANANI, body)));
        }
    }

    /**
     * 解析RSS数据
     *
     * @param rssType RSS类型参考{@link SystemEnum.RssType}
     * @param xmlStr  RSS数据字符串
     * @return 整理好的RSS对象
     */
    public static List<AnimeEntity> parsingRss(SystemEnum.RssType rssType, String xmlStr) {
        if (ObjectUtils.isEmpty(rssType)) {

        }
        switch (rssType) {
            case MIKANANI:
                return mikananiRss(xmlStr);
            default:
                return null;
        }
    }

    /**
     * 蜜柑计划的RSS解析
     *
     * @param xmlStr RSS字符串
     * @return 解析好的AnimeEntity对象
     */
    private static List<AnimeEntity> mikananiRss(String xmlStr) {
        try {
            Document document = DocumentHelper.parseText(xmlStr);

            Element rootElement = document.getRootElement();
            // 获取channel节点
            Element channelElement = rootElement.element("channel");
            if (ObjectUtils.isEmpty(channelElement))
                throw ItemException.makeFail("无效的RSS订阅");

            // 获取item节点
            Iterator<Element> itemElementIterator = channelElement.elementIterator("item");
            if (ObjectUtils.isEmpty(itemElementIterator))
                throw ItemException.makeFail("无效的RSS订阅");
            List<AnimeEntity> list = new ArrayList<>();
            while (itemElementIterator.hasNext()) {
                Element itemElement = itemElementIterator.next();
                AnimeEntity animeEntity = new AnimeEntity();
                animeEntity.setAnimeTitle(itemElement.elementText("title"));
                animeEntity.setAnimeUrl(itemElement.elementText("link"));
                Element enclosure = itemElement.element("enclosure");
                if (!ObjectUtils.isEmpty(enclosure)) {
                    animeEntity.setAnimeDownloadUrl(enclosure.attributeValue("url"));
                    animeEntity.setAnimeFileSize(Integer.valueOf(enclosure.attributeValue("length")));
                }
                log.info("蜜柑计划RSS转换对象 animeEntity={}", JsonUtil.objToJson(animeEntity));
                list.add(animeEntity);
            }
            return list;
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        } catch (ItemException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }


}
