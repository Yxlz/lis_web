package com.cdxt.lisweb.entity.mdro;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the LIS_WEB_MDROS_SUGGESTION database table.
 * 
 */
@Entity
@Table(name="LIS_WEB_MDROS_SUGGESTION")
@NamedQuery(name="LisWebMdrosSuggestion.findAll", query="SELECT l FROM LisWebMdrosSuggestion l")
public class LisWebMdrosSuggestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="MDRO_CODE")
	private String mdroCode;

	@Column(name="MDRO_NAME")
	private String mdroName;

	@Lob
	@Column(name="MDRO_SUGGESTION", columnDefinition="BLOB", nullable=true)
	private String mdroSuggestion;

	public LisWebMdrosSuggestion() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMdroCode() {
		return this.mdroCode;
	}

	public void setMdroCode(String mdroCode) {
		this.mdroCode = mdroCode;
	}

	public String getMdroName() {
		return this.mdroName;
	}

	public void setMdroName(String mdroName) {
		this.mdroName = mdroName;
	}

	public String getMdroSuggestion() {
		return this.mdroSuggestion;
	}

	public void setMdroSuggestion(String mdroSuggestion) {
		this.mdroSuggestion = mdroSuggestion;
	}

}