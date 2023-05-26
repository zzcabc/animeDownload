package com.zhaocheng.animedownload;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zhaocheng
 * @Description
 * @project_name animeDownload
 * @package com.zhaocheng.animedownload
 * @create 2023-05-26 16:09
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ItemException extends RuntimeException {
    private Integer errCode;
    private String errDesc;

    public ItemException() {
        super("操作失败");
    }

    public ItemException(int result) {
        this(result, "操作失败", null);
    }

    public ItemException(int result, String message, String errDesc) {
        super(message);
        this.errCode = result;
        this.errDesc = errDesc;
    }

    public static ItemException makeFail() {
        return new ItemException();
    }

    public static ItemException makeFail(String errDesc) {
        return makeFail(errDesc, errDesc);
    }

    public static ItemException makeFail(int errCode, String errDesc) {
        return makeFail(errCode, errDesc, errDesc);
    }

    public static ItemException makeFail(String message, String errDesc) {
        return makeFail(SystemEnum.ERROR_CODE, message, errDesc);
    }

    public static ItemException makeFail(int errCode, String message, String errDesc) {
        return new ItemException(errCode, message, errDesc);
    }

}
