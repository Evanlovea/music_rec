package com.haut.music.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.haut.music.model.Song;
import com.haut.music.model.Song;

public interface NewTrackOnShelfService {

	/**
	 * 获取当前的新碟歌曲,并加上是否以及被收藏标记
	 * @param request
	 * @return
	 */
	List<Song> getNewTrackWithCollectionFlag(HttpServletRequest request);

}
