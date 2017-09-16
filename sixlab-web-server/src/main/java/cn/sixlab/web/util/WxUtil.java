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
package cn.sixlab.web.util;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class WxUtil {
    private static Logger logger = LoggerFactory.getLogger(WxUtil.class);
    
    public static Map<String, String> request2Map(InputStream is) {
        String result = null;
        try {
            result = InputStreamUtil.readString(is);
            logger.info("微信推送消息："+result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parseXMl2Param(result);
    }
    
    private static Map<String, String> parseXMl2Param(String xml) {
        Map<String, String> map = new HashMap<>();
        try {
            Document parseDoc = DocumentHelper.parseText(xml);
            Element root = parseDoc.getRootElement();
            
            for (Iterator it = root.elementIterator(); it.hasNext(); ) {
                Element el = (Element) it.next();
                map.put(el.getName(), el.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
