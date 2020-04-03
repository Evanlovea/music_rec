package com.haut.music.dao;

import java.util.List;

import com.haut.music.model.PlayRecord;

public interface RecordPlayDao {

	/***
	 * 添加新的播放记录
	 * @param playRecord
	 */
	void insert(PlayRecord playRecord);

	/**
	 * 查询所有用户的播放记录
	 * @return
	 */
	List<PlayRecord> selectAll();

}
