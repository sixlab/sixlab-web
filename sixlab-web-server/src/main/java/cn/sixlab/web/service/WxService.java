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
package cn.sixlab.web.service;

import cn.sixlab.web.util.ConfigVal;
import cn.sixlab.web.util.Http;
import cn.sixlab.web.util.JsonUtl;
import cn.sixlab.web.util.Sha1Utils;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.*;

@Service
public class WxService {
    private static Logger logger = LoggerFactory.getLogger(WxService.class);
    private static String wxAccessToken;
    private static Long preTime;

    @Autowired
    private ConfigVal configVal;

    public String getToken(){
        Long now = new Date().getTime();
        if( null != preTime && (now-preTime)>=60*60*1000){
            return wxAccessToken;
        }else {
            String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + configVal.getWxAppId() + "&secret=" + configVal.getWxAppSecret();

            try {
                Response response = Http.requestGet(url);
                String result = response.body().string();
                Map map = JsonUtl.toBean(result, Map.class);
                wxAccessToken = String.valueOf(map.get("access_token"));
                preTime = now;
                return wxAccessToken;
            } catch (IOException e) {
                e.printStackTrace();
                preTime = null;
                return null;
            }
        }
    }

    public boolean checkToken(String signature, String timestamp, String nonce) {
        logger.info("验证微信签名");

        String token = "abcdefg";
        String[] tmpArr = new String[]{token, timestamp, nonce};
        tmpArr = stringSort(tmpArr);

        String tmpStr = "";
        for (int i = 0; i < tmpArr.length; i++) {
            tmpStr += tmpArr[i];
        }
        tmpStr = Sha1Utils.shaHex(tmpStr);
        logger.info("tmpStrSHA=" + tmpStr);
        logger.info("signature=" + signature);

        if (StringUtils.endsWithIgnoreCase(tmpStr, signature)) {
            return true;
        } else {
            return false;
        }
    }

    private String[] stringSort(String[] s) {
        List<String> list = new ArrayList<>(s.length);
        for (int i = 0; i < s.length; i++) {
            list.add(s[i]);
        }
        Collections.sort(list);
        return list.toArray(s);
    }
}
