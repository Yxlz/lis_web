package com.cdxt.lisweb.model.barcode;

import javax.persistence.Transient;

/**
 * 条码规则
 *
 */
public class Rule {
	public enum Type {
		SINGLE, MERGE
	}
	@Transient
	private Type ruleType;

	public Rule(Type t) {
		this.ruleType = t;
	}

	public Rule() {
	}

	public Type getRuleType() {
		return ruleType;
	}

	public void setRuleType(Type ruleType) {
		this.ruleType = ruleType;
	}

	@Override
	public String toString() {
		return ruleType == null ? super.toString() : ruleType.toString();
	}

}
