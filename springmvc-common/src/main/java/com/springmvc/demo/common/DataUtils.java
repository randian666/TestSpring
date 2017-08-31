package com.springmvc.demo.common;

import com.springmvc.demo.domain.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 初始化数据
 * Created by liuxun on 2017/8/17.
 */
@Component
@Qualifier("dataUtils")
public class DataUtils {
    private Map<String, String> map;
    private List<String> list;
    private List<User> users;
    public DataUtils() {
        map = new HashMap<String, String>();
        map.put("MapA", "This is A");
        map.put("MapB", "This is B");
        map.put("MapC", "This is C");

        list = new ArrayList<String>();
        list.add("List0");
        list.add("List1");
        list.add("List2");

        users= Arrays.asList(new User("张三",12,1,"中国"),new User("李白",23,0,"中国"),new User("蜘蛛侠",45,1,"美国"));
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
