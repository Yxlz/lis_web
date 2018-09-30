package com.cdxt.lisweb.entity.examine;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author : liushijun
 * @date 创建时间：2018年7月13日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: 用于存储LIS_AI_ITME_DEV_HIST_TYPE对象
 */
@Entity
@Table(name="LIS_AI_ITEM_DEV_HIST_TYPE")
@NamedQuery(name="LisAiItemDevHistType.findAll", query="SELECT l FROM LisAiItemDevHistType l")
public class LisAiItemDevHistType implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	@Column(name="TYPE_NAME")
	private String typeName;
	
	@Column(name="REMARK")
	private String remark;
	
	@Column(name="GROUP_ID")
	private String groupId;

	@Column(name="IS_OPEN")
	private String isOpen;
	
	@Column(name="IS_DELETE")
	private String isDelete;
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTypeName() {
		return typeName;
	}


	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getGroupId() {
		return groupId;
	}


	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}


	public String getIsOpen() {
		return isOpen;
	}


	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}

	public String getIsDelete() {
		return isDelete;
	}


	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public LisAiItemDevHistType(String id, String typeName, String remark, String groupId, String isOpen,
			String isDelete) {
		super();
		this.id = id;
		this.typeName = typeName;
		this.remark = remark;
		this.groupId = groupId;
		this.isOpen = isOpen;
		this.isDelete = isDelete;
	}


	public LisAiItemDevHistType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
