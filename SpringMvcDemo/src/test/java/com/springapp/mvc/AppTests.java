package com.springapp.mvc;

import com.springmvc.demo.model.CircleA;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:/mvc-dispatcher-servlet.xml")
public class AppTests {
    private MockMvc mockMvc;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void simple() throws Exception {
        mockMvc.perform(get("/print"))
                .andExpect(status().isOk());
    }

    /**
     * spring循环引用
     */
    @Test
    public void init_beans(){
        try {
//通过构造器循环引用
//1、Spring容器创建“circleA” Bean，首先去“当前创建Bean池”查找是否当前Bean正在创建，如果没发现，则继续准备其需要的构造器参数“circleB”，并将“circleA” 标识符放到“当前创建Bean池”；
//2、Spring容器创建“circleB” Bean，首先去“当前创建Bean池”查找是否当前Bean正在创建，如果没发现，则继续准备其需要的构造器参数“circleC”，并将“circleB” 标识符放到“当前创建Bean池”；
//3、Spring容器创建“circleC” Bean，首先去“当前创建Bean池”查找是否当前Bean正在创建，如果没发现，则继续准备其需要的构造器参数“circleA”，并将“circleC” 标识符放到“当前创建Bean池”；
//4、到此为止Spring容器要去创建“circleA”Bean，发现该Bean 标识符在“当前创建Bean池”中，因为表示循环依赖，抛出BeanCurrentlyInCreationException。

//通过set循环引用
//1、Spring容器创建单例“circleA” Bean，首先根据无参构造器创建Bean，并暴露一个“ObjectFactory ”用于返回提前暴露一个创建中的Bean，并将“circleA” 标识符放到“当前创建Bean池”；然后进行setter注入“circleB”；
//2、Spring容器创建单例“circleB” Bean，首先根据无参构造器创建Bean，并暴露一个“ObjectFactory”用于返回提前暴露一个创建中的Bean，并将“circleB” 标识符放到“当前创建Bean池”，然后进行setter注入“circleC”；
//3、Spring容器创建单例“circleC” Bean，首先根据无参构造器创建Bean，并暴露一个“ObjectFactory ”用于返回提前暴露一个创建中的Bean，并将“circleC” 标识符放到“当前创建Bean池”，然后进行setter注入“circleA”；进行注入“circleA”时由于提前暴露了“ObjectFactory”工厂从而使用它返回提前暴露一个创建中的Bean；
//4、最后在依赖注入“circleB”和“circleA”，完成setter注入。会导致死循环，对于“singleton”作用域Bean，可以通过“setAllowCircularReferences(false);”来禁用循环引用
//对于“prototype”作用域Bean，Spring容器无法完成依赖注入，因为“prototype”作用域的Bean，Spring容器不进行缓存，因此无法提前暴露一个创建中的Bean。
            ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("spring/spring-beans.xml");
//            app.setAllowCircularReferences(false);//禁用循环引用
//            app.refresh();//设置后需要重新刷新
            CircleA a =(CircleA)app.getBean("circleA");
            a.a();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
