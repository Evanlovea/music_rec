package com.haut.music.dao;

import java.util.List;

import com.haut.music.model.DownloadRecord;

public interface RecordDownloadDao {

	/**
	 * 添加新下载记录
	 * @param downloadRecord
	 */
	void insert(DownloadRecord downloadRecord);

	/**
	 * 获取所有用户的下载记录
	 * @return
	 */
	List<DownloadRecord> selectAll();

}
