package com.ning.service;

import org.springframework.stereotype.Service;

import com.ning.entity.RequestLog;

@Service
public class RequestLogService {
	
	public void addRequestLog(RequestLog requestLog){
		System.out.println("add request log success !!!");
	}
}
