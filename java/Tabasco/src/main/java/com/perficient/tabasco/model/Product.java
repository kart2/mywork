package com.perficient.tabasco.model;

public class Product extends ProductPersist {
  private int productId;
  private String name;
  private String item;
  private String model;
  private String description;
  private String url;
  private double price;


  public Product() {
  }

  public Product(int productId, String name, String item, String model, String description, String url, double price) {
    this.productId   = productId;
    this.name        = name;
    this.item        = item;
    this.model       = model;
    this.description = description;
    this.url         = url;
    this.price       = price;
  }


  /**
   * @param productId the productId to set
   */
  public void setProductId(int productId) {
    this.productId = productId;
  }

  /**
   * @return the productId
   */
  public int getProductId() {
    return productId;
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
   * @param item the item to set
   */
  public void setItem(String item) {
    this.item = item;
  }

  /**
   * @return the item
   */
  public String getItem() {
    return item;
  }


  /**
   * @param model the model to set
   */
  public void setModel(String model) {
    this.model = model;
  }

  /**
   * @return the model
   */
  public String getModel() {
    return model;
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

  /**
   * @param url the url to set
   */
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   * @return the url
   */
  public String getUrl() {
    return url;
  }


  /**
   * @param price the price to set
   */
  public void setPrice(double price) {
    this.price = price;
  }

  /**
   * @return the price
   */
  public double getPrice() {
    return price;
  }

}
