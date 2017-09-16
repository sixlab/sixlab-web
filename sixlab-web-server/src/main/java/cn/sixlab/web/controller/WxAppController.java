/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/6/21
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.web.controller;

import cn.sixlab.web.service.WxService;
import cn.sixlab.web.util.WxUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/wx/app")
public class WxAppController {
    private static Logger logger = LoggerFactory.getLogger(WxAppController.class);
    
    @Autowired
    private WxService wxService;
    
    @RequestMapping("/push")
    public String push(String signature, String timestamp, String nonce, String echostr, HttpServletRequest request)
            throws IOException {
        logger.info("微信来消息了。。。");
        
        // 验签失败返回
        if(!wxService.checkToken(signature, timestamp, nonce)){
            logger.info("验签失败");
            return "fail";
        }
        
        // 如果echostr
        if(!StringUtils.isEmpty(echostr)){
            return echostr;
        }
    
        InputStream inputStream = request.getInputStream();
        Map<String, String> map = WxUtil.request2Map(inputStream);
        
        String msg = "success";
        if(!StringUtils.isEmpty(map.get("FromUserName"))){
            msg = "<xml>" +
                    "<ToUserName><![CDATA["+ map.get("FromUserName")+"]]></ToUserName>" +
                    "<FromUserName><![CDATA[sixlab]]></FromUserName>" +
                    "<CreateTime>"+String.valueOf(new Date().getTime() / 1000)+"</CreateTime>" +
                    "<MsgType><![CDATA[text]]></MsgType>" +
                    "<Content><![CDATA[ 消息已收到 ]]></Content>" +
                    "</xml>";
        }
        
        return msg;
    }
}
