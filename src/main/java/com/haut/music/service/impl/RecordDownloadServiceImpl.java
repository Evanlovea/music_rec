package com.haut.music.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haut.music.dao.RecordDownloadDao;
import com.haut.music.dao.UserDao;
import com.haut.music.model.DownloadRecord;
import com.haut.music.model.User;
import com.haut.music.service.RecordDownloadService;
import com.haut.music.utils.Request;

@Service("recordDownloadService")
public class RecordDownloadServiceImpl implements RecordDownloadService{
	@Autowired
	private UserDao userDao;
	@Autowired
	private RecordDownloadDao recordDownloadDao;

	public void recordDownload(HttpServletRequest request, int songId) {
		User user=Request.getUserFromHttpServletRequest(request);
		if(user==null) {
			return;
		}
		//记录当前用户的下载记录
		user=userDao.selectByUser(user);
		recordDownloadDao.insert(new DownloadRecord(user.getUserId(),songId));
	}

	public List<DownloadRecord> getAllRecords() {
		return recordDownloadDao.selectAll();
	}

}
