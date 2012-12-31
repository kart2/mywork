package com.perficient.ics.javasource.controller;

/**
 * JavaSourceController
 *
 */
public class JavaSourceController {
  public static void main( String[] args ) {
    String projectName = args[0];
    String className   = args[1];

    StringBuilder sourceBuilder = new StringBuilder();
    sourceBuilder.append("package com.perficient.ics.")
                 .append(projectName)
                 .append(";\n\n");

    sourceBuilder.append("import java.util.*;\n\n");

    sourceBuilder.append("public class ")
                 .append(className)
                 .append(" {\n");
    
    sourceBuilder.append("  public static void main(String[] args) {\n");
    sourceBuilder.append("    System.out.println(\"Java Source Generator\");\n");
    sourceBuilder.append("  }\n");
    sourceBuilder.append("}\n");

    System.out.println(sourceBuilder.toString());
  }
}
