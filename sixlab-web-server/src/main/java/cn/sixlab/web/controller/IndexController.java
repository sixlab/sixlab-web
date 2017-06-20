package cn.sixlab.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by patrick on 2017/6/21.
 */
@Controller
public class IndexController {
    private static Logger logger = LoggerFactory.getLogger(ApiShowController.class);
    
    
    @RequestMapping(value = {"/", "/index", "/home"})
    public String getGirlList(ModelMap model) {
        
        return "index";
    }
}
