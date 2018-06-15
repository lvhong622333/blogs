package com.lvhong.service.impl;

import org.springframework.stereotype.Service;

import com.lvhong.service.DubboService;

@Service("dubboService")
public class DubboServiceImpl implements DubboService {
	
	public String sayHelloWorld() {
		return "你好，我是dubbo接口提供者";
	}
}
