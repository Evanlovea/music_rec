package com.haut.music.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.haut.music.model.Song;
import com.haut.music.service.MyMusicService;
import com.haut.music.utils.OneDayOneWord;
import com.haut.music.utils.Static;
//处理页面请求
@Controller
public class MyMusicPageController {
	@Autowired
	private MyMusicService myMusicService;
	//当控制器处理完请求时，
	// 通常会将包含视图名称或视图对象以及一些模型属性的ModelAndView对象返回到DispatcherServlet。
	@GetMapping(value = "myMusicFrameLoad.do")
	public ModelAndView myMusicFrameLoad(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("myMusicFrame");
		//modelAndView.addObject("oneDayOneWord",OneDayOneWord.getOneDayOneWord(Static.MY_MUSIC_WORD_ARRAY));
		
		return modelAndView;
		
	}
	
	@GetMapping(value = "recentFrameLoad.do")
	public ModelAndView recentFrameLoad(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("recentFrame");
		List<Song> myRecentPlayList=myMusicService.getMyRecentPlayListWithCollectionFlag(request);
		
		modelAndView.addObject("myRecentPlayList",myRecentPlayList);
		modelAndView.addObject("oneDayOneWord",OneDayOneWord.getOneDayOneWord(Static.MY_MUSIC_WORD_ARRAY));
		
		return modelAndView;
		
	}
	
	@GetMapping(value = "collectedFrameLoad.do")
	public ModelAndView collectedFrameLoad(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("collectedFrame");
		List<Song> myCollectionList=myMusicService.getMyCollectionWithCollectionFlag(request);
		
		modelAndView.addObject("myCollectionList",myCollectionList);
		modelAndView.addObject("oneDayOneWord",OneDayOneWord.getOneDayOneWord(Static.MY_MUSIC_WORD_ARRAY));
		
		return modelAndView;
		
	}

}
