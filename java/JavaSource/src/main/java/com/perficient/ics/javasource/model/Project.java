package com.perficient.ics.javasource.model;

import java.util.*;

public class Project {
  private String projectName;
  private String className;
  private ArrayList<String> imports;
  private ArrayList<Property> properties;

  /**
   * @param projectName the projectName to set
   */
  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  /**
   * @return the projectName
   */
  public String getProjectName() {
    return projectName;
  }

  /**
   * @param className the className to set
   */
  public void setClassName(String className) {
    this.className = className;
  }

  /**
   * @return the className
   */
  public String getClassName() {
    return className;
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
