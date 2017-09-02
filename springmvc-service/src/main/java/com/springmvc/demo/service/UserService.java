package com.springmvc.demo.service;

import com.springmvc.demo.domain.User;

import java.util.List;

/**
 * Created by LiuXun on 2017/9/2.
 */
public interface UserService {
    List<User> getUserList(int page,int pagesize);
}
