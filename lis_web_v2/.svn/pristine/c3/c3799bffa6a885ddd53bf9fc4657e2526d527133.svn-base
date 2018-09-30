package com.cdxt.lisweb.model.user;

import java.util.ArrayList;
import java.util.List;

import com.cdxt.lisweb.model.tree.CheckableNode;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class OrgNode extends CheckableNode {

  private List<OrgNode> children = new ArrayList<OrgNode>();

  public OrgNode(String id, String text) {
    super(id, text);
  }

  public List<OrgNode> getChildren() {
    return children;
  }

  public void setChildren(List<OrgNode> children) {
    this.children = children;
  }

  public void addChild(OrgNode n) {
    this.children.add(n);
  }



}
