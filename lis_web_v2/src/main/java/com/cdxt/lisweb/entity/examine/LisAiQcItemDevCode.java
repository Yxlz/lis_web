package com.cdxt.lisweb.entity.examine;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author : liushijun
 * @date 创建时间：2018年6月23日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: 用于存储LIS_AI_QC_ITEM_DEV_CODE对象
 */
@Entity
@Table(name="LIS_AI_QC_ITEM_DEV_CODE")
@NamedQuery(name="LisAiQcItemDevCode.findAll", query="SELECT l FROM LisAiQcItemDevCode l")
public class LisAiQcItemDevCode implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	@Column(name="IS_QC")
	private String isQc;
	
	@Column(name="QC_STATE")
	private String qcState;
	
	@Column(name="ADOPT")
	private String adopt;
	
	@Column(name="ITEM_DEV_ID")
	private String itemDevId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIsQc() {
		return isQc;
	}

	public void setIsQc(String isQc) {
		this.isQc = isQc;
	}

	public String getQcState() {
		return qcState;
	}

	public void setQcState(String qcState) {
		this.qcState = qcState;
	}

	public String getAdopt() {
		return adopt;
	}

	public void setAdopt(String adopt) {
		this.adopt = adopt;
	}

	public String getItemDevId() {
		return itemDevId;
	}

	public void setItemDevId(String itemDevId) {
		this.itemDevId = itemDevId;
	}

	public LisAiQcItemDevCode(String id, String isQc, String qcState, String adopt, String itemDevId) {
		super();
		this.id = id;
		this.isQc = isQc;
		this.qcState = qcState;
		this.adopt = adopt;
		this.itemDevId = itemDevId;
	}

	public LisAiQcItemDevCode() {
	
	}

	@Override
	public String toString() {
		return "LisAiQcItemDevCode [id=" + id + ", isQc=" + isQc + ","
				+ " qcState=" + qcState + ", adopt=" + adopt + ", itemDevId=" + itemDevId + "]";
	}

	


}
