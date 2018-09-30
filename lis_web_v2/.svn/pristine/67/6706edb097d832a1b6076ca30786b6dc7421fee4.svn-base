package com.cdxt.lisweb.dao.user;

import java.math.BigDecimal;
import java.util.List;

import com.cdxt.lisweb.dao.BaseDao;
import com.cdxt.lisweb.entity.user.LisInspecRole;
import com.cdxt.lisweb.entity.user.Right;

/**
 * @author : Tangxiaohui 
 * @date 创建时间：2018年1月3日 上午9:29:21
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
public interface LisInspecRoleDao extends BaseDao<LisInspecRole> {

	

	/**
	 * 根据角色ID获取权限
	 * @param roleId
	 * @return
	 */
	List<Right> queryRoleRights(String roleId,String parentCode);

	/**
	 * 删除角色全部权限
	 * @param roleId
	 */
	void deleteRoleRights(String roleId);

	/**
	 * 删除部分角色权限
	 * @param roleId
	 */
	void deleteRoleRights(String roleId,String rightId);
	
	/**
	 * 保存角色权限
	 * @param roleId
	 * @param rightId
	 */
	void saveRoleRight(String roleId, String rightId);
	/**
	 * 判断指定的角色权限是否存在
	 * @return
	 */
	BigDecimal checkJSQXIfExist(String roleId, String rightId);

}
