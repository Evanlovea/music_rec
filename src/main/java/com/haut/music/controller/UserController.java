package com.haut.music.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.haut.music.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "deleteUser.do", method = { RequestMethod.POST })
	public void deleteUser(HttpServletRequest request, int userIds[]) {
		if(userService.isHasPrivilege(request)) {
			userService.batchDeleteById(userIds);
		}
		
	}

}
