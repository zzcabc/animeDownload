package com.zhaocheng.animedownload;

/**
 * @author zhaocheng
 * @Description
 * @project_name animeDownload
 * @package com.zhaocheng.animedownload
 * @create 2023-05-26 15:48
 */
public class SystemEnum {
    public static final int ERROR_CODE = 0;
    public static final int SUCCESS_CODE = 1;

    public enum RssType {
        MIKANANI(1, "蜜柑计划");
        private int value;
        private String name;

        RssType(int value, String name) {
            this.value = value;
            this.name = name;
        }

        public static RssType from(Integer value) {
            if (value == null) {
                return null;
            }
            for (RssType rssType : RssType.values()) {
                if (rssType.value == value) {
                    return rssType;
                }
            }
            return null;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
