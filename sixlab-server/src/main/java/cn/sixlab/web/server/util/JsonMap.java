/*
 * Copyright (c) 2016 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * http://sixlab.cn/
 */
package cn.sixlab.web.server.util;

import java.util.HashMap;

/**
 * @author 六楼的雨/Patrick Root
 */
public class JsonMap extends HashMap {
    private boolean success = true;
    private String flag;
    private String message;
    private int code;
    
    public JsonMap() {
        setSuccess(true);
        setMessage("");
        setFlag("");
        setCode(0);
    }
    
    public int getCode() {
        return code;
    }
    
    public void setCode(int code) {
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
    
    public String getFlag() {
        return flag;
    }
    
    public void setFlag(String flag) {
        put("flag", flag);
        this.flag = flag;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        put("message", message);
        this.message = message;
    }
}
