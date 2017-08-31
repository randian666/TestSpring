package com.springmvc.demo.audience;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * xml配置AOP
 * Created by liuxun on 2017/8/17.
 */
public class AudienceByXml {
    /**
     * 目标方法执行完后通知
     * @param point
     */
    public void after(JoinPoint point){
        String msg=point.getSignature().getName()+"方法执行开始";
        System.out.println(msg);
    }

    /**
     * 目标方法环绕通知
     * 方法运行时间
     * @param point
     */
    public void timeAround(ProceedingJoinPoint point){
        try {
            long startTime = System.currentTimeMillis();
            point.proceed();
            String msg=point.getSignature().getName()+"方法执行结束，耗时："+(System.currentTimeMillis()-startTime)+"ms";
            System.out.println(msg);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
