/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.web.util;

import java.util.HashMap;

public class RespJson extends HashMap {
    private boolean success = true;
    private String flag;
    private String message;
    private int code;
    
    public RespJson() {
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
    
    public void setErrorMessage(String message) {
        setSuccess(false);
        setMessage(message);
    }
    
    public void setErrorMessage(String message, int code) {
        setSuccess(false);
        setMessage(message);
        setCode(code);
    }
}
