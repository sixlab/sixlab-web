/*
 * Copyright (c) 2016 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * https://sixlab.cn/
 */
package cn.sixlab.web.server.module;

import cn.sixlab.web.server.beans.SixlabMeta;
import cn.sixlab.web.server.service.IndexService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
<<<<<<< HEAD
 * @author <a href="https://blog.sixlab.cn/">六楼的雨/Patrick Root</a>
=======
 * @author 六楼的雨/Patrick Root
 * @since 1.0.0
>>>>>>> 初始化网站后台项目 sixlab-server
 */
@IocBean
@At("/index")
public class IndexModule {
    private static Logger logger = LoggerFactory.getLogger(IndexModule.class);

    @Inject
    protected IndexService indexService;

    @Inject
    protected Dao dao;

    @At
    public int count() {
        return dao.count(SixlabMeta.class);
    }
}
