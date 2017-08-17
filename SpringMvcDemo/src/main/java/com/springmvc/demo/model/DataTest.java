package com.springmvc.demo.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuxun on 2017/8/17.
 */
@Component
public class DataTest{
    private Map<String, String> map;
    private List<String> list;

    public DataTest() {
        map = new HashMap<String, String>();
        map.put("MapA", "This is A");
        map.put("MapB", "This is B");
        map.put("MapC", "This is C");

        list = new ArrayList<String>();
        list.add("List0");
        list.add("List1");
        list.add("List2");

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
