package com.lvhong.controller;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lvhong.pojo.User;
import com.lvhong.service.UserService;
import com.lvhong.util.MD5Utils;

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
		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
		Subject subject = SecurityUtils.getSubject(); // 获取Subject单例对象
		try {
			subject.login(token);		
		} catch (IncorrectCredentialsException ice) {
            // 捕获密码错误异常
			model.addAttribute("message", "password error!");
            return "/login";
        } catch (UnknownAccountException uae) {
            // 捕获未知用户名异常
        		model.addAttribute("message", "username error!");
            return "/login";
        } catch (ExcessiveAttemptsException eae) {
            // 捕获错误登录过多的异常
        		model.addAttribute("message", "times error");
            return "/login";
        }
		User user = userService.queryUserByUserName(userName);
		subject.getSession().setAttribute("user", user);
		return "/views/pages/homePage";
	}
}
