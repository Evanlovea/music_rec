package com.haut.music.dao;

import java.util.List;

import com.haut.music.model.Song;
import com.haut.music.model.User;

public interface PersonalRecDao {

	/**
	 * 从表A中获取当前用户的个性化推荐列表
	 * @param user 
	 * @return
	 * 初始化为随机歌曲列表
	 */
	List<Song> selectPersonalRecFromA(User user);

	/**
	 * 从表B中获取当前用户的个性化推荐列表
	 * @param user 
	 * @return
	 * 初始化为随机歌曲列表
	 */
	List<Song> selectPersonalRecFromB(User user);

	/**
	 * 向reca表中插入数据
	 * @param userId
	 * 用户id
	 * @param songId
	 * 歌曲id
	 */
	void insertRecA(int userId, int songId);

	/**
	 * 向recb表中插入数据
	 * @param userId
	 * 用户id
	 * @param songId
	 * 歌曲id
	 */
	void insertRecB(int userId, int songId);

	/**
	 * 根据id从recB表中删除数据
	 * @param userId
	 */
	void deleteBByUserId(int userId);
	
	/**
	 * 根据id从recA表中删除数据
	 * @param userId
	 */
	void deleteAByUserId(int userId);

	/**
	 * 将List里面的songId和userId批量插入A表
	 * @param songList
	 * 包含歌曲Id的信息列表
	 * @param userId
	 * 用户的Id
	 */
	void insertListIntoRecA(List<Song> songList, int userId);
	
	/**
	 * 将List里面的songId和userId批量插入B表
	 * @param songList
	 * 包含歌曲Id的信息列表
	 * @param userId
	 * 用户的Id
	 */
	void insertListIntoRecB(List<Song> songList, int userId);

	/***
	 * 将数组里面的songId和userId批量插入B表
	 * @param recSongIds
	 * songId数组
	 * @param userId
	 * 用户的Id
	 */
	void insertArrayIntoRecB(Integer[] recSongIds, Integer userId);

	/***
	 * 将数组里面的songId和userId批量插入A表
	 * @param recSongIds
	 * songId数组
	 * @param userId
	 * 用户的Id
	 */
	void insertArrayIntoRecA(Integer[] recSongIds, Integer userId);

}
