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
package cn.sixlab.web.schedule;

import cn.sixlab.web.dao.LabMetaDao;
import cn.sixlab.web.util.Http;
import cn.sixlab.web.util.JsonUtl;
import cn.sixlab.web.util.WxMpMessage;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class DailyActionSchedule {
    @Autowired
    private LabMetaDao metaDao;
    private String appId;
    private String appSecret;
    private String myOpenId;
    //private String token;
    //private String aesKey;
    //private String mpId;
    
    private String wxAccessToken;
    
    @Scheduled(cron = "0 0 6 * * ?")
    public void sendMsg() {
        if(null == appId){
            appId = metaDao.queryByMetaKey("wxAppId").getMetaVal();
            appSecret = metaDao.queryByMetaKey("wxAppSecret").getMetaVal();
            //token = metaDao.queryByMetaKey("wxToken").getMetaVal();
            //aesKey = metaDao.queryByMetaKey("wxAESKey").getMetaVal();
            //mpId = metaDao.queryByMetaKey("wxMpId").getMetaVal();
            myOpenId = metaDao.queryByMetaKey("wxMyOpenId").getMetaVal();
        }
        getToken();
        
        String wxDailyMsg = metaDao.queryByMetaKey("wxDailyMsg").getMetaVal();
    
        WxMpMessage.sendCustomTextMsg(wxAccessToken,myOpenId, wxDailyMsg);
    }
    
    private void getToken(){
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appId + "&secret=" + appSecret;
    
        try {
            Response response = Http.requestGet(url);
            String result = response.body().string();
            Map map = JsonUtl.toBean(result, Map.class);
            wxAccessToken = String.valueOf(map.get("access_token"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
