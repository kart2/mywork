package com.perficient.ics.javasource.controller;

import java.util.*;
import java.net.*;
import java.io.*;

import com.perficient.ics.javasource.model.*;

public class ModelCreateController {
  public ModelCreateController(Project project) {

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
    sourceBuilder.append("public class Model {\n");

 
    // Declare static variables
    sourceBuilder.append("  private static final String DB_DRIVER     = \"org.postgresql.Driver\";\n");
    sourceBuilder.append("  private static final String DB_CONNECTION = \"jdbc:postgresql://127.0.0.1:5432/ics\";\n");
    sourceBuilder.append("  private static final String DB_USER       = \"ics\";\n");
    sourceBuilder.append("  private static final String DB_PASSWORD   = \"ics\";\n");
    sourceBuilder.append("\n");

    // getConnection method
    sourceBuilder.append("  public static Connection getDBConnection() {\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("    Connection dbConnection = null;\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("    try {\n");
    sourceBuilder.append("      Class.forName(DB_DRIVER);\n");
    sourceBuilder.append("    }\n");
    sourceBuilder.append("    catch (ClassNotFoundException e) {\n");
    sourceBuilder.append("      System.out.println(e.getMessage());\n");
    sourceBuilder.append("    }\n");
    sourceBuilder.append("    try {\n");
    sourceBuilder.append("      dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);\n");
    sourceBuilder.append("      return dbConnection;\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("    }\n");
    sourceBuilder.append("    catch (SQLException e) {\n");
    sourceBuilder.append("      System.out.println(e.getMessage());\n");
    sourceBuilder.append("    }\n");

    sourceBuilder.append("    return dbConnection;\n");
    sourceBuilder.append("  }\n");

    // getCurrentTimeStamp method
    sourceBuilder.append("  public static java.sql.Timestamp getCurrentTimeStamp() {\n");
    sourceBuilder.append("    java.util.Date today = new java.util.Date();\n");
    sourceBuilder.append("    return new java.sql.Timestamp(today.getTime());\n");
    sourceBuilder.append("  }\n");

    sourceBuilder.append("\n");

    // End Class definition
    sourceBuilder.append("}\n");

    System.out.println(sourceBuilder.toString());
  }
}
