package com.cdxt.lisweb.entity.barcode;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.cdxt.lisweb.entity.inspec.LisRequestionItem;



/**
 * The persistent class for the LIS_WEB_BCRULE_ITEM database table.
 * 
 */
@Entity
@Table(name = "LIS_WEB_BCRULE_ITEM")
@NamedQuery(name = "LisWebBcruleItem.findAll", query = "SELECT l FROM LisWebBcruleItem l")
public class LisWebBcruleItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@ManyToOne
	@JoinColumn(name = "ITEM_CODE")
	private LisRequestionItem lisRequestionItem;

	// bi-directional many-to-one association to LisWebBarcodeRule
	@ManyToOne
	@JoinColumn(name = "MANAGE_ID")
	private LisWebBarcodeRule lisWebBarcodeRule;

	public LisWebBcruleItem() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LisRequestionItem getLisRequestionItem() {
		return this.lisRequestionItem;
	}

	public void setLisRequestionItem(LisRequestionItem lisRequestionItem) {
		this.lisRequestionItem = lisRequestionItem;
	}

	public LisWebBarcodeRule getLisWebBarcodeRule() {
		return this.lisWebBarcodeRule;
	}

	public void setLisWebBarcodeRule(LisWebBarcodeRule lisWebBarcodeRule) {
		this.lisWebBarcodeRule = lisWebBarcodeRule;
	}

}