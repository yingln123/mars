package com.ning.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	
	public void addUser(String name, String password){
		
		System.out.println(name + " -- " + password);
	}
}
