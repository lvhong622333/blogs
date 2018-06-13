package com.lvhong.service.impl;

import com.lvhong.service.DubboService;

public class DubboServiceImpl implements DubboService {
	
	public String sayHelloWorld() {
		return "你好，我是dubbo接口提供者";
	}
}
