package com.haut.music.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.haut.music.service.RecordPlayService;
//音乐播放记录
@Controller
public class RecordPlayController {
	@Autowired
	private RecordPlayService recordPlayService;
	
	
	@GetMapping(value = "recordPlay.do")
	public void recordPlay(HttpServletRequest request,int songId) {
		recordPlayService.recordPlay(request,songId);
		
	}

}
