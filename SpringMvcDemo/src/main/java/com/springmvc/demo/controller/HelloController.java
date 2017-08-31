package com.springmvc.demo.controller;

import com.springmvc.demo.model.CDPlayer;
import com.springmvc.demo.model.CircleA;
import com.springmvc.demo.model.Notepad;
import com.springmvc.demo.model.User;
import com.springmvc.demo.service.impl.Popsicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class HelloController {
	@Autowired
	@Qualifier("p")
	private Popsicle popsicle;
	@Autowired
	private Notepad notepad;
	@Autowired
	private CDPlayer cdPlayer;
	@Value("#{dataTest.map['MapA']}") //SpEL表达式 #{...} 直接访问另外类中的属性
	private String mapA;

	@Value("#{dataTest.list}")
	private List<String> list;
	@Value("#{dataTest.users}")
	private List<User> users;

	@RequestMapping(value = "/print",method = RequestMethod.GET)
	public String print(String name,ModelMap model) {
		model.addAttribute("message", popsicle.getName());
		model.addAttribute("list",list);
		model.addAttribute("users",users);
		cdPlayer.doPlay();
		System.out.println(notepad.getNotepad());
		return "hello";
	}

	/**
	 * springmvc restful风格接口
	 * @param spittleId
	 * @param model
     * @return
     */
	@RequestMapping(value = "/spittles/{spittleId}",method = RequestMethod.GET)
	public String spittle(@PathVariable("spittleId") long spittleId,ModelMap model){
		model.addAttribute("message", spittleId);
		return "hello";
	}
	/**
	 * 重定向
	 * @return
     */
	@RequestMapping(value = "/register")
	public String register(){
		return "redirect:/spittles/"+333;
	}
}
