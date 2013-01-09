package com.perficient.ics.sourcegenerate.controller.java;

import java.util.*;
import java.net.*;
import java.io.*;
import org.apache.commons.lang.WordUtils;

import com.perficient.ics.sourcegenerate.model.*;

public class PojoController {
  private String source;
  public PojoController(Project project) {

    StringBuilder sourceBuilder = new StringBuilder();

    // Package
    sourceBuilder.append("package com.perficient.ics." + project.getProjectName().toLowerCase() + ".model;\n\n");


    // Standard Imports 
    sourceBuilder.append("// Standard Imports\n");
    sourceBuilder.append("import java.util.*;\n");
    sourceBuilder.append("import java.net.*;\n");
    sourceBuilder.append("import java.io.*;\n");
    sourceBuilder.append("import java.sql.*;\n");
    sourceBuilder.append("\n");

    // Custom Imports 
    sourceBuilder.append("// Custom Imports\n");
    for(String importString : project.getImports()) {
      sourceBuilder.append("import " + importString + ";\n");
    }
    
    sourceBuilder.append("\n");

    // Class definition
    sourceBuilder.append("public class " + project.getClassName() + " extends " + project.getClassName() + "Persist {");
    sourceBuilder.append("\n");

 
    // Declare private variables
    for(Property property : project.getProperties()) {
      sourceBuilder.append("  private " + property.getType() + " " + property.getName() + ";\n");
    }

    sourceBuilder.append("\n");

    // Constructor method
    sourceBuilder.append("  public " + project.getClassName() + "(");

    int size = project.getProperties().size();
    for(Property property : project.getProperties()) {
       sourceBuilder.append(property.getType() + " " + property.getName());

      if(--size == 0) {
        sourceBuilder.append(")" + " {");
      } else {
        sourceBuilder.append(", ");
      }

    }

    sourceBuilder.append("\n");

    for(Property property : project.getProperties()) {
       sourceBuilder.append("    this." + property.getName() + " = " + property.getName() + ";");
       sourceBuilder.append("\n");
    }

    sourceBuilder.append("  }");
    sourceBuilder.append("\n");

    // Accessor methods
    for(Property property : project.getProperties()) {

      sourceBuilder.append("  public void set" + WordUtils.capitalizeFully(property.getName()) + "(" + property.getType() + " " + property.getName() + ") {\n");
      sourceBuilder.append("    this." + property.getName() + " = " + property.getName() + ";\n");
      sourceBuilder.append("  }\n");
      sourceBuilder.append("\n");
      sourceBuilder.append("  public " + property.getType() + " get" + WordUtils.capitalizeFully(property.getName()) + "() {\n");
      sourceBuilder.append("    return " + property.getName() + ";\n");
      sourceBuilder.append("  }\n");

    }
    sourceBuilder.append("\n");

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
