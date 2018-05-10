package com.huaweisoft.training.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.huaweisoft.training.common.JsonResult;
import com.huaweisoft.training.dto.request.UserLoginReq;

@Controller
public class IndexController {

	private final Logger log = Logger.getLogger(IndexController.class);

	/**
	 * 欢迎页
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model) {
		log.info("进入欢迎页");
		return "login";
	}

	/**
	 * 登录：使用form表单提交的方式
	 */
	/*@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model) {

		log.info("入参用户名：" + username);
		log.info("入参密码：" + password);

		log.info("登录成功");
		model.addAttribute("username", username);
		return "redirect:/view/index.jsp";
	}*/
	
	/**
	 * 登录：使用Ajax提交的方式
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult login(HttpServletRequest request, @RequestBody UserLoginReq userLoginReq) {

		log.info("入参：" + JSON.toJSONString(userLoginReq));
		log.info("登录成功");
		return JsonResult.success("登录成功");
	}

	/**
	 * 登出
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model) {
		log.info("登出成功");
		return "redirect:/view/login.jsp";
	}

}
