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
 * @description: 用于存储LIS_AI_ITEM_DEV_LO对象
 */
@Entity
@Table(name="LIS_AI_ITEM_DEV_LO")
@NamedQuery(name="LisAiItemDevLO.findAll", query="SELECT l FROM LisAiItemDevLO l")
public class LisAiItemDevLO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	@Column(name="ITEM_DEV_ID")
	private String itemDevId;
	
	@Column(name="LOGICAL_OPERATOR")
	private String logicalOperator;
	
	@Column(name="LOGICAL_OPERATION_TYPE")
	private String logicalOperationType;
	
	@Column(name="TYPE_MARK")
	private String typeMark;
	
	@Column(name="TYPE_ID")
	private String typeId;
	
	@Column(name="IS_OPNE_LO")
	private String isOpenLO;
	
	@Column(name="IS_OPEN_LOT")
	private String isOpenLOT;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItemDevId() {
		return itemDevId;
	}

	public void setItemDevId(String itemDevId) {
		this.itemDevId = itemDevId;
	}

	public String getLogicalOperator() {
		return logicalOperator;
	}

	public void setLogicalOperator(String logicalOperator) {
		this.logicalOperator = logicalOperator;
	}

	public String getLogicalOperationType() {
		return logicalOperationType;
	}

	public void setLogicalOperationType(String logicalOperationType) {
		this.logicalOperationType = logicalOperationType;
	}

	public String getTypeMark() {
		return typeMark;
	}

	public void setTypeMark(String typeMark) {
		this.typeMark = typeMark;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getIsOpenLO() {
		return isOpenLO;
	}

	public void setIsOpenLO(String isOpenLO) {
		this.isOpenLO = isOpenLO;
	}

	public String getIsOpenLOT() {
		return isOpenLOT;
	}

	public void setIsOpenLOT(String isOpenLOT) {
		this.isOpenLOT = isOpenLOT;
	}

	public LisAiItemDevLO(String id, String itemDevId, String logicalOperator, String logicalOperationType,
			String typeMark, String typeId, String isOpenLO, String isOpenLOT) {
		super();
		this.id = id;
		this.itemDevId = itemDevId;
		this.logicalOperator = logicalOperator;
		this.logicalOperationType = logicalOperationType;
		this.typeMark = typeMark;
		this.typeId = typeId;
		this.isOpenLO = isOpenLO;
		this.isOpenLOT = isOpenLOT;
	}

	public LisAiItemDevLO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
