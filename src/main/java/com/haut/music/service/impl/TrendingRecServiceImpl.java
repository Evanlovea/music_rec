package com.haut.music.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haut.music.dao.TrendingRecDao;
import com.haut.music.dao.UserDao;
import com.haut.music.model.Collection;
import com.haut.music.model.Song;
import com.haut.music.model.User;
import com.haut.music.service.TrendingRecService;
import com.haut.music.utils.Request;

@Service("trendingService")
public class TrendingRecServiceImpl implements TrendingRecService {
	@Autowired
	private TrendingRecDao trendingRecDao;
	@Autowired
	private UserDao userDao;

	public List<Song> getSongWithCollectionFlag(HttpServletRequest request) {
		List<Song> trendingRecList=new ArrayList<Song>();
		List<Collection> collectionList=new ArrayList<Collection>();
		User user=userDao.selectByUser(Request.getUserFromHttpServletRequest(request));
		collectionList=trendingRecDao.getCollection(user);
		trendingRecList=trendingRecDao.getTrendingSong();
		//在热门推荐列表中给已经被该用户收藏的歌曲加上标记
		if(collectionList!=null && trendingRecList!=null) {
			for(Collection c:collectionList) {
				for(Song t:trendingRecList) {
					if(c.getSongId()==t.getSongId()) {
						t.setWhetherCollected(true);
					}
				}
			}
		}
		return trendingRecList;
	}

}
