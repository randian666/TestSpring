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

    @Override
    public  PageUtils<User> getUserPageList(int currentPage,int pageSize) {
        try {
            PageUtils page=new PageUtils();

            int offset=(pageSize-1)*currentPage;//起始页码
            List<User> lists=userMapper.getUserPageList(offset,pageSize);
            Integer total = userMapper.getUserPageListCount(); //获取总记录数
            System.out.println("用户总记录数：" + total);
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

}
