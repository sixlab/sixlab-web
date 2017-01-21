/*
 * Copyright (c) 2016 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * http://sixlab.cn/
 * 
 * @author 六楼的雨/Patrick Root
 * @since 1.0.0(2016/3/9)
 */
package cn.sixlab.web.util;

import java.util.HashMap;

/**
 * @author 六楼的雨/Patrick Root
 * @since 1.0.0(2016/3/9)
 */
public class JsonMap extends HashMap {

    private Integer code;
    private boolean success = true;
    private String message;
    private String flag;

    public JsonMap() {
        setSuccess(true);
        setMessage("");
        setFlag("");
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        put("code", code);
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        put("success", success);
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        put("message", message);
        this.message = message;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        put("flag", flag);
        this.flag = flag;
    }
}
