package com.springmvc.demo.service.impl;

import com.springmvc.demo.dao.UserMapper;
import com.springmvc.demo.domain.User;
import com.springmvc.demo.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LiuXun on 2017/9/2.
 */
@Service("c")
public class UserServiceImpl implements UserService {
    private static Logger logger = Logger.getLogger(UserServiceImpl.class);
    @Resource
    private UserMapper userMapper;
    @Override
    public List<User> getUserList() {
        try {
            List<User> lists = userMapper.getUserList();
            return lists;
        } catch (Exception e) {
            logger.error("getUserList error is:",e);
        }
        return null;
    }
}
