package model;

public class AgentProperty {
  private int agentPropertyId;
  private String name;
  private String value;

  public AgentProperty(int agentPropertyId, String name, String value) {
    this.agentPropertyId   = agentPropertyId;
    this.name              = name;
    this.value             = value;
  }

  /**
   * @param agentPropertyId the agentPropertyId to set
   */
  public void setAgentPropertyId(int agentPropertyId) {
    this.agentPropertyId = agentPropertyId;
  }

  /**
   * @return the agentPropertyId
   */
  public int getAgentPropertyId() {
    return agentPropertyId;
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
   * @param value the value to set
   */
  public void setValue(String value) {
    this.value = value;
  }

  /**
   * @return the value
   */
  public String getValue() {
    return value;
  }

}
