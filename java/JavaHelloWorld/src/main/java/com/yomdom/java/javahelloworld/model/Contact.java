package com.yomdom.java.javahelloworld.model;

public class Contact {
  private String name;
  private String title;
  private String subtitle;
  private String latitude;
  private String longitude;

  public Contact() {
  }

  public Contact(String name, String title, String subtitle, String latitude, String longitude) {
    this.name      = name;
    this.title     = title;
    this.subtitle  = subtitle;
    this.latitude  = latitude;
    this.longitude = longitude;
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
   * @param title the title to set
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * @param subtitle the subtitle to set
   */
  public void setSubtitle(String subtitle) {
    this.subtitle = subtitle;
  }

  /**
   * @return the subtitle
   */
  public String getSubtitle() {
    return subtitle;
  }

  /**
   * @param latitude the latitude to set
   */
  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  /**
   * @return the latitude
   */
  public String getLatitude() {
    return latitude;
  }

  /**
   * @param longitude the longitude to set
   */
  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  /**
   * @return the longitude
   */
  public String getLongitude() {
    return longitude;
  }

}
