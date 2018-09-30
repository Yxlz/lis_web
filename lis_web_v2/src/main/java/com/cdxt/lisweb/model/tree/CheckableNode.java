package com.cdxt.lisweb.model.tree;

/**
 * 复选框树节点
 * 
 * @author lixying
 * @date 2017年5月12日 下午1:53:38
 * @since 1.0.0
 */
public class CheckableNode extends Node {

  private Boolean checked = false;

  public CheckableNode(String id, String text) {
    this.id = id;
    this.text = text;
  }

  public Boolean isChecked() {
    return checked;
  }

  public void setChecked(Boolean checked) {
    this.checked = checked;
  }


}
