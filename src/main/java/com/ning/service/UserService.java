package com.ning.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ning.dao.UserMapper;
import com.ning.entity.User;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public void addUser(String name, String password){
		
		System.out.println(name + " -- " + password);
	}
	
	/**
	 * 创建User
	 * @param user
	 */
	public void addUser(User user){
		
		this.userMapper.insertSelective(user);
	}
	
	/**
	 * 根据User实体为参数筛选User用户
	 * @param user
	 * @return
	 */
	public List<User> queryByUser(User user){
		
		List<User> userList = this.queryByUser(user);
		if(userList == null){
			userList = new ArrayList<User>();
		}
		
		return userList;
	}
	
	/**
	 * 根据userId获取User
	 * @param userId
	 * @return
	 */
	public User queryUserById(Long userId){
		return this.userMapper.selectByPrimaryKey(userId);
	}
}
