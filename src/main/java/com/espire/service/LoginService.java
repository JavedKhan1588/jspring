package com.espire.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	public boolean validateUser(String username, String password){
		return username.equalsIgnoreCase("javed") && password.equals("password"); 
	}

}
