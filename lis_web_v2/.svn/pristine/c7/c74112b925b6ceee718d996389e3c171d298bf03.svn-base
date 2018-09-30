package com.cdxt.lisweb.service.user.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdxt.lisweb.dao.BaseDao;
import com.cdxt.lisweb.dao.user.LisInspecRoleDao;
import com.cdxt.lisweb.entity.user.LisInspecRole;
import com.cdxt.lisweb.entity.user.Right;
import com.cdxt.lisweb.model.tree.TreeViewNode;
import com.cdxt.lisweb.service.BaseServiceImpl;
import com.cdxt.lisweb.service.user.LisInspecRoleService;

/**
 * @author : Tangxiaohui
 * @date 创建时间：2018年1月3日 上午9:49:23
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Service
public class LisInspecRoleServiceImpl extends BaseServiceImpl<LisInspecRole>
		implements LisInspecRoleService {

	@Autowired
	private LisInspecRoleDao lisInspecRoleDao;

	@Override
	public BaseDao<LisInspecRole> getDao() {
		return lisInspecRoleDao;
	}

	@Override
	public List<Right> getRoleRights(String roleId, String parentCode) {
		return lisInspecRoleDao.queryRoleRights(roleId, parentCode);
	}

	@Override
	@Transactional
	public void saveRoleRights(String roleId, String[] rts) {
		for (String rightId : rts) {
			BigDecimal i = lisInspecRoleDao.checkJSQXIfExist(roleId, rightId);
			int res = i.intValue();
			if (res==0) {
				lisInspecRoleDao.saveRoleRight(roleId, rightId);
			}
		}
	}

	@Override
	@Transactional
	public void save(LisInspecRole t) {
		lisInspecRoleDao.save(t);
	}

	@Override
	@Transactional
	public void delete(LisInspecRole t) {
		lisInspecRoleDao.deleteRoleRights(t.getId());
		lisInspecRoleDao.delete(t);
	}

	@Override
	@Transactional
	public void deleteRoleRight(String roleId, String[] rightId) {
		for (String id : rightId) {
			lisInspecRoleDao.deleteRoleRights(roleId, id);
		}

	}

	@Override
	public List<TreeViewNode> roleRightsToTreeViewNode(List<Right> rts,
			String roleId) {
		List<TreeViewNode> nodeList = new ArrayList<TreeViewNode>();
		for (Right right : rts) {
			TreeViewNode node = new TreeViewNode();
			node.setText(right.getRightName());
			node.setIcon(right.getIcon());
			node.setHref(right.getUrl());
			node.setId(right.getId());
			node.setRightCode(right.getRightCode());
			node.setParentCode(right.getParentCode());
			node.setPinyin(right.getPinyin());
			List<Right> sonRights = this.getRoleRights(roleId,
					right.getRightCode());
			node.setNodes(roleRightsToTreeViewNode(sonRights, roleId));
			nodeList.add(node);
		}
		return nodeList;
	}
}
