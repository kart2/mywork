package com.perficient.ics.javasource.controller;

import java.util.*;
import java.net.*;
import java.io.*;

import com.perficient.ics.javasource.model.*;

public class ModelCreateController {
  public ModelCreateController(Project project) {

    StringBuilder sourceBuilder = new StringBuilder();

    // Package
    sourceBuilder.append("package com.perficient.ics.")
                 .append(project.getName())
                 .append(".model;\n\n");


    // Standard Imports 
    sourceBuilder.append("// Standard Imports");
    sourceBuilder.append("\n");
    sourceBuilder.append("import java.util.*;");
    sourceBuilder.append("\n");
    sourceBuilder.append("import java.net.*;");
    sourceBuilder.append("\n");
    sourceBuilder.append("import java.io.*;");
    sourceBuilder.append("\n");
    sourceBuilder.append("import java.sql.*;");
    sourceBuilder.append("\n");
    sourceBuilder.append("\n");

    // Custom Imports 
    sourceBuilder.append("// Custom Imports");
    sourceBuilder.append("\n");
    for(String importString : project.getImports()) {
      sourceBuilder.append("import ");
      sourceBuilder.append(importString);
      sourceBuilder.append(";\n");
    }
    
    sourceBuilder.append("\n");

    // Class definition
    sourceBuilder.append("public class Model {");
    sourceBuilder.append("\n");

 
    // Declare static variables
    sourceBuilder.append("  private static final String DB_DRIVER     = \"org.postgresql.Driver\";");
    sourceBuilder.append("\n");
    sourceBuilder.append("  private static final String DB_CONNECTION = \"jdbc:postgresql://127.0.0.1:5432/ics\";");
    sourceBuilder.append("\n");
    sourceBuilder.append("  private static final String DB_USER       = \"ics\";");
    sourceBuilder.append("\n");
    sourceBuilder.append("  private static final String DB_PASSWORD   = \"ics\";");
    sourceBuilder.append("\n");

    // getConnection method
    sourceBuilder.append("  public static Connection getDBConnection() {");
    sourceBuilder.append("\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("    Connection dbConnection = null;");
    sourceBuilder.append("\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("    try {");
    sourceBuilder.append("\n");
    sourceBuilder.append("      Class.forName(DB_DRIVER);");
    sourceBuilder.append("\n");
    sourceBuilder.append("    }");
    sourceBuilder.append("\n");
    sourceBuilder.append("    catch (ClassNotFoundException e) {");
    sourceBuilder.append("\n");
    sourceBuilder.append("      System.out.println(e.getMessage());");
    sourceBuilder.append("\n");
    sourceBuilder.append("    }");
    sourceBuilder.append("\n");
    sourceBuilder.append("    try {");
    sourceBuilder.append("\n");
    sourceBuilder.append("      dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);");
    sourceBuilder.append("\n");
    sourceBuilder.append("      return dbConnection;");
    sourceBuilder.append("\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("    }");
    sourceBuilder.append("\n");
    sourceBuilder.append("    catch (SQLException e) {");
    sourceBuilder.append("\n");
    sourceBuilder.append("      System.out.println(e.getMessage());");
    sourceBuilder.append("\n");
    sourceBuilder.append("    }");
    sourceBuilder.append("\n");

    sourceBuilder.append("    return dbConnection;");
    sourceBuilder.append("\n");
    sourceBuilder.append("  }");
    sourceBuilder.append("\n");

    sourceBuilder.append("  public static java.sql.Timestamp getCurrentTimeStamp() {");
    sourceBuilder.append("\n");
    sourceBuilder.append("    java.util.Date today = new java.util.Date();");
    sourceBuilder.append("\n");
    sourceBuilder.append("    return new java.sql.Timestamp(today.getTime());");
    sourceBuilder.append("\n");
    sourceBuilder.append("  }");

    sourceBuilder.append("\n");

    // End Class definition
    sourceBuilder.append("}\n");

    System.out.println(sourceBuilder.toString());
  }
}
