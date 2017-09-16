/*
 * Copyright (c) 2017 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * https://sixlab.cn/
 */
package cn.sixlab.web.service;

import cn.sixlab.web.util.Sha1Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class WxService {
    private static Logger logger = LoggerFactory.getLogger(WxService.class);
    
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
