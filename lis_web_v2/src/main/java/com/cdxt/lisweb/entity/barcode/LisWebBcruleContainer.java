package com.cdxt.lisweb.entity.barcode;

import java.io.Serializable;

import javax.persistence.*;

import com.cdxt.lisweb.entity.inspec.LisInspecContainer;

import java.math.BigDecimal;


/**
 * The persistent class for the LIS_WEB_BCRULE_CONTAINER database table.
 * 
 */
@Entity
@Table(name="LIS_WEB_BCRULE_CONTAINER")
@NamedQuery(name="LisWebBcruleContainer.findAll", query="SELECT l FROM LisWebBcruleContainer l")
public class LisWebBcruleContainer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="\"ENABLE\"")
	private BigDecimal enable;

	@Column(name="USE_NUMBER")
	private String useNumber;

	//bi-directional many-to-one association to LisInspecContainer
	@ManyToOne
	@JoinColumn(name="CONTAINER_CODE")
	private LisInspecContainer lisInspecContainer;

	//bi-directional many-to-one association to LisWebBarcodeRule
	@ManyToOne
	@JoinColumn(name="BARCODE_RULE_ID")
	private LisWebBarcodeRule lisWebBarcodeRule;

	public LisWebBcruleContainer() {
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

	public String getUseNumber() {
		return this.useNumber;
	}

	public void setUseNumber(String useNumber) {
		this.useNumber = useNumber;
	}

	public LisInspecContainer getLisInspecContainer() {
		return this.lisInspecContainer;
	}

	public void setLisInspecContainer(LisInspecContainer lisInspecContainer) {
		this.lisInspecContainer = lisInspecContainer;
	}

	public LisWebBarcodeRule getLisWebBarcodeRule() {
		return this.lisWebBarcodeRule;
	}

	public void setLisWebBarcodeRule(LisWebBarcodeRule lisWebBarcodeRule) {
		this.lisWebBarcodeRule = lisWebBarcodeRule;
	}

}