package com.cheery.abadatacollector.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {
	
	@GetMapping("/say-hello")
	@ResponseBody
	public String sayHello() {
		return "Say Hello!";
	}
	
	@GetMapping("/")
	public String gotoWelcomePage( ModelMap model) {
		model.put("name", getLoggedinUsername());
		return "welcome";
	}
	
	
	
	private String getLoggedinUsername() {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
