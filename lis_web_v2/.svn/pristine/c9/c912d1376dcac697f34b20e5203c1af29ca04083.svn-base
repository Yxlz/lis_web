package com.cdxt.lisweb.security;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;

import com.cdxt.lisweb.constants.CommonConstants;
import com.cdxt.lisweb.entity.user.LisInspecRole;
import com.cdxt.lisweb.entity.user.LisInspecUser;
import com.cdxt.lisweb.entity.user.Right;
import com.cdxt.lisweb.service.user.LisInspecRoleService;
import com.cdxt.lisweb.service.user.LisInspecUserService;
import com.cdxt.lisweb.service.user.RightService;

public class ShiroRealm extends AuthorizingRealm {

	@Resource
	private RightService rightService;
	
	@Resource
	private LisInspecRoleService roleService;
	
	@Resource
	private LisInspecUserService userService;
	
	  
	 
	/**
	 * @Title: doGetAuthorizationInfo
	 * @Description: 授权
	 * @最后修改人：hezheng
	 * @最后修改时间：2017-4-24 下午3:01:33
	 * @param pc
	 * @return 对方法的参数进行描述
	 * @throws
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		String username = (String) pc.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		try {
			LisInspecUser user = userService.getUserByAccount(username);
		   LisInspecRole role = user.getLisInspecRole();
		   List<Right> rightList = rightService.getRightsByAccount(username);

			// 角色名的集合
			Set<String> roles = new HashSet<String>();
			// 权限名的集合
			Set<String> permissions = new HashSet<String>();
			roles.add(role.getRoleName());
			
			for(Right right: rightList){
				permissions.add(right.getRolePinyin() + ":" + right.getPinyin());
			}

			authorizationInfo.addRoles(roles);
			authorizationInfo.addStringPermissions(permissions);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return authorizationInfo;
	}

	/**
	 * @Title: doGetAuthenticationInfo
	 * @Description: 登录
	 * @最后修改人：hezheng
	 * @最后修改时间：2017-4-24 下午3:01:46
	 * @param at
	 * @return
	 * @throws AuthenticationException
	 *             对方法的参数进行描述
	 * @throws
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken at)
			throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) at;
		// 通过表单接收的用户名
		String account = token.getUsername();
		String password = String.valueOf(token.getPassword());
		if (!StringUtils.isEmpty(account)) {
			LisInspecUser user = null;
			try {
				user = userService.getUserByAccount(account);
			} catch (Exception e) {
				e.printStackTrace();
				throw new AuthenticationException("系统错误，登录失败！");
			}
			if (user == null) {
			   throw new AuthenticationException("用户名不存在！");
			}
			if (!user.getPassword().equals(password)) {
				throw new AuthenticationException("密码错误！");
			}
			Subject currentUser = SecurityUtils.getSubject(); 
			Session session = currentUser.getSession();
			session.setAttribute(CommonConstants.SHIRO_USER, user);
			return new SimpleAuthenticationInfo(account,
					password, getName());
		}

		return null;
	}
	
	/**
	* 权限被修改时，手动修改缓存信息
	* @Title: removeUserAuthorizationInfoCache 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @最后修改人：hezheng
	* @最后修改时间：2017-5-2 下午3:15:44
	* @param username 对方法的参数进行描述
	* @return void 返回类型
	* @throws
	 */
	public void removeUserAuthorizationInfoCache(String username) {  
	    SimplePrincipalCollection pc = new SimplePrincipalCollection();  
	    pc.add(username, super.getName());  
	    super.clearCachedAuthorizationInfo(pc);  
	}  

}
