package com.haut.music.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.haut.music.model.Song;

public interface RankingPageService {

	/**
	 * 获取最近一段时间的排行榜歌曲列表
	 * @param request
	 * HttpServletRequest
	 * @param mode
	 * 如果mode=1,则为最近一周的;如果mode=2则为最近一个月;如果mode=其他数字，也为最近一个月的
	 * @return
	 * 如果没有，则返回null
	 */
	List<Song> getRankWithCollectionFlag(HttpServletRequest request, int mode);

}
