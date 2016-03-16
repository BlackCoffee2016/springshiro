package com.kongzhong.gw2.springshiro.service;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyShiro extends AuthorizingRealm{
	/**
	 * 授予角色或权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String userName = (String) principals.getPrimaryPrincipal();//获取登录的用户名，从数据库中用户名查询出用户信息
		//以下是基于角色和资源来授权，两者任选一种，推荐使用基于资源
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		//基于角色
		Set<String> roleSet=new HashSet<String>();//角色集合，实际中要从数据库中查询
		roleSet.add("huiyuan");
		authorizationInfo.setRoles(roleSet);
		//基于资源(权限)
		Set<String> permissionStr = new HashSet<String>();//权限集合，实际中要从数据库中查询
		permissionStr.add("huiyuan:select");
		authorizationInfo.setStringPermissions(permissionStr);

		return authorizationInfo;
	}
	/**
	 * 身份认证（shiro内部帮助我们执行登录）,subject.login(token) 内部执行的方法
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName = (String) token.getPrincipal();//获取用户名,从数据库中用户名查询出用户信息。
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo("xxg","123","xx");//用户名和密码,real的名字，随时给
		return authenticationInfo;
	}

	

}
