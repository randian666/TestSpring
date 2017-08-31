package com.springmvc.demo.service.impl;

/**
 * Created by liuxun on 2017/8/15.
 */
public class CircleB {
    private CircleC circleC;
    public CircleB() {
    }
    public CircleB(CircleC circleC) {
        this.circleC = circleC;
    }
    public void setCircleC(CircleC circleC)
    {
        this.circleC = circleC;
    }
    public void b() {
        System.out.println("b() running...");
        circleC.c();
    }
}
