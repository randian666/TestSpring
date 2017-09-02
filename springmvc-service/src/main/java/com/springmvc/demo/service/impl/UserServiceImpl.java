package com.springmvc.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public List<User> getUserList(int page,int pagesize) {
        try {
            PageHelper.startPage(page, pagesize); // 核心分页代码
            List<User> lists = userMapper.getUserList();
            // 取分页信息
            PageInfo<User> pageInfo = new PageInfo<User>(lists);
            long total = pageInfo.getTotal(); //获取总记录数
            System.out.println("用户总记录数：" + total);
            return lists;
        } catch (Exception e) {
            logger.error("getUserList error is:",e);
        }
        return null;
    }
}
