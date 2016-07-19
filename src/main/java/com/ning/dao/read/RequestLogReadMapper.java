package com.ning.dao.read;

import java.util.List;

import com.ning.entity.RequestLog;

public interface RequestLogReadMapper {

    RequestLog selectByPrimaryKey(Long id);

    List<RequestLog> queryRequestLogByRequestLog(RequestLog requestLog);
}