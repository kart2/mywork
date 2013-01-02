package com.perficient.ics.javasource.controller;

import java.util.*;
import java.net.*;
import java.io.*;
import org.apache.commons.lang.WordUtils;

import com.perficient.ics.javasource.model.*;

public class PojoCreateController {
  public PojoCreateController(Project project) {

    StringBuilder sourceBuilder = new StringBuilder();

    // Package
    sourceBuilder.append("package com.perficient.ics." + project.getProjectName() + ".model;\n\n");


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
    sourceBuilder.append("public class " + project.getClassName() + " {");
    sourceBuilder.append("\n");

 
    // Declare private variables
    for(Property property : project.getProperties()) {
      sourceBuilder.append("  private " + property.getType() + " " + property.getName() + ";\n");
    }

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

    System.out.println(sourceBuilder.toString());
  }
}
