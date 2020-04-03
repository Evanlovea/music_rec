package com.haut.music.dao;

import java.util.List;

import com.haut.music.model.Song;

public interface NewTrackOnShelfDao {

	/**
	 * 查询当前新歌曲
	 * @return
	 * 若没有新歌曲，则返回null
	 */
	List<Song> selecNewSong();

}
