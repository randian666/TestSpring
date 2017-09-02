package com.springmvc.demo.controller;


import com.springmvc.demo.domain.User;
import com.springmvc.demo.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);
	@Resource
	private UserService userService;

	@RequestMapping(value = "/getUserList",method = RequestMethod.GET)
	public String getUserList(ModelMap model) {
		List<User> users = userService.getUserList();
		model.addAttribute("users",users);
		return "user_view";
	}
}
