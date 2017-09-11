package com.springmvc.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springmvc.demo.dao.UserMapper;
import com.springmvc.demo.domain.PageUtils;
import com.springmvc.demo.domain.User;
import com.springmvc.demo.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户操作
 * getUserList采用PageHelper插件实现分页
 * getUserPageList手动实现物理分页
 * Created by LiuXun on 2017/9/2.
 */
@Service
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
            logger.info("用户总记录数：" + total);
            return lists;
        } catch (Exception e) {
            logger.error("getUserList error is:",e);
        }
        return null;
    }

    @Override
    public  PageUtils<User> getUserPageList(int currentPage,int pageSize) {
        try {
            PageUtils page=new PageUtils();

            int offset=(pageSize-1)*currentPage;//起始页码
            List<User> lists=userMapper.getUserPageList(offset,pageSize);
            Integer total = userMapper.getUserPageListCount(); //获取总记录数
            logger.info("用户总记录数：" + total);
            int totalPageNum = (total  +  pageSize  - 1) / pageSize;//总页数
            page.setCurrentPage(currentPage);
            page.setNumPerPage(lists.size());
            page.setTotalCount(total);
            page.setTotalPageNum(totalPageNum);
            page.setObj(lists);
            return page;
        } catch (Exception e) {
            logger.error("getUserList error is:",e);
        }
        return null;
    }

    @Override
    public boolean insertUser(User user) {
        try {
            Integer result = userMapper.insertUser(user);
            if (result>0)
                return true;
            else
                return false;
        } catch (Exception e) {
            logger.error("insertUser error is:",e);
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        try {
            userMapper.deleteById(id);
            return true;
        } catch (Exception e) {
            logger.error("deleteById error is:",e);
        }
        return false;
    }
}
