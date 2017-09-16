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

import cn.sixlab.web.bean.LabUser;
import cn.sixlab.web.dao.LabUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by patrick on 2017/6/20.
 */
@Service
public class UserService {
    
    @Autowired
    private LabUserDao userDao;
    
    public List<LabUser> findAll() {
        return userDao.findAll();
    }
}
