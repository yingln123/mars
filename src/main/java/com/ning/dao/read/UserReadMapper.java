package com.ning.dao.read;

import java.util.List;

import com.ning.entity.User;

public interface UserReadMapper {
	
	User selectByPrimaryKey(Long id);
	
    List<User> queryUserByUser(User user);
}