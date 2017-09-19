/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/6/20
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.web.service;

import cn.sixlab.web.bean.LabUser;
import cn.sixlab.web.dao.LabUserDao;
import cn.sixlab.web.util.RespJson;
import cn.sixlab.web.util.UserCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserService {
    
    @Autowired
    private LabUserDao userDao;
    
    public List<LabUser> findAll() {
        return userDao.findAll();
    }
    
    public void login(String username, String password, RespJson model) {
        LabUser user = userDao.findByUsername(username);
        
        if (null != user) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            
            boolean correct = encoder.matches(password, user.getPassword());
            
            if (correct) {
                if (StringUtils.isEmpty(user.getToken())) {
                    String token = encoder.encode(username);
                    user.setToken(token);
                    userDao.save(user);
                }
                
                UserCache.add(user);
                model.put("user", user);
            } else {
                model.setErrorMessage("密码错误", 10003);
            }
        } else {
            model.setErrorMessage("用户不存在", 10002);
        }
    }
}
