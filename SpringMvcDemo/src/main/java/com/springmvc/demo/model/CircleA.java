package com.springmvc.demo.model;

/**
 * Created by liuxun on 2017/8/15.
 */
public class CircleA {
    private CircleB circleB;
    public CircleA(){

    }
    public CircleA(CircleB circleB) {
        this.circleB = circleB;
    }
    public void setCircleB(CircleB circleB) {
        this.circleB = circleB;
    }
    public void a(){
        System.out.println("a() running...");
        circleB.b();
    }
}
