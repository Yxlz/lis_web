package com.cdxt.lisweb.service.user.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.cdxt.lisweb.dao.BaseDao;
import com.cdxt.lisweb.dao.user.RightDao;
import com.cdxt.lisweb.entity.user.Right;
import com.cdxt.lisweb.model.right.RightNode;
import com.cdxt.lisweb.model.tree.MenuModel;
import com.cdxt.lisweb.model.tree.TreeViewNode;
import com.cdxt.lisweb.service.BaseServiceImpl;
import com.cdxt.lisweb.service.user.RightService;

/**
 * @author : Tangxiaohui
 * @date 创建时间：2018年1月3日 上午9:42:37
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: //TODO
 */
@Service
public class RightServiceImpl extends BaseServiceImpl<Right> implements
		RightService {

	@Autowired
	private RightDao rightDao;

	@Override
	public List<Right> getRightList(String parentId) {
		return rightDao.getRightList(parentId);
	}

	@Override
	public List<Right> getRightList(String user, String parentId) {
		// 默认加载第一级节点
		if (org.apache.commons.lang.StringUtils.isEmpty(parentId))
			parentId = "0";
		return rightDao.getRightList(user, parentId);
	}

	@Override
	public BaseDao<Right> getDao() {
		return rightDao;
	}

	@Override
	public List<RightNode> rightsToTree(List<Right> rts) {
		List<RightNode> tree = new ArrayList<RightNode>();
		for (Right r : rts) {
			RightNode n = new RightNode(r.getRightCode(), r.getRightName());
			if (tree.contains(n)) {
				continue;
			}

			n.setrId(r.getId());
			n.setParentCode(r.getParentCode());
			n.setIcon(r.getIcon());
			n.setLeafNum(r.getLeafNum());
			n.setPinyin(r.getPinyin());
			n.setRemark(r.getRemark());
			n.setRightName(r.getRightName());
			n.setUrl(r.getUrl());
			n.setSortNo(r.getSortNo());

			RightNode parent = findParent(tree, r);
			if (parent == null) {
				tree.add(n);
			} else {
				parent.addChild(n);
				parent.setLeaf(false);
			}
		}

		return tree;
	}

	/**
	 * 查找父节点
	 * 
	 * @param tree
	 * @param child
	 * @return
	 */
	private RightNode findParent(List<RightNode> tree, Right child) {
		String prtCode = child.getParentCode();
		if (!StringUtils.hasText(prtCode)) {
			return null;
		} else {
			for (RightNode n : tree) {
				if (prtCode.equals(n.getId())) {
					return n;
				} else {
					if (n.getChildren().size() > 0) {
						RightNode find = findParent(n.getChildren(), child);
						if (find != null) {
							return find;
						}
					}
				}
			}
		}

		return null;
	}

	/**
	 * 查找所有父节点
	 * 
	 * @return
	 */
	@Override
	public List<Right> findAllParentNode() {
		return rightDao.findAllParentNode();
	}

	@Override
	public int findMaxRightId(String parentCode) {
		return rightDao.findMaxRightId(parentCode);
	}

	@Override
	public List<Right> getRightByCode(String rightCode) {
		return rightDao.getRightByCode(rightCode);
	}

	@Override
	@Transactional
	public void deleteByRightId(String rightId) {
		// 删除子节点
		rightDao.deleteByParentId(rightId);

	}

	@Override
	@Transactional
	public List<Right> getRightsByAccount(String account) {
		return rightDao.getRightsByAccount(account);
	}

	@Override
	public List<TreeViewNode> rightsToTreeViewNode(List<Right> rts, String user) {
		List<TreeViewNode> nodeList = new ArrayList<TreeViewNode>();
		if (user == null) {// 如果user为空 查询所有菜单
			for (Right right : rts) {
				TreeViewNode node = new TreeViewNode();
				node.setText(right.getRightName());
				node.setIcon(right.getIcon());
				node.setHref(right.getUrl());
				node.setId(right.getId());
				node.setRightCode(right.getRightCode());
				node.setParentCode(right.getParentCode());
				node.setPinyin(right.getPinyin());
				node.setReporturl(right.getReporturl());
				List<Right> sonRights = this.getRightList(right.getRightCode());
				node.setNodes(rightsToTreeViewNode(sonRights, null));
				nodeList.add(node);
			}
		} else {
			for (Right right : rts) {// User不为空 查询对应权限的菜单
				TreeViewNode node = new TreeViewNode();
				node.setText(right.getRightName());
				node.setIcon(right.getIcon());
				node.setHref(right.getUrl());
				node.setId(right.getId());
				node.setRightCode(right.getRightCode());
				node.setParentCode(right.getParentCode());
				node.setPinyin(right.getPinyin());
				node.setReporturl(right.getReporturl());
				System.out.println(right.getReporturl());
				List<Right> sonRights = this.getRightList(user,
						right.getRightCode());
				node.setNodes(rightsToTreeViewNode(sonRights, user));
				nodeList.add(node);
			}
		}
		return nodeList;
	}

	@Override
	public List<MenuModel> rightsToMenu(List<Right> rts, String user) {
		List<MenuModel> list = new ArrayList<MenuModel>();
		for (Right right : rts) {
			MenuModel model = new MenuModel();
			model.setId(right.getRightCode());
			model.setName(right.getText());
			model.setUrl(right.getUrl());
			List<Right> sonRights = this.getRightList(user,right.getRightCode());
			model.setNodes(rightsToMenu(sonRights,user));
			list.add(model);
		}
		return list;
	}

	@Override
	public List<TreeViewNode> makeDifferentTree(List<TreeViewNode> alltree, List<Right> roleRightList) {
		List<TreeViewNode> result = new ArrayList<TreeViewNode>();
		for (int i = 0; i < roleRightList.size(); i++) {
			String id = roleRightList.get(i).getId();
			result = reduceTree(alltree, id);
		}
		return result;
	}
	/**
	 * 判断两个节点是否相等
	 * @return
	 */
	private boolean checkEquals(String id ,TreeViewNode node) {
		if (id.equals(node.getId())) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 剪掉权限树中与用户已分配权限重复的子节点
	 * @return
	 */
	private List<TreeViewNode> reduceTree(List<TreeViewNode> list,String id){
		for (int i = 0 ;i<list.size();i++) {
			if (list.get(i).getNodes().size()!=0) {
				reduceTree(list.get(i).getNodes(),id);
			} else {
				if (checkEquals(id,list.get(i))) {
					list.remove(list.get(i));
				} 
			}
		}
		return list;
	}
	@Override
	public List<Right> findLeafNodeByRoleid(String roleid) {
		
		return rightDao.findLeafNodeByRoleid(roleid);
	}
}