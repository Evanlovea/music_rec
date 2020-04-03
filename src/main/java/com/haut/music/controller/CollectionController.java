package com.haut.music.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haut.music.service.CollectionService;
import com.haut.music.service.UserService;
import com.haut.music.utils.ReturnMsg;

/**
 * 收藏业务逻辑实现
 */
@Controller
public class CollectionController {
	@Autowired
	private CollectionService collectionService;


	//只接受post方式的请求
	@PostMapping(value = "collectSong.do",produces = "text/html;charset=UTF-8")
	/**
	 * @ResponseBody
	 * 注解的作用是将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，
	 * 写入到response对象的body区，通常用来返回JSON数据或者是XML
	 */
	@ResponseBody
	public String collectSong(HttpServletRequest request,int songId) {
		boolean isCollected=collectionService.collectionChange(request,songId);
		return ReturnMsg.msg(HttpServletResponse.SC_OK, isCollected+"");
		
	}

}
