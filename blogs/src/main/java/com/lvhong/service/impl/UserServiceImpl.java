package com.lvhong.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lvhong.dao.UserMapper;
import com.lvhong.pojo.User;
import com.lvhong.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource
	UserMapper userMapper;

	public User queryUserByUserName(String username) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("name", username);
		return userMapper.findUserByPhone(map);
	}

	public void addUser(User user) {
		userMapper.insertSelective(user);
	}

	public User findUserByphone(Map<String, String> map) {
		return userMapper.findUserByPhone(map);
	}

	
}
