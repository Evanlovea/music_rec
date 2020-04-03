package com.haut.music.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haut.music.dao.NewTrackOnShelfDao;
import com.haut.music.dao.TrendingRecDao;
import com.haut.music.dao.UserDao;
import com.haut.music.model.Collection;
import com.haut.music.model.Song;
import com.haut.music.model.User;
import com.haut.music.service.NewTrackOnShelfService;
import com.haut.music.utils.Request;

@Service("newTrackOnShelfService")
public class NewTrackOnShelfServiceImpl implements NewTrackOnShelfService{
	@Autowired
	private NewTrackOnShelfDao newTrackOnShelfDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private TrendingRecDao trendingRecDao;

	public List<Song> getNewTrackWithCollectionFlag(HttpServletRequest request) {
		List<Song> newTackOnShelList=new ArrayList<Song>();
		List<Collection> collectionList=new ArrayList<Collection>();
		User user=userDao.selectByUser(Request.getUserFromHttpServletRequest(request));
		collectionList=trendingRecDao.getCollection(user);
		newTackOnShelList=newTrackOnShelfDao.selecNewSong();
		//在新碟上架列表中给已经被该用户收藏的歌曲加上标记
		if(collectionList!=null && newTackOnShelList!=null) {
			for(Collection c:collectionList) {
				for(Song t:newTackOnShelList) {
					if(c.getSongId()==t.getSongId()) {
						t.setWhetherCollected(true);
					}
				}
			}
		}
		return newTackOnShelList;
	}

}
