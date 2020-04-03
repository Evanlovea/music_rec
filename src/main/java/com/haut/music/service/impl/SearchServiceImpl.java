package com.haut.music.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haut.music.dao.SearchDao;
import com.haut.music.dao.TrendingRecDao;
import com.haut.music.dao.UserDao;
import com.haut.music.model.Collection;
import com.haut.music.model.Review;
import com.haut.music.model.Song;
import com.haut.music.model.User;
import com.haut.music.service.SearchService;
import com.haut.music.utils.Request;

@Service("searchService")
public class SearchServiceImpl implements SearchService{
	@Autowired
	private SearchDao searchDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private TrendingRecDao trendingRecDao;
	

	public List<Song> getSearchSongWithCollectionFlag(HttpServletRequest request, String keyword) {
		List<Song> searchSongList=new ArrayList<Song>();
		List<Collection> collectionList=new ArrayList<Collection>();
		User user=userDao.selectByUser(Request.getUserFromHttpServletRequest(request));
		collectionList=trendingRecDao.getCollection(user);
		searchSongList=searchDao.selectSongLikeKeyword(keyword);
		
		//在搜索结果列表中给已经被该用户收藏的歌曲加上标记
		if(collectionList!=null && searchSongList!=null) {
			for(Collection c:collectionList) {
				for(Song t:searchSongList) {
					if(c.getSongId()==t.getSongId()) {
						t.setWhetherCollected(true);
					}
				}
			}
		}
		return searchSongList;
	}


	public List<Review> getSearchReview(String keyword) {
		List<Review> searchReviewList=new ArrayList<Review>();
		searchReviewList=searchDao.selectReviewLikeKeyword(keyword);
		return searchReviewList;
	}


	public List<User> getSearchUser(HttpServletRequest request,String keyword) {
		User user=userDao.selectByUser(Request.getUserFromHttpServletRequest(request));
		List<User> searchUserList=new ArrayList<User>();
		searchUserList=searchDao.selectUserLikeKeyword(keyword,user.getUserId());
		return searchUserList;
	}


	public List<Song> getSearchSong(String keyword) {
		List<Song> searchSongList=new ArrayList<Song>();
		searchSongList=searchDao.selectSongLikeKeyword(keyword);
		return searchSongList;
	}
	

}
