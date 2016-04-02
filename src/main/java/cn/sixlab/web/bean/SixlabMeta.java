package cn.sixlab.web.bean;

import java.util.UUID;

public class SixlabMeta {

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString());
        System.out.println(UUID.randomUUID().toString().substring(10));
        System.out.println(UUID.randomUUID().toString().substring(20));
        System.out.println(UUID.randomUUID().toString().substring(30));
        System.out.println(UUID.randomUUID().toString().substring(1));
        System.out.println(UUID.randomUUID().toString().substring(1));
        System.out.println(UUID.randomUUID().toString().substring(1));
        System.out.println(UUID.randomUUID().toString().substring(1));
    }
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