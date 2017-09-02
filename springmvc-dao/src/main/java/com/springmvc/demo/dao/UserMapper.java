package com.springmvc.demo.dao;

import com.springmvc.demo.domain.User;

import java.util.List;

/**
 * Created by LiuXun on 2017/9/2.
 */
public interface UserMapper {
    List<User> getUserList();
}
