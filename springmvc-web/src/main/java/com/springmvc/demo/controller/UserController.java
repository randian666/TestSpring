package com.springmvc.demo.controller;


import com.springmvc.demo.domain.User;
import com.springmvc.demo.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);
	@Resource
	private UserService userService;
	/**
	 * 每页显示数量
	 */
	private final static int PAGE_SIZE=2;
	/**
	 * @RequestParam 映射请求参数
	 * value 请求参数的参数名 ，作为参数映射名称
	 * required 该参数是否必填，默认为true(必填)，当设置成必填时，如果没有传入参数，报错
	 * defaultValue 设置请求参数的默认值
	 */
	@RequestMapping(value = "/getUserList",method = RequestMethod.GET)
	public String getUserList(@RequestParam(value ="page",required=false,defaultValue="1") int page, ModelMap model) {
		List<User> users = userService.getUserList(page,PAGE_SIZE);
		model.addAttribute("users",users);
		return "user_view";
	}
}
