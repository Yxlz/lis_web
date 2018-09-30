package com.cdxt.lisweb.entity.barcode;

import java.io.Serializable;

import javax.persistence.*;

import com.cdxt.lisweb.entity.inspec.LisInspecContainer;
import com.cdxt.lisweb.entity.inspec.LisRequestionItem;
import com.cdxt.lisweb.model.barcode.Rule;

import java.math.BigDecimal;


/**
 * The persistent class for the LIS_WEB_BCRULE_SINGLEITEM database table.
 * 单项目条码规则表
 */
@Entity
@Table(name="LIS_WEB_BCRULE_SINGLEITEM")
@NamedQuery(name="LisWebBcruleSingleitem.findAll", query="SELECT l FROM LisWebBcruleSingleitem l")
public class LisWebBcruleSingleitem extends Rule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="\"ENABLE\"")
	private BigDecimal enable;

	@Column(name="USE_NUMBER")
	private BigDecimal useNumber;

	//bi-directional many-to-one association to LisInspecContainer
	@ManyToOne
	@JoinColumn(name="SPECIMEN_CODE")
	private LisInspecContainer lisInspecContainer;
	
	@ManyToOne
	@JoinColumn(name="ITEM_CODE")
	private LisRequestionItem lisRequestionItem;

	public LisWebBcruleSingleitem() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getEnable() {
		return this.enable;
	}

	public void setEnable(BigDecimal enable) {
		this.enable = enable;
	}

	public BigDecimal getUseNumber() {
		return this.useNumber;
	}

	public void setUseNumber(BigDecimal useNumber) {
		this.useNumber = useNumber;
	}

	public LisInspecContainer getLisInspecContainer() {
		return this.lisInspecContainer;
	}

	public void setLisInspecContainer(LisInspecContainer lisInspecContainer) {
		this.lisInspecContainer = lisInspecContainer;
	}

	public LisRequestionItem getLisRequestionItem() {
		return lisRequestionItem;
	}

	public void setLisRequestionItem(LisRequestionItem lisRequestionItem) {
		this.lisRequestionItem = lisRequestionItem;
	}

	
}