/*
 * Copyright (c) 2016 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * http://sixlab.cn/
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
 * @author 六楼的雨/Patrick Root
 */
@SetupBy(value = MainSetup.class)
@IocBy(type = ComboIocProvider.class, args = {"*js", "./",
        "*anno", "cn.sixlab.web.server.module", "cn.sixlab.web.server.service", "*tx"})
@Modules(scanPackage = true)
@Ok("json:full")
@Fail("jsp:jsp.500")
@Filters({@By(type=MainFilter.class)})
//@Views(value = {FreemarkerViewMaker.class})
public class MainModule {
    
}
