package com.springmvc.demo.service.impl;

import com.springmvc.demo.service.Dessert;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Qualifier限定自动装配的bean解决自动装配歧义性
 * Created by liuxun on 2017/8/17.
 */
@Component
@Qualifier("p")
public class Popsicle implements Dessert {
    @Override
    public String getName() {
        return "Popsicle";
    }
}
