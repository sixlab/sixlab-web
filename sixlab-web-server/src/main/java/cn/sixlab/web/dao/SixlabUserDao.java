package cn.sixlab.web.dao;

import cn.sixlab.web.bean.SixlabUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by patrick on 2017/6/20.
 */
public interface SixlabUserDao extends JpaRepository<SixlabUser, Integer> {
    
    //@Query("select u from SixlabUser u where u.username = ?1 ")
    SixlabUser findByUsername(String username);
}
