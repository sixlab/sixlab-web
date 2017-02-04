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

import cn.sixlab.web.server.filter.MainFilter;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

/**
<<<<<<< HEAD
 * @author <a href="https://blog.sixlab.cn/">六楼的雨/Patrick Root</a>
=======
 * @author 六楼的雨/Patrick Root
 * @since 1.0.0
>>>>>>> 初始化网站后台项目 sixlab-server
 */
@SetupBy(value = MainSetup.class)
@IocBy(type = ComboIocProvider.class, args = {"*js", "./",
        "*anno", "cn.sixlab.web.server.module", "cn.sixlab.web.server.service", "*tx"})
@Modules(scanPackage = true)
@Ok("json:full")
@Fail("jsp:jsp.500")
@Filters({@By(type=MainFilter.class)})
<<<<<<< HEAD
//@Views(value = {FreemarkerViewMaker.class})
=======
>>>>>>> 初始化网站后台项目 sixlab-server
public class MainModule {
    
}
