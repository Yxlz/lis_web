package com.cdxt.lisweb.entity.inspec;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the LIS_INSPEC_CONTAINER database table.
 * 
 */
@Entity
@Table(name="LIS_INSPEC_CONTAINER")
@NamedQuery(name="LisInspecContainer.findAll", query="SELECT l FROM LisInspecContainer l")
public class LisInspecContainer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	@Column(name="CODE")
	private String code;
	
	@Column(name="COLOR")
	private String color;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="REMARK")
	private String remark;

	public LisInspecContainer() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


}