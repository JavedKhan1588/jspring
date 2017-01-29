package com.espire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.espire.service.LoginService;

@Controller
@SessionAttributes("username")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLogin(@RequestParam String username, @RequestParam String password, ModelMap model) {
		if (!loginService.validateUser(username, password)) {
			model.put("error", "Invalid Credentials");
			return "login";
		}
		model.put("username", username);
		model.put("password", password);
		return "welcome";
	}
}