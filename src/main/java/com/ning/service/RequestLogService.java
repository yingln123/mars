package com.ning.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ning.dao.read.RequestLogReadMapper;
import com.ning.dao.write.RequestLogWriteMapper;
import com.ning.entity.RequestLog;

@Service
public class RequestLogService {
	
	@Autowired
	private RequestLogWriteMapper requestLogWriteMapper;
	
	@Autowired
	private RequestLogReadMapper requestLogReadMapper;
	
	/**
	 * 添加系统日志
	 * @param requestLog
	 */
	public void addRequestLog(RequestLog requestLog){
		
		List<RequestLog> requestLogList = this.requestLogReadMapper.queryRequestLogByRequestLog(new RequestLog());
		
		if(requestLogList != null){
			for(RequestLog rl : requestLogList){
				System.out.println(JSONObject.toJSON(rl).toString());
			}
			
		}
		
		this.requestLogWriteMapper.insertSelective(requestLog);
		System.out.println("add request log success !!!");
	}
	
	/**
	 * 查询系统日志
	 * @param requestLog
	 * @return
	 */
	public List<RequestLog> queryRequestLogByRequestLog(RequestLog requestLog){
		
		List<RequestLog> requestLogList = this.requestLogReadMapper.queryRequestLogByRequestLog(requestLog);
		if(requestLogList == null){
			requestLogList = new ArrayList<RequestLog>();
		}
		
		return requestLogList;
	}
}
