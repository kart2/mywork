package model;


public class Profile {

   private Integer profileId;
   private Integer testId;
   private String environment;


   public Profile(Integer profileId, Integer testId, String environment) {

    public void setProfileId(Integer profileId) {
      this.profileId = profileId;
    }

    public Integer getProfileId() {
      return profileId;
    }

    public void setTestId(Integer testId) {
      this.testId = testId;
    }

    public Integer getTestId() {
      return testId;
    }

    public void setEnvironment(String environment) {
      this.environment = environment;
    }

    public String getEnvironment() {
      return environment;
    }

   }

}
