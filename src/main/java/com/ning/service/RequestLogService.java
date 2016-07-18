package com.ning.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ning.dao.RequestLogMapper;
import com.ning.entity.RequestLog;

@Service
public class RequestLogService {
	
	@Autowired
	private RequestLogMapper requestLogMapper;
	
	/**
	 * 添加系统日志
	 * @param requestLog
	 */
	public void addRequestLog(RequestLog requestLog){
		
		this.requestLogMapper.insertSelective(requestLog);
		System.out.println("add request log success !!!");
	}
	
	/**
	 * 查询系统日志
	 * @param requestLog
	 * @return
	 */
	public List<RequestLog> queryRequestLogByRequestLog(RequestLog requestLog){
		
		List<RequestLog> requestLogList = this.requestLogMapper.queryRequestLogByRequestLog(requestLog);
		if(requestLogList == null){
			requestLogList = new ArrayList<RequestLog>();
		}
		
		return requestLogList;
	}
}
