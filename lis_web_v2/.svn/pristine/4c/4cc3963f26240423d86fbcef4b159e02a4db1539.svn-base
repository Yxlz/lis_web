package com.cdxt.lisweb.service.user;

import java.util.List;

import com.cdxt.lisweb.entity.user.LisInspecRole;
import com.cdxt.lisweb.entity.user.Right;
import com.cdxt.lisweb.model.tree.TreeViewNode;
import com.cdxt.lisweb.service.BaseService;

/**
 * @author : Tangxiaohui 
 * @date 创建时间：2018年1月3日 上午9:48:36
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
public interface LisInspecRoleService extends BaseService<LisInspecRole> {

	

	/**
	 * 根据角色id获取权限
	 * @param roleId
	 * @return
	 */
	List<Right> getRoleRights(String roleId,String parentCode);

	/**
	 * 保存角色权限
	 * @param roleId
	 * @param rts
	 */
	void saveRoleRights(String roleId, String[] rts);
	
	/**
	 * 删除角色部分权限
	 * @param roleId
	 * @param rts
	 */
	void deleteRoleRight(String roleId, String[] rightId );
	
    
    /**
     * 角色对应的权限转换成页面需要的tree数据结构
     * @param rts 权限LIST
     * @param roleId 角色id
     * @return
     */
    List<TreeViewNode> roleRightsToTreeViewNode(List<Right> rts,String roleId);

}
