package com.springmvc.demo.config;

import com.springmvc.demo.model.CDPlayer;
import com.springmvc.demo.model.Notepad;
import com.springmvc.demo.service.CompactDisc;
import com.springmvc.demo.service.impl.SgtPeppers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

/**
 * Created by liuxun on 2017/8/17.
 */
@Configuration  //配置类标识注解
@ComponentScan(basePackages = "com.springmvc.demo.*") //自动扫描注解
@PropertySource("classpath:app.properties") //导入properties属性文件
@EnableAspectJAutoProxy //启用AspectJ自动代理
public class BeanConfig {
    /**
     * 注入外部值
     */
    @Autowired
    private Environment env;
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
//        判断属性是否存在
        boolean titleExists=env.containsProperty("disc.name");
        //获取外部属性，并给定一个默认值

        return new SgtPeppers(env.getProperty("disc.name","springframework"));
    }
    /**
     * 为了使用占位符，我们必须要配置一个PropertySourcesPlaceholderConfigurer
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}
