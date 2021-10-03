/*
 * Copyright 2020 Adib Saikali
 *
 */

package com.example.json;

class Node {

  private final String name;
  private Node parent;
  private Node child;

  public Node(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public Node getParent() {
    return parent;
  }

  public void setParent(Node parent) {
    this.parent = parent;
  }

  public Node getChild() {
    return child;
  }

  public void setChild(Node child) {
    this.child = child;
  }
}
