package com.cdxt.lisweb.entity.barcode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.cdxt.lisweb.model.barcode.Rule;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the LIS_WEB_BARCODE_RULE database table.
 * 条码合并规则表
 */
@Entity
@Table(name="LIS_WEB_BARCODE_RULE")
@NamedQuery(name="LisWebBarcodeRule.findAll", query="SELECT l FROM LisWebBarcodeRule l")
public class LisWebBarcodeRule extends Rule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="BARCODE_NUM")
	private BigDecimal barcodeNum;

	private String condition;

	@Column(name="INSEPCTION_CATEGORY")
	private String insepctionCategory;

	private String para;

	@Column(name="PRIN_NUM")
	private BigDecimal prinNum;

	private BigDecimal priority;

	@Column(name="RULE_NAME")
	private String ruleName;

	//bi-directional many-to-one association to LisWebBcruleContainer
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy="lisWebBarcodeRule")
	@JsonIgnore
	@Where(clause = "enable=1")
	private List<LisWebBcruleContainer> lisWebBcruleContainers;

	//bi-directional many-to-one association to LisWebBcruleItem
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy="lisWebBarcodeRule")
	@JsonIgnore
	private List<LisWebBcruleItem> lisWebBcruleItems;

	public LisWebBarcodeRule() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getBarcodeNum() {
		return this.barcodeNum;
	}

	public void setBarcodeNum(BigDecimal barcodeNum) {
		this.barcodeNum = barcodeNum;
	}

	public String getCondition() {
		return this.condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getInsepctionCategory() {
		return this.insepctionCategory;
	}

	public void setInsepctionCategory(String insepctionCategory) {
		this.insepctionCategory = insepctionCategory;
	}

	public String getPara() {
		return this.para;
	}

	public void setPara(String para) {
		this.para = para;
	}

	public BigDecimal getPrinNum() {
		return this.prinNum;
	}

	public void setPrinNum(BigDecimal prinNum) {
		this.prinNum = prinNum;
	}

	public BigDecimal getPriority() {
		return this.priority;
	}

	public void setPriority(BigDecimal priority) {
		this.priority = priority;
	}

	public String getRuleName() {
		return this.ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public List<LisWebBcruleContainer> getLisWebBcruleContainers() {
		return lisWebBcruleContainers;
	}

	public void setLisWebBcruleContainers(
			List<LisWebBcruleContainer> lisWebBcruleContainers) {
		this.lisWebBcruleContainers = lisWebBcruleContainers;
	}

	public List<LisWebBcruleItem> getLisWebBcruleItems() {
		return lisWebBcruleItems;
	}

	public void setLisWebBcruleItems(List<LisWebBcruleItem> lisWebBcruleItems) {
		this.lisWebBcruleItems = lisWebBcruleItems;
	}


}