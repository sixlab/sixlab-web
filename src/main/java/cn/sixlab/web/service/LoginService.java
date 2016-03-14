/*
 * Copyright (c) 2016 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * http://sixlab.cn/
 * 
 * @author 六楼的雨/loki
 * @since 1.0.0(2016/3/9)
 */
package cn.sixlab.web.service;

import cn.sixlab.web.bean.SixlabMeta;
import cn.sixlab.web.mapper.SixlabMetaMapper;
import cn.sixlab.web.util.JsonMap;
import cn.sixlab.web.util.UserUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 六楼的雨/loki
 * @since 1.0.0(2016/3/9)
 */
@Service
public class LoginService {
    private static Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    private SixlabMetaMapper metaMapper;

    public void login(JsonMap jsonMap, String username, String password) {
        SixlabMeta record = new SixlabMeta();
        record.setMetaKey("username");
        record.setMetaVal(username);
        record.setMetaFlag(password);

        List<SixlabMeta> metaList = metaMapper.selectByEq(record);
        if(CollectionUtils.isEmpty(metaList)){
            jsonMap.setSuccess("0");
        }else{
            UserUtil.setLogin(username);
        }
    }
}
