package com.haut.music.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haut.music.dao.RecordPlayDao;
import com.haut.music.dao.UserDao;
import com.haut.music.model.PlayRecord;
import com.haut.music.model.User;
import com.haut.music.service.RecordPlayService;
import com.haut.music.utils.Request;

@Service("recordPlayService")
public class RecordPlayServiceImpl implements RecordPlayService{
	@Autowired
	private UserDao userDao;
	@Autowired
	private RecordPlayDao recordPlayDao;
	

	public void recordPlay(HttpServletRequest request, int songId) {
		User user=userDao.selectByUser(Request.getUserFromHttpServletRequest(request));
		recordPlayDao.insert(new PlayRecord(user.getUserId(),songId));
		
	}


	public List<PlayRecord> getAllRecords() {
		return recordPlayDao.selectAll();
	}
	

}
