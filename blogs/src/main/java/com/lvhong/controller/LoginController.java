package com.lvhong.controller;

import javax.annotation.Resource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.lvhong.pojo.User;
import com.lvhong.service.UserService;

@Controller
@RequestMapping("/blogs")
public class LoginController {
	
	@Resource
	UserService userService;
	
	@RequestMapping("/loginA")
	public String login() {
		return "/login";
	}
	
	@RequestMapping("/login")
	public String login(String userName ,String password,String rememberMe,Model model) {
		if(userName == null || "".equals(userName)) {
			model.addAttribute("message", "用户名不能为空！");
            return "/login";
		}
		if(password == null || "".equals(password)) {
			model.addAttribute("message", "密码不能为空！");
            return "/login";
		}
		
		Subject subject = SecurityUtils.getSubject(); // 获取Subject单例对象
		if(!subject.isAuthenticated()) {			
			UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
			if("1".equals(rememberMe)) {			
				token.setRememberMe(true);
			}else {
				token.setRememberMe(false);
			}
			try {
				subject.login(token);		
			}catch(AuthenticationException e) {
				e.printStackTrace();
				model.addAttribute("message", "用户名或密码不正确！");
				return "/login";
			}
		}
		User user = userService.queryUserByUserName(userName);
		subject.getSession().setAttribute("user", user);
		return "/views/pages/homePage";
	}
}
