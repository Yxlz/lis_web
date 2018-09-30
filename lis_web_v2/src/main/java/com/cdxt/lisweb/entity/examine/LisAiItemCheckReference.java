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
@Table(name="LIS_AI_ITEM_CHECK_REF")
@NamedQuery(name="LisAiItemCheckReference.findAll", query="SELECT l FROM LisAiItemCheckReference l")
public class LisAiItemCheckReference implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	@Column(name="SPECIAL_ITEM")
	private String specialItem;
	
	@Column(name="ITEM_DEV_ID")
	private String itemDevId;
	
	@Column(name="SAMPLE_NAME")
	private String sampleName;
	
	@Column(name="SEX")
	private String sex;
	
	@Column(name="AGE_L")
	private String ageL;
	
	@Column(name="AGE_H")
	private String ageH;
	
	@Column(name="LIMIT_REFERENCE_L")
	private String limitReferenceL;
	
	@Column(name="LIMIT_REFERENCE_H")
	private String limitReferenceH;
	
	@Column(name="CHECK_L")
	private String checkL;
	
	@Column(name="CHECK_H")
	private String checkH;
	
	@Column(name="IS_CV")
	private String isCv;

	@Column(name="RANGE_IS_OPEN")
	private String rangeIsOpen;
	
	@Column(name="CV_IS_OPEN")
	private String cvIsOpen;
	
	@Column(name="ADOPT_IS_OPEN")
	private String adoptIsOpen;
	
	@Column(name="SITEM_IS_OPEN")
	private String sitemIsOpen;

	@Column(name="TYPE_ID")
	private String typeId;
	
	@Column(name="TYPE_MARK")
	private String typeMark;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSampleName() {
		return sampleName;
	}

	public void setSampleName(String sampleName) {
		this.sampleName = sampleName;
	}

	public String getItemDevId() {
		return itemDevId;
	}

	public void setItemDevId(String itemDevId) {
		this.itemDevId = itemDevId;
	}

	public String getSpecialItem() {
		return specialItem;
	}

	public void setSpecialItem(String specialItem) {
		this.specialItem = specialItem;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAgeL() {
		return ageL;
	}

	public void setAgeL(String ageL) {
		this.ageL = ageL;
	}

	public String getAgeH() {
		return ageH;
	}

	public void setAgeH(String ageH) {
		this.ageH = ageH;
	}

	public String getLimitReferenceL() {
		return limitReferenceL;
	}

	public void setLimitReferenceL(String limitReferenceL) {
		this.limitReferenceL = limitReferenceL;
	}

	public String getLimitReferenceH() {
		return limitReferenceH;
	}

	public void setLimitReferenceH(String limitReferenceH) {
		this.limitReferenceH = limitReferenceH;
	}

	public String getCheckL() {
		return checkL;
	}

	public void setCheckL(String checkL) {
		this.checkL = checkL;
	}

	public String getCheckH() {
		return checkH;
	}

	public void setCheckH(String checkH) {
		this.checkH = checkH;
	}

	public String getIsCv() {
		return isCv;
	}

	public void setIsCv(String isCv) {
		this.isCv = isCv;
	}

	public String getRangeIsOpen() {
		return rangeIsOpen;
	}

	public void setRangeIsOpen(String rangeIsOpen) {
		this.rangeIsOpen = rangeIsOpen;
	}

	public String getCvIsOpen() {
		return cvIsOpen;
	}

	public void setCvIsOpen(String cvIsOpen) {
		this.cvIsOpen = cvIsOpen;
	}

	public String getAdoptIsOpen() {
		return adoptIsOpen;
	}

	public void setAdoptIsOpen(String adoptIsOpen) {
		this.adoptIsOpen = adoptIsOpen;
	}

	public String getSitemIsOpen() {
		return sitemIsOpen;
	}

	public void setSitemIsOpen(String sitemIsOpen) {
		this.sitemIsOpen = sitemIsOpen;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getTypeMark() {
		return typeMark;
	}

	public void setTypeMark(String typeMark) {
		this.typeMark = typeMark;
	}

	public LisAiItemCheckReference(String id, String specialItem, String itemDevId, String sampleName, String sex,
			String ageL, String ageH, String limitReferenceL, String limitReferenceH, String checkL, String checkH,
			String isCv, String rangeIsOpen, String cvIsOpen, String adoptIsOpen, String sitemIsOpen, String typeId,
			String typeMark) {
		super();
		this.id = id;
		this.specialItem = specialItem;
		this.itemDevId = itemDevId;
		this.sampleName = sampleName;
		this.sex = sex;
		this.ageL = ageL;
		this.ageH = ageH;
		this.limitReferenceL = limitReferenceL;
		this.limitReferenceH = limitReferenceH;
		this.checkL = checkL;
		this.checkH = checkH;
		this.isCv = isCv;
		this.rangeIsOpen = rangeIsOpen;
		this.cvIsOpen = cvIsOpen;
		this.adoptIsOpen = adoptIsOpen;
		this.sitemIsOpen = sitemIsOpen;
		this.typeId = typeId;
		this.typeMark = typeMark;
	}

	public LisAiItemCheckReference() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
