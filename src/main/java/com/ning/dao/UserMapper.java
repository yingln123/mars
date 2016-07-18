package com.ning.dao;

import java.util.List;

import com.ning.entity.User;

public interface UserMapper {
	
	int deleteByPrimaryKey(Long id);
	
	User selectByPrimaryKey(Long id);
	
    int insert(User record);

    int insertSelective(User record);
    
    List<User> queryUserByUser(User user);
    
}