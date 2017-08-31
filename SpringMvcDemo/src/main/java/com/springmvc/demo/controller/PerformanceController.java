package com.springmvc.demo.controller;

import com.springmvc.demo.service.CompactDisc;
import com.springmvc.demo.service.Performance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * AOP测试
 * Created by liuxun on 2017/8/17.
 */
@Controller
@RequestMapping("/per")
public class PerformanceController {
    @Autowired
    private Performance jayPerformance;
    @Autowired
    private CompactDisc gtPepperss;
    @RequestMapping(value = "/doPer",method = RequestMethod.GET)
    public String doPer(String name,ModelMap model) {
        model.addAttribute("message", "Jay");
        jayPerformance.perform();
        jayPerformance.performByName(name);
        return "hello";
    }

    @RequestMapping(value = "/doPep",method = RequestMethod.GET)
    public String doPep(String name,ModelMap model) {
        model.addAttribute("message", "Jay");
        gtPepperss.play();
        return "hello";
    }
}
