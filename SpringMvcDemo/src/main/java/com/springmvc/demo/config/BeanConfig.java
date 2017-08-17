package com.springmvc.demo.config;

import com.springmvc.demo.model.CDPlayer;
import com.springmvc.demo.model.Notepad;
import com.springmvc.demo.service.CompactDisc;
import com.springmvc.demo.service.impl.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by liuxun on 2017/8/17.
 */
@Configuration
@ComponentScan(basePackages = "com.springmvc.demo.*")
public class BeanConfig {

    /**
     * Spring作用域
     * 单例(Singleton)：在整个应用中只创建bean的一个实例 默认作用域
     * 原型(Prototype):每次注入或者通过Spring应用上下文获取的时候，都会创建一个新的bean实例
     * 会话(Session):在web应用中，为每次会话创建一个bean实例
     * 请求(Rquest):在web应用中，为每个请求创建一个bean实例
     * Created by liuxun on 2017/8/17.
     */
    @Bean
    @Scope("prototype")
    public Notepad notepad(){
        return new Notepad();
    }

    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc){
        return new CDPlayer(compactDisc);
    }
    @Bean
    public CompactDisc sgtPeppers(){
        return new SgtPeppers();
    }
}
