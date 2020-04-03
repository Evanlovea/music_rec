package com.haut.music.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

import com.haut.music.model.User;
import com.haut.music.service.SongService;
import com.haut.music.service.UserService;
import com.haut.music.utils.ReturnMsg;

@Controller
public class SongController {
	@Autowired
	private UserService userService;
	@Autowired
	private SongService songService;
	
	@RequestMapping(value = "deleteSong.do", method = { RequestMethod.POST })
	public void deleteSong(HttpServletRequest request, int songIds[]) {
		if(userService.isHasPrivilege(request)) {
			songService.batchDeleteById(request,songIds);
		}
		
	}

	/**
	 * 添加歌词歌曲
	 * @param request
	 * @param song
	 * @param lyric
	 * @return
	 */
	@PostMapping(value = "addSong.do",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addSong(HttpServletRequest request, MultipartFile song, MultipartFile lyric) {
		if(userService.isHasPrivilege(request) && songService.checkFormat(song,lyric)) {
			boolean isSuccessful=songService.addSong(request,song,lyric);
			if(isSuccessful) {
				return ReturnMsg.msg(HttpServletResponse.SC_OK, "上传成功");
			}else {
				return ReturnMsg.msg(HttpServletResponse.SC_BAD_REQUEST, "上传失败");
			}
		}
		
		return ReturnMsg.msg(HttpServletResponse.SC_BAD_REQUEST, "格式错误");
	}

}
