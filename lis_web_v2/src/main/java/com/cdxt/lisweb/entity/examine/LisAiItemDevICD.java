package com.cdxt.lisweb.entity.examine;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author : liushijun
 * @date 创建时间：2018年8月08日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: 用于存储LIS_AI_ITEM_DEV_ICD对象
 */
@Entity
@Table(name="LIS_AI_ITEM_DEV_ICD")
@NamedQuery(name="LisAiItemDevICD.findAll", query="SELECT l FROM LisAiItemDevICD l")
public class LisAiItemDevICD implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	@Column(name="ITEM_DEV_ID")
	private String itemDevId;
	
	@Column(name="CRUX")
	private String cRUX;
	
	@Column(name="CONTENT")
	private String content;
	
	@Column(name="ADOPT")
	private String adopt;
	
	@Column(name="LOGIC")
	private String logic;
	
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

	public String getcRUX() {
		return cRUX;
	}

	public void setcRUX(String cRUX) {
		this.cRUX = cRUX;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAdopt() {
		return adopt;
	}

	public void setAdopt(String adopt) {
		this.adopt = adopt;
	}

	public String getLogic() {
		return logic;
	}

	public void setLogic(String logic) {
		this.logic = logic;
	}

	public LisAiItemDevICD(String id, String itemDevId, String cRUX, String content, String adopt, String logic) {
		super();
		this.id = id;
		this.itemDevId = itemDevId;
		this.cRUX = cRUX;
		this.content = content;
		this.adopt = adopt;
		this.logic = logic;
	}

	public LisAiItemDevICD() {
		super();
		// TODO Auto-generated constructor stub
	}

}
