package com.springmvc.demo.service.impl;

import com.springmvc.demo.service.CompactDisc;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by liuxun on 2017/8/17.
 */
public class SgtPeppers implements CompactDisc {
    private static Logger logger = Logger.getLogger(SgtPeppers.class);
    private String name;
    @Value("${disc.title}")//占位符表达式${...}
    private String title;

    public SgtPeppers(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        logger.info(name);
        logger.info(title);

    }
}
