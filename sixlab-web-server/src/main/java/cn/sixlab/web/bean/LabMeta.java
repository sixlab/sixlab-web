/*
 * Copyright (c) 2016 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * https://sixlab.cn/
 */
package cn.sixlab.web.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author <a href="https://blog.sixlab.cn/">六楼的雨/Patrick Root</a>
 */
@Entity
public class LabMeta implements Serializable{
    
    @Id
    @GeneratedValue
    private Integer id;
    private Integer keyId;
    private String metaKey;
    private String metaVal;
    private String metaFlag;
    private String metaRemark;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getKeyId() {
        return keyId;
    }
    
    public void setKeyId(Integer keyId) {
        this.keyId = keyId;
    }
    
    public String getMetaKey() {
        return metaKey;
    }
    
    public void setMetaKey(String metaKey) {
        this.metaKey = metaKey;
    }
    
    public String getMetaVal() {
        return metaVal;
    }
    
    public void setMetaVal(String metaVal) {
        this.metaVal = metaVal;
    }
    
    public String getMetaFlag() {
        return metaFlag;
    }
    
    public void setMetaFlag(String metaFlag) {
        this.metaFlag = metaFlag;
    }
    
    public String getMetaRemark() {
        return metaRemark;
    }
    
    public void setMetaRemark(String metaRemark) {
        this.metaRemark = metaRemark;
    }
}