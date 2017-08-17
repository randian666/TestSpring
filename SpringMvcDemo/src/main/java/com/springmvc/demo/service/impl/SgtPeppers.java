package com.springmvc.demo.service.impl;

import com.springmvc.demo.service.CompactDisc;

/**
 * Created by liuxun on 2017/8/17.
 */
public class SgtPeppers implements CompactDisc {
    @Override
    public void play() {
        System.out.println("这个一个光盘");
    }
}
