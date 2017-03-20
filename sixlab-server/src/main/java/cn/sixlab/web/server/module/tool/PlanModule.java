/*
 * Copyright (c) 2016 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * https://sixlab.cn/
 */
package cn.sixlab.web.server.module.tool;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="https://blog.sixlab.cn/">六楼的雨/Patrick Root</a>
 */
@IocBean
@At("/tool/plan")
public class PlanModule {
    private static Logger logger = LoggerFactory.getLogger(PlanModule.class);
    
    @Inject
    protected Dao dao;

    @At(value = {"/", "/index"})
    public String index() {
        return "tool/plan/index";
    }

    @At("/week")
    public String week() {
        //service.index(model);
        return "tool/plan/week";
    }

    @At("/month")
    public String month() {
        //service.index(model);
        return "tool/plan/month";
    }

    @At("/season")
    public String season() {
        //service.edit(model);
        return "tool/plan/season";
    }

    @At("/year")
    public String year() {
        return "tool/plan/year";
    }

    @At("/years")
    public String years() {
        return "tool/plan/years";
    }

}
