package com.haut.music.utils;

import javax.servlet.http.HttpServletRequest;

import com.haut.music.model.User;

/**
 * 获取userSession
 */
public class Request {
	
	public static User getUserFromHttpServletRequest(HttpServletRequest request) {
		return (User) request.getSession().getAttribute("user");
	}

}
