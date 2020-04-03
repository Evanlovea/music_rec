package com.haut.music.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.haut.music.model.Song;

public interface PersonalRecService {

	/**
	 * 获取当前用户每天的个性化推荐音乐列表，并带上是否已经收藏的标记.
	 * 每天早上6点更新一次
	 * @param request
	 * HttpServletRequest
	 * @return
	 * 若没有获取到，返回null
	 */
	List<Song> getPersonalDailyRecWithCollectionFlag(HttpServletRequest request);

	/**
	 * 初始化当前用户的个性化音乐推荐列表
	 * @param request
	 * HttpServletRequest
	 */
	void initializePersonalRecList(HttpServletRequest request);

	/**
	 * 更新个性化推荐列表B
	 * @param user2song
	 * userId to songId matrix
	 */
	void updatePersonalRecIntoB(Map<Integer, Integer[]> user2song);

	/**
	 * 更新个性化推荐列表A
	 * @param user2song
	 * userId to songId matrix
	 */
	void updatePersonalRecIntoA(Map<Integer, Integer[]> user2song);

	/**
	 * 向个性化推荐列表A添加混合推荐的结果
	 * @param user2song
	 * userId to songId matrix
	 */
	void addHybridRecIntoA(Map<Integer, Integer[]> user2song);

	/**
	 * 向个性化推荐列表B添加混合推荐的结果
	 * @param user2song
	 * userId to songId matrix
	 */
	void addHybridRecIntoB(Map<Integer, Integer[]> user2song);
	
}
