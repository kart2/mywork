package com.perficient.ics.model;

public class Agent extends AgentPersist {
  private int agentId;
  private String name;
  private String description;


  public Agent() {
  }

  public Agent(int agentId, String name, String description) {
    this.agentId     = agentId;
    this.name        = name;
    this.description = description;
  }

  /**
   * @param agentId the agentId to set
   */
  public void setAgentId(int agentId) {
    this.agentId = agentId;
  }

  /**
   * @return the agentId
   */
  public int getAgentId() {
    return agentId;
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
