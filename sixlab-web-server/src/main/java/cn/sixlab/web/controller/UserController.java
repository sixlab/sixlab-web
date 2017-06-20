package cn.sixlab.web.controller;

import cn.sixlab.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by patrick on 2017/6/20.
 */
@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getGirlList(ModelMap model) {
        model.put("users", userService.findAll());
        return "users";
    }
}
