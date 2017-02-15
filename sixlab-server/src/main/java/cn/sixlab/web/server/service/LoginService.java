/*
 * Copyright (c) 2016 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * http://sixlab.cn/
 */
package cn.sixlab.web.server.service;

import cn.sixlab.web.server.beans.SixlabUser;
import cn.sixlab.web.server.util.JsonMap;
import cn.sixlab.web.server.util.MD5Util;
import cn.sixlab.web.server.util.UserUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author 六楼的雨/Patrick Root
 */
@IocBean
public class LoginService {
    private static Logger logger = LoggerFactory.getLogger(LoginService.class);
    
    @Inject
    protected Dao dao;
    
    public void login(JsonMap json, String username, String password) {
        List<SixlabUser> userList = dao.query(SixlabUser.class, Cnd.where("username", "=", username));
        if(CollectionUtils.isNotEmpty(userList)){
            SixlabUser user = userList.get(0);
            String md5 = MD5Util.string2MD5(password);
            if(user.getPassword().equals(md5)){
                json.setSuccess(true);
                UserUtil.login(user);
            }else{
                json.setMessage("密码错误");
            }
        } else{
            json.setMessage("用户不存在");
        }
    }
}
