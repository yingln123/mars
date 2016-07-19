package com.ning.dao.write;

import com.ning.entity.User;

public interface UserWriteMapper {
	
	int deleteByPrimaryKey(Long id);
	
    int insert(User record);

    int insertSelective(User record);
    
}