/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 * <p>
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 * <p>
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017/09/19 14:37
 * @author: Patrick <root@sixlab.cn>
 */
package cn.sixlab.web.util;

import cn.sixlab.web.bean.LabUser;

import java.util.HashMap;
import java.util.Map;

public class UserCache {
    private static Map<String, LabUser> users = new HashMap<>();
    
    public static LabUser remove(String token) {
        return users.remove(token);
    }
    
    public static LabUser add(LabUser user) {
        return users.put(user.getToken(), user);
    }
    
    public static LabUser get(String token) {
        return users.get(token);
    }
}
