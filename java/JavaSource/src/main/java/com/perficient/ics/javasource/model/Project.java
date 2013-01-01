package com.perficient.ics.javasource.model;

import java.util.*;

public class Project {
  private String name;
  private ArrayList<String> imports;
  private ArrayList<Property> properties;


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
   * @param imports the imports to set
   */
  public void setImports(ArrayList<String> imports) {
    this.imports = imports;
  }

  /**
   * @return the imports
   */
  public ArrayList<String> getImports() {
    return imports;
  }

  /**
   * @param properties the properties to set
   */
  public void setProperties(ArrayList<Property> properties) {
    this.properties = properties;
  }

  /**
   * @return the properties
   */
  public ArrayList<Property> getProperties() {
    return properties;
  }

}
