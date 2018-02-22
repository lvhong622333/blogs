package com.lvhong.shiro;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import com.lvhong.pojo.User;
import com.lvhong.service.UserService;

public class AuthRealm extends AuthorizingRealm{
	@Resource
	UserService userService;
	/**
	 * 用于权限的控制
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//得到用户对象
		//Subject subject = SecurityUtils.getSubject();
		//String username = subject.getSession().getAttribute("username").toString();
		//根据用户名查询角色信息 		
		List<String> roleList = new ArrayList<String>();
		roleList.add("货运管理");
		roleList.add("基础信息");
		roleList.add("系统管理");
		//创建授权管理
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//传入授权管理的集合信息
		info.addStringPermissions(roleList);
		return info;
	}
    
	/**
	 * 用于用于登入信息认证
	 */
	@Override
	//登陆认证模块
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken loginToken =  (UsernamePasswordToken) token;
		String username = loginToken.getUsername();
	    User user = userService.queryUserByUserName(username);
		AuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getUserName(),this.getName());
		return info;
	}
	
}
