/*
<<<<<<< HEAD
 * Copyright (c) 2016 Sixlab. All rights reserved.
=======
 * Copyright (c) 1995 Sixlab. All rights reserved.
>>>>>>> 初始化网站后台项目 sixlab-server
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
<<<<<<< HEAD
 * https://sixlab.cn/
=======
 * http://sixlab.cn/
>>>>>>> 初始化网站后台项目 sixlab-server
 */
package cn.sixlab.web.server;

import org.nutz.dao.Dao;
import org.nutz.dao.util.Daos;
import org.nutz.ioc.Ioc;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;

/**
<<<<<<< HEAD
 * @author <a href="https://blog.sixlab.cn/">六楼的雨/Patrick Root</a>
=======
 * @author 六楼的雨/Patrick Root
 * @since 1.0.0
>>>>>>> 初始化网站后台项目 sixlab-server
 */
public class MainSetup implements Setup {
    
    @Override
    public void init(NutConfig nutConfig) {
        Ioc ioc = nutConfig.getIoc();
        Dao dao = ioc.get(Dao.class);
        Daos.createTablesInPackage(dao, "cn.sixlab.web.server.beans", false);
    }
    
    @Override
    public void destroy(NutConfig nutConfig) {
        
    }
    
}