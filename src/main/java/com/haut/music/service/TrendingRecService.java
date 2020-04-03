package com.haut.music.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.haut.music.model.Song;

public interface TrendingRecService {

	/**
	 * 获取当下热门的，带上当前用户是否收藏的标记的音乐推荐
	 * @param request
	 * HttpServletRequest
	 * @return
	 * 若曲库中没有任何歌曲，则返回null
	 */
	List<Song> getSongWithCollectionFlag(HttpServletRequest request);

}
