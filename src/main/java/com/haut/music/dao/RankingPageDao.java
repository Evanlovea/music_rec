package com.haut.music.dao;

import java.util.List;

import com.haut.music.model.Song;

public interface RankingPageDao {

	/**
	 * 获取最近一周排行榜列表
	 * @return
	 * 如果没有，则返回null
	 */
	List<Song> selectRecentWeekRanking();

	/**
	 * 获取最近一个月排行榜列表
	 * @return
	 * 如果没有，则返回null
	 */
	List<Song> selectRecentMonthRanking();

}
