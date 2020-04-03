package com.haut.music.dao;

import java.util.List;

import com.haut.music.model.Role;
import com.haut.music.model.User;

public interface UserDao {

	/**
	 * 根据某个用户的email和password进行查询
	 * @param u
	 * 用户User对象
	 * @return
	 * 若查询成功返回查询到的对象，否则返回null
	 */
	public User selectByUser(User u);

	/**
	 * 根据某个email记录进行查询
	 * @param email
	 * 邮箱帐号
	 * @return
	 * 若查询成功返回查询到的对象，否则返回null
	 */
	public User selectByEmail(String email);

	/**
	 * 向user用户表中插入新的记录
	 * @param u
	 * 用户User对象
	 * @return
	 * 若插入成功返回1,否则返回0,即返回受影响的行数
	 */
	public int insert(User u);

	/**
	 * 查询所有的用户记录
	 * @return
	 * 若没有，则返回null
	 */
	public List<User> selectAll();

	/**
	 * 查询所有的用户Id记录
	 * @return
	 * 若没有，则返回null
	 */
	public List<Integer> selectAllUserId();

	/**
	 * 批量删除，根据数组里面的Id删除对应的用户
	 * @param userIds
	 */
	public void deleteByIds(int[] userIds);

	/**
	 * 根据用户Id查询当前用户的角色信息
	 * @param userId
	 * 当前用户的Id
	 * @return
	 * 若没有，则返回null
	 */
	public Role selectRoleByUserId(int userId);
	

}
