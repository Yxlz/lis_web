package com.cdxt.lisweb.entity.examine;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author : liushijun
 * @date 创建时间：2018年8月07日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: 用于存储LIS_AI_ITEM_DEV_LO_TYPE对象
 */
@Entity
@Table(name="LIS_AI_ITEM_DEV_LO_TYPE")
@NamedQuery(name="LisAiItemDevLOType.findAll", query="SELECT l FROM LisAiItemDevLOType l")
public class LisAiItemDevLOType implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	@Column(name="GROUP_ID")
	private String groupId;
	
	@Column(name="TYPE_NAME")
	private String typeName;
	
	@Column(name="IS_OPEN")
	private String isOpenTypeLO;
	
	@Column(name="REMARK")
	private String remarkTypeLO;

	@Column(name="IS_DELETE")
	private String isDelete;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getIsOpenTypeLO() {
		return isOpenTypeLO;
	}

	public void setIsOpenTypeLO(String isOpenTypeLO) {
		this.isOpenTypeLO = isOpenTypeLO;
	}

	public String getRemarkTypeLO() {
		return remarkTypeLO;
	}

	public void setRemarkTypeLO(String remarkTypeLO) {
		this.remarkTypeLO = remarkTypeLO;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public LisAiItemDevLOType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LisAiItemDevLOType(String id, String groupId, String typeName, String isOpenTypeLO, String remarkTypeLO,
			String isDelete) {
		super();
		this.id = id;
		this.groupId = groupId;
		this.typeName = typeName;
		this.isOpenTypeLO = isOpenTypeLO;
		this.remarkTypeLO = remarkTypeLO;
		this.isDelete = isDelete;
	}
	
}
