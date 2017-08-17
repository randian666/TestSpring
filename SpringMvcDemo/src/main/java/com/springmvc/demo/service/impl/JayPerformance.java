package com.springmvc.demo.service.impl;

import com.springmvc.demo.service.Performance;
import org.springframework.stereotype.Component;

/**
 * Created by liuxun on 2017/8/17.
 */
@Component
public class JayPerformance implements Performance{

    @Override
    public void perform() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Jay开始表演，唱歌、跳舞、嗨起来");
    }

    @Override
    public void performByName(String name) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+"开始表演，唱歌、跳舞、嗨起来");
    }

}
