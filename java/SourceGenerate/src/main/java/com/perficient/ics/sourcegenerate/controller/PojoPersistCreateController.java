package com.perficient.ics.sourcegenerate.controller;

import java.util.*;
import java.net.*;
import java.io.*;
import org.apache.commons.lang.WordUtils;

import com.perficient.ics.sourcegenerate.model.*;

public class PojoPersistCreateController {
  private Project project;
  private String source;
  private StringBuilder sourceBuilder;

  public PojoPersistCreateController(Project project) {

    this.project = project;

    this.sourceBuilder = new StringBuilder();

    // Package
    sourceBuilder.append("package com.perficient.ics." + project.getProjectName().toLowerCase() + ".model;\n\n");

    // Standard Imports 
    sourceBuilder.append("// Standard Imports\n");
    sourceBuilder.append("import java.util.*;\n");
    sourceBuilder.append("import java.net.*;\n");
    sourceBuilder.append("import java.io.*;\n");
    sourceBuilder.append("import java.sql.*;\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("import org.codehaus.jackson.map.ObjectMapper;\n");
    sourceBuilder.append("import org.codehaus.jackson.type.TypeReference;\n");
    sourceBuilder.append("import org.codehaus.jackson.map.type.TypeFactory;\n");
    sourceBuilder.append("\n");

    // Custom Imports 
    sourceBuilder.append("// Custom Imports\n");
    for(String importString : project.getImports()) {
      sourceBuilder.append("import " + importString + ";\n");
    }
    
    sourceBuilder.append("\n");

    // Class definition
    sourceBuilder.append("public class " + project.getClassName() + "Persist extends Model {");
    sourceBuilder.append("\n");

    init();
    list();
    create();
    deleteAll();
    toJson();

    // End Class definition
    sourceBuilder.append("}\n");

    this.source = sourceBuilder.toString();
  }

  public void init() {
    // Init Method
    sourceBuilder.append("  public static void init() {\n");
    sourceBuilder.append("    ArrayList<String> sqlCommands = new ArrayList<String>();\n");
    sourceBuilder.append("    sqlCommands.add(\"DROP TABLE IF EXISTS " + project.getClassName().toLowerCase() + "\");\n");
    sourceBuilder.append("\n");

    // Create table
    sourceBuilder.append("    StringBuilder stringBuilder = new StringBuilder();\n");
    sourceBuilder.append("    stringBuilder.append(\"CREATE TABLE " + project.getClassName().toLowerCase() + " (\");\n");

    // Create fields
    int size = project.getProperties().size();
    for(Property property : project.getProperties()) {

      // Primary key
      String primaryKey = project.getClassName().toLowerCase() + "Id";
      if(property.getType().equals("int") && property.getName().equals(primaryKey)) {
        sourceBuilder.append("    stringBuilder.append(\"" + property.getName().toLowerCase() + " serial PRIMARY KEY");
      }
      else if(property.getType().equals("int") || property.getType().equals("double")) {
        sourceBuilder.append("    stringBuilder.append(\"" + property.getName().toLowerCase() + " numeric NOT NULL");
      }
      else if(property.getType().equals("String")) {
        sourceBuilder.append("    stringBuilder.append(\"" + property.getName().toLowerCase() + " text NOT NULL");
      }

      if(--size == 0) {
        sourceBuilder.append("\");\n");
      }
      else {
        sourceBuilder.append(",\");\n");
      }
    }

    sourceBuilder.append("    stringBuilder.append(\");\");\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("    sqlCommands.add(stringBuilder.toString());\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("    for(String sql : sqlCommands) {\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("      Connection dbConnection = null;\n");
    sourceBuilder.append("      Statement statement = null;\n");
    sourceBuilder.append("  \n");
    sourceBuilder.append("      try {\n");
    sourceBuilder.append("        dbConnection = getDBConnection();\n");
    sourceBuilder.append("        statement    = dbConnection.createStatement();\n");
    sourceBuilder.append("        statement.executeUpdate(sql);\n");
    sourceBuilder.append("      }\n");
    sourceBuilder.append("      catch (SQLException e) {\n");
    sourceBuilder.append("        System.out.println(e.getMessage());\n");
    sourceBuilder.append("      }\n");
    sourceBuilder.append("      finally {\n");
    sourceBuilder.append("        try {\n");
    sourceBuilder.append("          if (statement != null) {\n");
    sourceBuilder.append("            statement.close();\n");
    sourceBuilder.append("          }\n");
    sourceBuilder.append("    \n");
    sourceBuilder.append("          if (dbConnection != null) {\n");
    sourceBuilder.append("            dbConnection.close();\n");
    sourceBuilder.append("          }\n");
    sourceBuilder.append("        }\n");
    sourceBuilder.append("        catch(SQLException e) {\n");
    sourceBuilder.append("          System.out.println(e.getMessage());\n");
    sourceBuilder.append("        }\n");
    sourceBuilder.append("      }\n");
    sourceBuilder.append("    }\n");
    sourceBuilder.append("  }\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("\n");

  }

  public void list() {
    // List Method
    sourceBuilder.append("  public static ArrayList<" + project.getClassName() + "> list() {\n");
    sourceBuilder.append("    ArrayList<" + project.getClassName() + "> " + project.getClassName().toLowerCase()  + "s = new ArrayList<" + project.getClassName() + ">();\n");
    sourceBuilder.append(" \n");
    sourceBuilder.append("    Connection dbConnection = null;\n");
    sourceBuilder.append("    PreparedStatement preparedStatement = null;\n");
    sourceBuilder.append(" \n");
    sourceBuilder.append("    String selectSQL = \"SELECT * FROM " + project.getClassName().toLowerCase() + "\";\n");
    sourceBuilder.append(" \n");
    sourceBuilder.append("    try {\n");
    sourceBuilder.append("      dbConnection = getDBConnection();\n");
    sourceBuilder.append("      preparedStatement = dbConnection.prepareStatement(selectSQL);\n");
    sourceBuilder.append(" \n");
    sourceBuilder.append("      // execute select SQL stetement\n");
    sourceBuilder.append("      ResultSet rs = preparedStatement.executeQuery();\n");
    sourceBuilder.append(" \n");
    sourceBuilder.append("      while (rs.next()) {\n");

    // Map fields
    for(Property property : project.getProperties()) {
      if(property.getType().equals("int")) {
        sourceBuilder.append("        int " + property.getName() + " = rs.getInt(\"" + property.getName().toLowerCase() + "\");\n");
      }
      else if(property.getType().equals("double")) {
        sourceBuilder.append("        double " + property.getName() + " = rs.getDouble(\"" + property.getName().toLowerCase() + "\");\n");
      }
      else if(property.getType().equals("String")) {
        sourceBuilder.append("        String " + property.getName() + " = rs.getString(\"" + property.getName().toLowerCase() + "\");\n");
      }
    }

    sourceBuilder.append(" \n");
    sourceBuilder.append("        " + project.getClassName().toLowerCase() + "s.add(new " + project.getClassName() + "(");

    int size = project.getProperties().size();
    for(Property property : project.getProperties()) {
      sourceBuilder.append(property.getName());
      if(--size != 0) {
        sourceBuilder.append(", ");
      }
    }

    sourceBuilder.append("));\n");
    sourceBuilder.append("      }\n");
    sourceBuilder.append(" \n");
    sourceBuilder.append("    } \n");
    sourceBuilder.append("    catch (SQLException e) {\n");
    sourceBuilder.append("      System.out.println(e.getMessage());\n");
    sourceBuilder.append("    } \n");
    sourceBuilder.append("    finally {\n");
    sourceBuilder.append("      try {\n");
    sourceBuilder.append("        if (preparedStatement != null) {\n");
    sourceBuilder.append("          preparedStatement.close();\n");
    sourceBuilder.append("        }\n");
    sourceBuilder.append("   \n");
    sourceBuilder.append("        if (dbConnection != null) {\n");
    sourceBuilder.append("          dbConnection.close();\n");
    sourceBuilder.append("        }\n");
    sourceBuilder.append("      }\n");
    sourceBuilder.append("      catch(SQLException e) {\n");
    sourceBuilder.append("        System.out.println(e.getMessage());\n");
    sourceBuilder.append("      }\n");
    sourceBuilder.append("    }\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("    return " + project.getClassName().toLowerCase() + "s;\n");
    sourceBuilder.append("  }\n");
    sourceBuilder.append(" \n");

  }

  public void create() {
    // Create Method
    sourceBuilder.append("  public static void create(ArrayList<" + project.getClassName() + "> " + project.getClassName().toLowerCase() + "s) {\n");
    sourceBuilder.append(" \n");
    sourceBuilder.append("    Connection dbConnection = null;\n");
    sourceBuilder.append("    PreparedStatement preparedStatement = null;\n");
    sourceBuilder.append(" \n");
    sourceBuilder.append("    String insertTableSQL = \"INSERT INTO " + project.getClassName().toLowerCase() + "\"\n");
    sourceBuilder.append("        + \"(");

    int size = project.getProperties().size();
    String primaryKey = project.getClassName().toLowerCase() + "Id";

    for(Property property : project.getProperties()) {

       size--;

      if(!(property.getType().equals("int") && property.getName().equals(primaryKey))) {
        sourceBuilder.append(property.getName().toLowerCase());
        if(size != 0) {
         sourceBuilder.append(", ");
        }
      }
    }

    sourceBuilder.append(") VALUES\"\n");
    sourceBuilder.append("        + \"(");

    size = project.getProperties().size();

    for(Property property : project.getProperties()) {

       size--;

      if(!(property.getType().equals("int") && property.getName().equals(primaryKey))) {
        sourceBuilder.append("?");
        if(size != 0) {
          sourceBuilder.append(", ");
        }
      }
    }

    sourceBuilder.append(")\";\n");
    sourceBuilder.append(" \n");
    sourceBuilder.append("    try {\n");
    sourceBuilder.append("      dbConnection = getDBConnection();\n");
    sourceBuilder.append("      preparedStatement = dbConnection.prepareStatement(insertTableSQL);\n");
    sourceBuilder.append(" \n");
    sourceBuilder.append("      dbConnection.setAutoCommit(false);\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("      for(" + project.getClassName()  + " " + project.getClassName().toLowerCase()  + " : " + project.getClassName().toLowerCase() + "s) {\n");


    int i = 1;
    for(Property property : project.getProperties()) {
      if(!(property.getType().equals("int") && property.getName().equals(primaryKey))) {
        if(property.getType().equals("int")) {
          sourceBuilder.append("        preparedStatement.setInt(" + i + ", " + project.getClassName().toLowerCase() + ".get" + WordUtils.capitalizeFully(property.getName()) + "());\n");
        }
        else if(property.getType().equals("double")) {
          sourceBuilder.append("        preparedStatement.setDouble(" + i + ", " + project.getClassName().toLowerCase() + ".get" + WordUtils.capitalizeFully(property.getName()) + "());\n");
        }
        else if(property.getType().equals("String")) {
          sourceBuilder.append("        preparedStatement.setString(" + i + ", " + project.getClassName().toLowerCase() + ".get" + WordUtils.capitalizeFully(property.getName()) + "());\n");
        }
        i++;
      }
    }

    sourceBuilder.append("\n");

    sourceBuilder.append("        preparedStatement.addBatch();\n");

    sourceBuilder.append("      }\n");
    sourceBuilder.append(" \n");
    sourceBuilder.append("      preparedStatement.executeBatch();\n");
    sourceBuilder.append(" \n");
    sourceBuilder.append("      dbConnection.commit();\n");
    sourceBuilder.append(" \n");
    sourceBuilder.append("      System.out.println(\"Records inserted into " + project.getClassName().toLowerCase() + " table!\");\n");
    sourceBuilder.append(" \n");
    sourceBuilder.append("    } \n");
    sourceBuilder.append("    catch (SQLException e) {\n");
    sourceBuilder.append(" \n");
    sourceBuilder.append("      System.out.println(e.getMessage());\n");
    sourceBuilder.append("      try {\n");
    sourceBuilder.append("        dbConnection.rollback();\n");
    sourceBuilder.append("      }\n");
    sourceBuilder.append("      catch(SQLException ex) {\n");
    sourceBuilder.append("        System.out.println(ex.getMessage());\n");
    sourceBuilder.append("      }\n");
    sourceBuilder.append(" \n");
    sourceBuilder.append("    } \n");
    sourceBuilder.append("    finally {\n");
    sourceBuilder.append("      try {\n");
    sourceBuilder.append("        if (preparedStatement != null) {\n");
    sourceBuilder.append("          preparedStatement.close();\n");
    sourceBuilder.append("        }\n");
    sourceBuilder.append("  \n");
    sourceBuilder.append("        if (dbConnection != null) {\n");
    sourceBuilder.append("          dbConnection.close();\n");
    sourceBuilder.append("        }\n");
    sourceBuilder.append("      }\n");
    sourceBuilder.append("      catch(SQLException e) {\n");
    sourceBuilder.append("        System.out.println(e.getMessage());\n");
    sourceBuilder.append("      }\n");
    sourceBuilder.append("    }\n");
    sourceBuilder.append(" \n");
    sourceBuilder.append("  }\n");
    sourceBuilder.append("\n");

  }

  public void deleteAll() {

    // Delete Method
    sourceBuilder.append("  public static void deleteAll() {\n");
    sourceBuilder.append(" \n");
    sourceBuilder.append("    Connection dbConnection = null;\n");
    sourceBuilder.append("    PreparedStatement preparedStatement = null;\n");
    sourceBuilder.append(" \n");
    sourceBuilder.append("    String deleteTableSQL = \"DELETE FROM " + project.getClassName().toLowerCase() + "\";\n");
    sourceBuilder.append(" \n");
    sourceBuilder.append("    try {\n");
    sourceBuilder.append("      dbConnection = getDBConnection();\n");
    sourceBuilder.append("      preparedStatement = dbConnection.prepareStatement(deleteTableSQL);\n");
    sourceBuilder.append(" \n");
    sourceBuilder.append("      // execute insert SQL stetement\n");
    sourceBuilder.append("      preparedStatement.executeUpdate();\n");
    sourceBuilder.append(" \n");
    sourceBuilder.append("      System.out.println(\"Records deleted from " + project.getClassName().toLowerCase()  + " table!\");\n");
    sourceBuilder.append("    } \n");
    sourceBuilder.append("    catch (SQLException e) {\n");
    sourceBuilder.append("      System.out.println(e.getMessage());\n");
    sourceBuilder.append("    } \n");
    sourceBuilder.append("    finally {\n");
    sourceBuilder.append("      try {\n");
    sourceBuilder.append("        if (preparedStatement != null) {\n");
    sourceBuilder.append("          preparedStatement.close();\n");
    sourceBuilder.append("        }\n");
    sourceBuilder.append("  \n");
    sourceBuilder.append("        if (dbConnection != null) {\n");
    sourceBuilder.append("          dbConnection.close();\n");
    sourceBuilder.append("        }\n");
    sourceBuilder.append("      }\n");
    sourceBuilder.append("      catch(SQLException e) {\n");
    sourceBuilder.append("        System.out.println(e.getMessage());\n");
    sourceBuilder.append("      }\n");
    sourceBuilder.append("    }\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("  }\n");
    sourceBuilder.append("\n");

  }

  public void toJson() {
    // toJson Method
    sourceBuilder.append("  public static String toJson(ArrayList<" + project.getClassName() + "> " + project.getClassName().toLowerCase() + "s) {\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("    // Convert list to JSON\n");
    sourceBuilder.append("    ObjectMapper mapper = new ObjectMapper();\n");
    sourceBuilder.append("    String json = \"\";\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("    try {\n");
    sourceBuilder.append("      json = mapper.writeValueAsString(" + project.getClassName().toLowerCase() + "s);\n");
    sourceBuilder.append("    }\n");
    sourceBuilder.append("    catch (Exception e) {\n");
    sourceBuilder.append("      e.printStackTrace();\n");
    sourceBuilder.append("    }\n");
    sourceBuilder.append("\n");
    sourceBuilder.append("    return json;\n");
    sourceBuilder.append("  }\n");

  }

  /**
   * @param project the project to set
   */
  public void setProject(Project project) {
    this.project = project;
  }

  /**
   * @return the project
   */
  public Project getProject() {
    return project;
  }

  /**
   * @param sourceBuilder the sourceBuilder to set
   */
  public void setSourceBuilder(StringBuilder sourceBuilder) {
    this.sourceBuilder = sourceBuilder;
  }

  /**
   * @return the sourceBuilder
   */
  public StringBuilder getSourceBuilder() {
    return sourceBuilder;
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
