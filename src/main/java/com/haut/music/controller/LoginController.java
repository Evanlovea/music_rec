package com.haut.music.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import com.haut.music.model.User;
import com.haut.music.service.UserService;
import com.haut.music.utils.ReturnMsg;

/**
 * 实现用户登录
 */
@Controller
public class LoginController {
	@Autowired
	private UserService userService;

	
	@PostMapping(value = "login.do",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String login(HttpServletRequest request, User u) {
		boolean isUserExisted=userService.findLogin(u);
		if(!isUserExisted) {
			return ReturnMsg.msg(HttpServletResponse.SC_BAD_REQUEST, "帐号或密码错误");
		}else {
			request.getSession().setAttribute("user", u);
			request.getSession().setAttribute("isHasPrivilege", userService.isHasPrivilege(request));
			return ReturnMsg.msg(HttpServletResponse.SC_OK, JSONObject.toJSON(u).toString());
		}
	}
	
	
	

}
