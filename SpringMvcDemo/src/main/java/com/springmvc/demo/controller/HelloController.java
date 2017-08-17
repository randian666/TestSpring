package com.springmvc.demo.controller;

import com.springmvc.demo.model.CDPlayer;
import com.springmvc.demo.model.CircleA;
import com.springmvc.demo.model.Notepad;
import com.springmvc.demo.service.impl.Popsicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	@RequestMapping(value = "/print",method = RequestMethod.GET)
	public String printWelcome(String name,ModelMap model) {
		model.addAttribute("message", popsicle.getName());
		cdPlayer.doPlay();
		System.out.println(notepad.getNotepad());
		return "hello";
	}
}
