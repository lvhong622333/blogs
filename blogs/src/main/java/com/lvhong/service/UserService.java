package com.lvhong.service;

import java.util.Map;

import com.lvhong.pojo.User;

public interface UserService {

	User queryUserByUserName(String username);

	void addUser(User user);

	User findUserByphone(Map<String, String> map);

}
