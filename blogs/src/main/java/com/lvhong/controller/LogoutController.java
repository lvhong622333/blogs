package com.lvhong.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blogs")
public class LogoutController {
	@RequestMapping("/logout")
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		if(subject.isAuthenticated()) {			
			subject.logout();
		}
		return "/login";
	}
}
