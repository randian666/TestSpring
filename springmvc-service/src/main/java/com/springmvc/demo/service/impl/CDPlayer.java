package com.springmvc.demo.service.impl;


import com.springmvc.demo.service.CompactDisc;

/**
 * CD播放器
 * Created by liuxun on 2017/8/17.
 */
public class CDPlayer {
    private CompactDisc compactDisc;

    public CDPlayer(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    /**
     * 播放光盘
     */
    public void doPlay(){
        compactDisc.play();
    }
}
