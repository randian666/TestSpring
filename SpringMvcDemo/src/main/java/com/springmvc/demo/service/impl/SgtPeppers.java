package com.springmvc.demo.service.impl;

import com.springmvc.demo.service.CompactDisc;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by liuxun on 2017/8/17.
 */
public class SgtPeppers implements CompactDisc {
    private String name;
    @Value("${disc.title}")//占位符表达式${...}
    private String title;

    public SgtPeppers(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println(name);
        System.out.println(title);

    }
}
