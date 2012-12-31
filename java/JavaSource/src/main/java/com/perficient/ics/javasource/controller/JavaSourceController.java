package com.perficient.ics.javasource.controller;

import java.util.*;
import java.net.*;
import java.io.*;

/**
 * JavaSourceController
 *
 */
public class JavaSourceController {
  public static void main( String[] args ) {

    boolean importValue = false;

    String projectName = "";
    String importName = "";
    String className = "";

    ArrayList<String> importArray = new ArrayList<String>();

    try {
      java.io.BufferedReader stdin = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
      
    while(importValue == false) {
      System.out.print("Enter import: ");
      importName = stdin.readLine();
      importArray.add(importName);

      if(importName.length() == 0) {
        importValue = true;
        break;
      }
    }

      System.out.print("Enter project name: ");
      projectName = stdin.readLine();

      System.out.print("Enter class name: ");
      className = stdin.readLine();
    }
    catch(Exception e) {
      System.out.println(e);
    }

    StringBuilder sourceBuilder = new StringBuilder();
    Iterator iter = importArray.iterator();

    while(iter.hasNext()) {

    sourceBuilder.append("import ")
    		 .append(iter.next() + ";\n\n");
    }

    sourceBuilder.append("package com.perficient.ics.")
                 .append(projectName + ";\n\n");

    sourceBuilder.append("public class ")
                 .append(className + " {\n");
    
    sourceBuilder.append("  public static void main(String[] args) {\n");
    sourceBuilder.append("    System.out.println(\"Java Source Generator\");\n");
    sourceBuilder.append("  }\n");
    sourceBuilder.append("}\n");

    System.out.println(sourceBuilder.toString());
  }
}
