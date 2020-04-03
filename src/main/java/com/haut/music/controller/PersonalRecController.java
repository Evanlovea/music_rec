package com.haut.music.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.haut.music.model.Song;
import com.haut.music.service.PersonalRecService;
import com.haut.music.service.TrendingRecService;
import com.haut.music.utils.Static;
//个性化推荐
@Controller
public class PersonalRecController {
	@Autowired
	private PersonalRecService personalRecService;
	
	@RequestMapping(value = "personalizedRecFrameLoad.do",method = { RequestMethod.GET })
	public ModelAndView personalizedRecFrameLoad(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("personalizedRecFrame");
		List<Song> personalRecSongList=personalRecService.getPersonalDailyRecWithCollectionFlag(request);
		
		modelAndView.addObject("personalRecSongList",personalRecSongList);
		if(personalRecSongList==null) {
			modelAndView.addObject("oneDayOneWord","登录即享——遇见不一样的自己");
		}else {
			modelAndView.addObject("oneDayOneWord","更懂你的心");
		}
		return modelAndView;
	}

}
