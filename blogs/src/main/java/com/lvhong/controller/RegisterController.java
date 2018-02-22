package com.lvhong.controller;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lvhong.pojo.User;
import com.lvhong.service.UserService;
import com.lvhong.util.MD5Utils;

@Controller
@RequestMapping("/blogs")
public class RegisterController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/registerA")
	public String register() {
		return "/register";
	}
	
	@RequestMapping("/register")
	public String register(@ModelAttribute User user,String verificationCode,HttpSession session,Model model) {
			//提前验证用户是否存在
			Map<String,String> map = new HashMap<String,String>();
			map.put("telephone", user.getTelephone());
			map.put("name", user.getUserName());
			User use = userService.findUserByphone(map);
			if(use != null) {
				model.addAttribute("info","用户名或者手机号码已注册");
				return "/register";
			}
			String  verificationCodeOld = (String) session.getAttribute("verificationCode");
			if(verificationCodeOld.equals(verificationCode)) {
				//密码加密
				String passwordNew = MD5Utils.encrypt(user.getUserName(), user.getPassword(), 3);
				user.setPassword(passwordNew);
				userService.addUser(user);
				return "/login";
			}else {
				model.addAttribute("imageVeri","验证码错误");
				return "/register";
			}
	}
	
	@RequestMapping("/checkName")
	@ResponseBody
	public String checkName(String name) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("name", name);
		User user = userService.findUserByphone(map);
		if(user != null) {
			return "用户名已经被注册了";
		}
		return null;
	}
	
	@RequestMapping("/checkphone")
	@ResponseBody
	public String checkphone(String telephone) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("telephone", telephone);
		User user = userService.findUserByphone(map);
		if(user != null) {
			return "手机号码已经被注册了";
		}
		return null;
	}
}
