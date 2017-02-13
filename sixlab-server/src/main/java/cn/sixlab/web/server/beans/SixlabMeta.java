/*
 * Copyright (c) 2016 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * http://sixlab.cn/
 */
package cn.sixlab.web.server.beans;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Table("sixlab_meta")

/**
 * @author 六楼的雨/Patrick Root
 */
public class SixlabMeta {

    @Id
    private int id;
    @Column("key_id")
    private int keyId;
    @Column("meta_key")
    private String metaKey;
    @Column("meta_val")
    private String metaVal;
    @Column("meta_flag")
    private String metaFlag;
    @Column("meta_remark")
    private String metaRemark;

    public int getId () {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKeyId () {
        return keyId;
    }

    public void setKeyId(int keyId) {
        this.keyId = keyId;
    }

    public String getMetaKey () {
        return metaKey;
    }

    public void setMetaKey(String metaKey) {
        this.metaKey = metaKey;
    }

    public String getMetaVal () {
        return metaVal;
    }

    public void setMetaVal(String metaVal) {
        this.metaVal = metaVal;
    }

    public String getMetaFlag () {
        return metaFlag;
    }

    public void setMetaFlag(String metaFlag) {
        this.metaFlag = metaFlag;
    }

    public String getMetaRemark () {
        return metaRemark;
    }

    public void setMetaRemark(String metaRemark) {
        this.metaRemark = metaRemark;
    }

}