package model;


public class TestItem {

  private Integer testItemId;
  private Integer testId;
  private String action;
  private String value;
  private String element;


  public TestItem(Integer testItemId, Integer testId, String action, String value, String element) {

    public void setTestItemId(String testItemId) {
      this.testItemId = testItemId;
    }

    public String getTestItemId() {
      return testItemId;
    }

    public void setTestId(String testId) {
      this.testId = testId;
    }

    public String getTestId() {
      return testId;
    }

    public void setAction(String action) {
      this.action = action;
    }

    public String getAction() {
      return action;
    }

    public void setValue(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    public void setEnvironment(String environment) {
      this.environment = environment;
    }

    public String getEnvironment() {
      return environment;
    }
  
  }

}
