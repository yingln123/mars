package com.ning.dao.write;

import com.ning.entity.RequestLog;

public interface RequestLogWriteMapper {
	
    int deleteByPrimaryKey(Long id);

    int insert(RequestLog record);

    int insertSelective(RequestLog record);

    int updateByPrimaryKeySelective(RequestLog record);

    int updateByPrimaryKey(RequestLog record);
}