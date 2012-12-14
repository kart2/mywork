package com.yomdom.java.javahelloworld.model;

public class Agent extends AgentPersist {
  private String name;
  private String description;

  public Agent() {
  }

  public Agent(String name, String description) {
    this.name        = name;
    this.description = description;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }

}
