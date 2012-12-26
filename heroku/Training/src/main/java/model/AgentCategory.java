package model;

public class AgentCategory {

  private int agentCategoryId;
  private String name;
  private String description;


  public AgentCategory(int agentCategoryId, String name, String description) {
    this.agentCategoryId   = agentCategoryId;
    this.name              = name;
    this.description       = description;
  }


  /**
   * @param agentCategoryId the agentCategoryId to set
   */
  public void setAgentCategoryId(int agentCategoryId) {
    this.agentCategoryId = agentCategoryId;
  }

  /**
   * @return the agentCategoryId
   */
  public int getAgentCategoryId() {
    return agentCategoryId;
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
