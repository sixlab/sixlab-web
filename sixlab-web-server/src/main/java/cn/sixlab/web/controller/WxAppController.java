package cn.sixlab.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by patrick on 2017/6/21.
 */
@RestController
@RequestMapping("/wx/app")
public class WxAppController {
    private static Logger logger = LoggerFactory.getLogger(WxAppController.class);
    
    @RequestMapping("/push")
    public String push(String echostr) {
        
        return echostr;
    }
}
