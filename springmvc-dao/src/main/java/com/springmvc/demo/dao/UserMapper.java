package com.springmvc.demo.dao;

import com.springmvc.demo.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by LiuXun on 2017/9/2.
 */
public interface UserMapper {
    List<User> getUserList();
    List<User> getUserPageList(@Param("offset") int offset,@Param("rows") int rows);
    Integer getUserPageListCount();
}
