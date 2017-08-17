package com.springmvc.demo.audience;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 定义切面
 * Created by liuxun on 2017/8/17.
 */
@Aspect
public class Audience {
    @Pointcut("execution(** com.springmvc.demo.service.Performance.perform(..))") //定义切入点
    public void performance(){}

    @Before("performance()")
    public void booking(){
        System.out.println("表演之前，观众订票。。。");
    }
    @Before("performance()")
    public void enterTheSite(){
        System.out.println("表演之前，观众进入场地。。。");
    }
    /**
     * 定义环绕通知
     * ProceedingJoinPoint这个对象必须要有的，因为你要在通知中通过它来调用被通知的方法。
     * 通知方法中可以做任何事情，当腰将控制权交给被通知的方法时，它需要调用proceed()方法。
     * @param joinPoint
     */
    @Around("performance()")
    public void timePer(ProceedingJoinPoint joinPoint){
        try {
            long startTime = System.currentTimeMillis();
            joinPoint.proceed();
            System.out.println("表演结束，耗时："+(System.currentTimeMillis()-startTime)+"ms");
        } catch (Throwable throwable) {
            perAfterError();
            throwable.printStackTrace();
        }
    }

    @AfterReturning("performance()")
    public void perAfter(){
        System.out.println("表演之后，观众鼓掌。。。");
    }
    @AfterThrowing("performance()")
    public void perAfterError(){
        System.out.println("表演出现意外之后，观众撤离，要求退款。。。");
    }
}
