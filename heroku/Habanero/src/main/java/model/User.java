package model;


public class User {

  private Integer userId;
  private String username;
  private String password;


  public User(Integer userId, String username, String password) {

    public void setUserId(String userId) {
      this.userId = userId;
    }

    public String getUserId() {
      return userId;
    }

    public void setUsername(String username) {
      this.username = username;
    }

    public String getUsername() {
      return username;
    }

    public void setPassword(String password) {
      this.password = password;
    }

    public String getPassword() {
      return password;
    } 

  }

}
