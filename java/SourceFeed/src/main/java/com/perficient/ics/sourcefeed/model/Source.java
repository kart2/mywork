package com.perficient.ics.sourcefeed.model;

import java.util.*;

public class Source {
  private String fileName;
  private String packageName;
  private String projectName;
  private String className;

  /**
   * @param fileName the fileName to set
   */
  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  /**
   * @return the fileName
   */
  public String getFileName() {
    return fileName;
  }

  /**
   * @param packageName the packageName to set
   */
  public void setPackageName(String packageName) {
    this.packageName = packageName;
  }

  /**
   * @return the packageName
   */
  public String getPackageName() {
    return packageName;
  }

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

}
