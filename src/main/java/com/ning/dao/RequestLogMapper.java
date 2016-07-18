package com.ning.dao;

import java.util.List;

import com.ning.entity.RequestLog;

public interface RequestLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RequestLog record);

    int insertSelective(RequestLog record);

    RequestLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RequestLog record);

    int updateByPrimaryKey(RequestLog record);
    
    List<RequestLog> queryRequestLogByRequestLog(RequestLog requestLog);
}