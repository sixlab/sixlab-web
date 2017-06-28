/*
 * Copyright (c) 2017 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * https://sixlab.cn/
 */
package cn.sixlab.web.auth;

import cn.sixlab.web.bean.SixlabUser;
import cn.sixlab.web.dao.SixlabUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by patrick on 2017/6/20.
 */
@Component
public class SixlabUserDetailsService implements UserDetailsService{
    
    @Autowired
    private SixlabUserDao sixlabUserDao;
    
    @Override
    public UserDetails loadUserByUsername(String username) {
        if (StringUtils.isEmpty(username)) {
            throw new UsernameNotFoundException("用户名为空");
        }
    
        SixlabUser user = sixlabUserDao.findByUsername(username);
        if (null == user) {
            throw new UsernameNotFoundException("用户不存在");
        }
        
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("user"));
        
        return new User(
                username, user.getPassword(),
                true,//账户可用为true
                true,//账户未过期为true
                true,//证书不过期为true
                true,//账户未锁定为true
                authorities);
    }
}
