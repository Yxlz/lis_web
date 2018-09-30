package com.cdxt.lisweb.entity.user;

import java.util.Set;

/**
 * 角色权限表
 * 
 * @author hezheng
 */
//@Entity
//@Table(name = "LIS_K0001_WORK_JSQX_T")
public class RoleRight {
	
	private Set<Right> rights;
	public RoleRight(){}
	
	public Set<Right> getRights() {
		return rights;
	}
	public void setRights(Set<Right> rights) {
		this.rights = rights;
	}
}
