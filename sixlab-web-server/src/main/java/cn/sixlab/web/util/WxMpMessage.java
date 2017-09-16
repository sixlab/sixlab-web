package cn.sixlab.web.util;

import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by patrick on 2017/6/21.
 */
public class WxMpMessage {
    private static Logger logger = LoggerFactory.getLogger(WxMpMessage.class);
    
    /**
     * 给微信用户发送客服消息-文本类型
     *
     * @param accessToken token
     * @param openId 用户 OpenId
     * @param message 文本消息
     */
    public static void sendCustomTextMsg(String accessToken, String openId, String message){
        logger.info("发送微信消息to："+openId);
        
        Map<String, Object> msgMap = new HashMap<>();
        msgMap.put("touser",openId);
        msgMap.put("msgtype","text");
        
        Map<String, String> content = new HashMap<>();
        content.put("content", message);
        msgMap.put("text", content);
        
        String msgJson = JsonUtl.toJSon(msgMap);
    
        String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + accessToken;
        try {
            Response response = Http.requestPost(url, msgJson);
            System.out.println("微信推送信息返回code：" + response.code());
            System.out.println("微信推送信息返回resp：" + response.body().string());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
