package com.haut.music.dao;

import java.util.List;

import com.haut.music.model.Collection;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionDao {

	/**
	 * 查询用户对某歌曲的收藏
	 * @param collection
	 * 记录对象
	 * @return
	 * 若没有收藏，则返回null
	 */
	public Collection selectByCollection(Collection collection);

	/**
	 * 删除收藏记录
	 * @param collectionId
	 * 记录Id
	 */
	public void deleteById(int collectionId);

	/**
	 * 添加新记录
	 * @param collection
	 */
	public void insert(Collection collection);

	/**
	 * 查询所有用户的收藏记录
	 * @return
	 */
	public List<Collection> selectAll();

}
