package com.perficient.ics.sourcefeed.model;

import java.util.*;

public class Project {
  private Source fromSource;
  private Source toSource;

  /**
   * @param fromSource the fromSource to set
   */
  public void setFromSource(Source fromSource) {
    this.fromSource = fromSource;
  }

  /**
   * @return the fromSource
   */
  public Source getFromSource() {
    return fromSource;
  }


  /**
   * @param toSource the toSource to set
   */
  public void setToSource(Source toSource) {
    this.toSource = toSource;
  }

  /**
   * @return the toSource
   */
  public Source getToSource() {
    return toSource;
  }
}
