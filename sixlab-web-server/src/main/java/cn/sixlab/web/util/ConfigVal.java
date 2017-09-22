/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/9/22 23:22
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.web.util;

import cn.sixlab.web.dao.LabMetaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ConfigVal {
    private String wxAppId;
    private String wxAppSecret;
    private String wxMyOpenId;

    @Autowired
    private LabMetaDao metaDao;

    @PostConstruct
    private void init(){
        wxAppId = metaDao.queryByMetaKey("wxAppId").getMetaVal();
        wxAppSecret = metaDao.queryByMetaKey("wxAppSecret").getMetaVal();
        //token = metaDao.queryByMetaKey("wxToken").getMetaVal();
        //aesKey = metaDao.queryByMetaKey("wxAESKey").getMetaVal();
        //mpId = metaDao.queryByMetaKey("wxMpId").getMetaVal();
        wxMyOpenId = metaDao.queryByMetaKey("wxMyOpenId").getMetaVal();

    }

    public String getWxAppId() {
        return wxAppId;
    }

    public void setWxAppId(String wxAppId) {
        this.wxAppId = wxAppId;
    }

    public String getWxAppSecret() {
        return wxAppSecret;
    }

    public void setWxAppSecret(String wxAppSecret) {
        this.wxAppSecret = wxAppSecret;
    }

    public String getWxMyOpenId() {
        return wxMyOpenId;
    }

    public void setWxMyOpenId(String wxMyOpenId) {
        this.wxMyOpenId = wxMyOpenId;
    }
}
