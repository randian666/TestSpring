package com.springmvc.demo.model;

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
