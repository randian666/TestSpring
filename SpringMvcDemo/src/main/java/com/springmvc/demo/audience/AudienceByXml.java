package com.springmvc.demo.audience;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * xml配置AOP
 * Created by liuxun on 2017/8/17.
 */
public class AudienceByXml {
    public void after(JoinPoint point){
        System.out.println(point.getSignature().getName()+"方法执行开始");
    }
    public void timeAround(ProceedingJoinPoint point){
        try {
            long startTime = System.currentTimeMillis();
            point.proceed();
            System.out.println(point.getSignature().getName()+"方法执行结束，耗时："+(System.currentTimeMillis()-startTime)+"ms");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
