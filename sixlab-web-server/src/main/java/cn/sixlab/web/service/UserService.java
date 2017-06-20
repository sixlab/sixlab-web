package cn.sixlab.web.service;

import cn.sixlab.web.bean.SixlabUser;
import cn.sixlab.web.dao.SixlabUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by patrick on 2017/6/20.
 */
@Service
public class UserService {
    
    @Autowired
    private SixlabUserDao userDao;
    
    public List<SixlabUser> findAll() {
        return userDao.findAll();
    }
}
