package com.cdxt.lisweb.entity.examine;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author : liushijun
 * @date 创建时间：2018年7月3日 
 * @version 1.0
 * @company :成都信通网易科技发展有限公司
 * @description: 用于存储LIS_AI_ITEM_CHECK_REF对象
 */
@Entity
@Table(name="LIS_AI_ITEM_DEV_HIST")
@NamedQuery(name="LisAiItemDevHist.findAll", query="SELECT l FROM LisAiItemDevHist l")
public class LisAiItemDevHist implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	@Column(name="ITEM_DEV_ID")
	private String itemDevId;
	
	@Column(name="PER")
	private String percentage;
	
	@Column(name="HIS_DAY")
	private String historyDay;
	
	@Column(name="ABS")
	private String abs;
	
	@Column(name="PERCENT_IS_OPNE")
	private String percentIsOpen;
	
	@Column(name="ABSOLUTE_IS_OPEN")
	private String absoluteIsOpen;
	
	@Column(name="TYPE_MARK")
	private String typeMark;
	
	@Column(name="TYPE_ID")
	private String typeId;
	
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

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public String getHistoryDay() {
		return historyDay;
	}

	public void setHistoryDay(String historyDay) {
		this.historyDay = historyDay;
	}

	public String getAbs() {
		return abs;
	}

	public void setAbs(String abs) {
		this.abs = abs;
	}

	public String getPercentIsOpen() {
		return percentIsOpen;
	}

	public void setPercentIsOpen(String percentIsOpen) {
		this.percentIsOpen = percentIsOpen;
	}

	public String getAbsoluteIsOpen() {
		return absoluteIsOpen;
	}

	public void setAbsoluteIsOpen(String absoluteIsOpen) {
		this.absoluteIsOpen = absoluteIsOpen;
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

	public LisAiItemDevHist(String id, String itemDevId, String percentage, String historyDay, String abs,
			String percentIsOpen, String absoluteIsOpen, String typeMark, String typeId) {
		super();
		this.id = id;
		this.itemDevId = itemDevId;
		this.percentage = percentage;
		this.historyDay = historyDay;
		this.abs = abs;
		this.percentIsOpen = percentIsOpen;
		this.absoluteIsOpen = absoluteIsOpen;
		this.typeMark = typeMark;
		this.typeId = typeId;
	}

	public LisAiItemDevHist() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
