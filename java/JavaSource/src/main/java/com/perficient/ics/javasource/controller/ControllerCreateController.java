package com.perficient.ics.javasource.controller;

import java.util.*;
import java.net.*;
import java.io.*;
import org.apache.commons.lang.WordUtils;

import com.perficient.ics.javasource.model.*;

public class ControllerCreateController {
  private String source;
  public ControllerCreateController(Project project) {

    StringBuilder sourceBuilder = new StringBuilder();

    // Package
    sourceBuilder.append("package com.perficient.ics." + project.getProjectName() + ".controller;\n\n");

    // Standard Imports 
    sourceBuilder.append("import java.util.*;\n");
    sourceBuilder.append("import java.io.*;\n");
    sourceBuilder.append("\n");

    // Custom Imports 
    sourceBuilder.append("// Custom Imports\n");
    for(String importString : project.getImports()) {
      sourceBuilder.append("import " + importString + ";\n");
    }
    
    sourceBuilder.append("\n");
    sourceBuilder.append("public class " + project.getProjectName()  + "Controller {\n");
    sourceBuilder.append("  public static void main( String[] args ) {\n");
    sourceBuilder.append("    System.out.println(" + project.getProjectName() + ");\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("  }\n");

    // End Class definition
    sourceBuilder.append("}\n");

    this.source = sourceBuilder.toString();
  }

  /**
   * @param source the source to set
   */
  public void setSource(String source) {
    this.source = source;
  }

  /**
   * @return the source
   */
  public String getSource() {
    return source;
  }
}
