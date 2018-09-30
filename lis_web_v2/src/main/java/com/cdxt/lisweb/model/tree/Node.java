package com.cdxt.lisweb.model.tree;

import org.springframework.util.StringUtils;

import com.cdxt.lisweb.model.right.RightNode;

/**
 * 所有树节点父亲
 * 
 * @author lixying
 * @date 2017年5月12日 下午1:50:59
 * @since 1.0.0
 */
public class Node {

  protected String id;

  protected String text;

  protected boolean leaf = true;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public boolean isLeaf() {
    return leaf;
  }

  public void setLeaf(boolean leaf) {
    this.leaf = leaf;
  }

  @Override
  public int hashCode() {
    return this.id.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    if (!StringUtils.hasText(id)) {
      return false;
    }
    if (obj instanceof RightNode) {
      RightNode n = (RightNode) obj;
      return id.equals(n.getId());
    } else {
      return false;
    }
  }

  @Override
  public String toString() {
    return text;
  }


}
