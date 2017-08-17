package com.springmvc.demo.controller;

import com.springmvc.demo.model.CircleA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping
public class HelloController {

	@RequestMapping(value = "/print",method = RequestMethod.GET)
	public String printWelcome(String name,ModelMap model) {
		model.addAttribute("message", name);
		System.out.println("asdf");
		System.out.println("2323");
		System.out.println("45454");
		System.out.println("6666666");
		System.out.println("7777777");
		System.out.println("888888888");
		return "hello";
	}
}
