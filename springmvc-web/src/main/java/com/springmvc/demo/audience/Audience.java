package com.springmvc.demo.audience;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 定义切面
 * springAOP 声明式定义
 * Created by liuxun on 2017/8/17.
 */
@Aspect  //启用
@Component
public class Audience {
    private static Logger logger = Logger.getLogger(Audience.class);
    //定义切入点 value指定切入点的表达式，argNames指定命名切入点方法参数列表参数名字，可以有多个用“,”分隔，这次出单数将传递给通知方法同名参数。
    @Pointcut(value = "execution(** com.springmvc.demo.service.Performance.*(..))")
    public void performance(){}

    /**
     * 带参数的通知
     * @param point
     */
    @Before("performance()")
    public void bookingByName(JoinPoint point){
        logger.info("@Before：目标方法为：" +point.getSignature().getDeclaringTypeName() +
                "." + point.getSignature().getName());
        logger.info("@Before：目标方法的参数为：" + Arrays.toString(point.getArgs()));
        logger.info("@Before：被织入的目标对象为：" + point.getTarget());
        logger.info("表演之前，观众订票。。。");
    }

    @Before("performance()")
    public void booking(){
        logger.info("表演之前，观众订票。。。");
    }
    @Before("performance()")
    public void enterTheSite(){
        logger.info("表演之前，观众进入场地。。。");
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
            joinPoint.proceed(); //执行被通知的方法
            logger.info("表演结束，耗时："+(System.currentTimeMillis()-startTime)+"ms");
        } catch (Throwable throwable) {
            perAfterError();
            throwable.printStackTrace();
        }
    }

    @AfterReturning("performance()")
    public void perAfter(){
        logger.info("表演之后，观众鼓掌。。。");
    }
    @AfterThrowing("performance()")
    public void perAfterError(){
        logger.info("表演出现意外之后，观众撤离，要求退款。。。");
    }


}
