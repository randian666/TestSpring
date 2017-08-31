package com.springmvc.demo.service.impl;

/**
 * Created by liuxun on 2017/8/15.
 */
public class CircleC {
    private CircleA circleA;
    public CircleC() {
    }
    public CircleC(CircleA circleA) {
        this.circleA = circleA;
    }
    public void setCircleA(CircleA circleA)
    {
        this.circleA = circleA;
    }
    public void c() {
        System.out.println("c() running...");
        circleA.a();
    }
}
