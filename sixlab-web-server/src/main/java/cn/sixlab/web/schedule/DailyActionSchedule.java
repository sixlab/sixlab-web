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

import cn.sixlab.web.service.WxService;
import cn.sixlab.web.util.ConfigVal;
import cn.sixlab.web.util.WxMpMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DailyActionSchedule {
    @Autowired
    private WxService wxService;
    @Autowired
    private ConfigVal configVal;
    // private String appId;
    // private String appSecret;
    // private String myOpenId;
    //private String token;
    //private String aesKey;
    //private String mpId;
    // private String wxAccessToken;
    
    @Scheduled(cron = "0 0 6 * * ?")
    public void sendMsg() {
        String wxAccessToken = wxService.getToken();
        String myOpenId = configVal.getWxMyOpenId();
    
        WxMpMessage.sendCustomTextMsg(wxAccessToken,myOpenId, "消息提示");
    }
}
