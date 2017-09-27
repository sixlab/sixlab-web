package cn.sixlab.web.controller.wx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wx/admin")
public class WxAdminController {
    private static Logger logger = LoggerFactory.getLogger(WxAdminController.class);
    
    @RequestMapping("/menu")
    public String menu() {
        
        return "wx/admin/menu";
    }
    
    @RequestMapping("/pub/menu")
    public String pub1() {
        
        return "wx/admin/menu";
    }
    
    @RequestMapping("/menu/pub")
    public String pub12() {
        
        return "wx/admin/menu";
    }
    
    @RequestMapping("/menu/pub/menu")
    public String pub132() {
        
        return "wx/admin/menu";
    }
}
