package com.cdxt.lisweb.entity.statistics;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the LIS_CUSTOM_SETTING database table.
 * 
 */
@Entity
@Table(name="LIS_CUSTOM_SETTING")
@NamedQuery(name="LisCustomSetting.findAll", query="SELECT l FROM LisCustomSetting l")
public class LisCustomSetting implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="IS_USE")
	private String isUse;

	@Column(name="MENU_NAME")
	private String menuName;

	@Column(name="PARENT_NAV")
	private String parentNav;

	@Column(name="PARENT_NAV_ID")
	private String parentNavId;

	private String url;

	@Column(name="URL_NAME")
	private String urlName;

	public LisCustomSetting() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIsUse() {
		return this.isUse;
	}

	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getParentNav() {
		return this.parentNav;
	}

	public void setParentNav(String parentNav) {
		this.parentNav = parentNav;
	}

	public String getParentNavId() {
		return this.parentNavId;
	}

	public void setParentNavId(String parentNavId) {
		this.parentNavId = parentNavId;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrlName() {
		return this.urlName;
	}

	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}

}