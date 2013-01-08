package com.perficient.ics.sourcefeed.controller;

import java.util.*;
import java.io.*;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;

import org.apache.commons.lang.StringUtils;

import com.perficient.ics.sourcefeed.model.*;

public class SourceFeedController {
  public static void main( String[] args ) {

    int length = args.length;

    if (length != 1) {
      System.out.println("Usage: JavaSourceController <JSON File>");
      System.out.println("JSON file should contain:\n");
      System.out.println("  {");
      System.out.println("    \"name\" :  \"myproject\"");
      System.out.println("  }");
      System.exit(-1);
    }

    String jsonFileName = args[0];

    System.out.println("JSON File: " + jsonFileName + "\n");

    ObjectMapper mapper = new ObjectMapper();
    Project project = null;
    try {
      project = mapper.readValue(new File(jsonFileName), Project.class);
    }
    catch(Exception e) {
      e.printStackTrace();
    }

    String command = "perl ./target/classes/source-feed.pl " + project.getFromSource().getFileName() + ' ' + project.getFromSource().getProjectName() + ' ' + project.getFromSource().getPackageName() + ' ' + project.getFromSource().getClassName() + ' ' + project.getToSource().getFileName() + ' ' + project.getToSource().getProjectName() + ' ' + project.getToSource().getPackageName() + ' ' + project.getToSource().getClassName();
    System.out.println(command);
    
    CommandLine cmdLine = CommandLine.parse("perl ./target/classes/source-feed.pl " + project.getFromSource().getFileName() + ' ' + project.getFromSource().getProjectName() + ' ' + project.getFromSource().getPackageName() + ' ' + project.getFromSource().getClassName() + ' ' + project.getToSource().getFileName() + ' ' + project.getToSource().getProjectName() + ' ' + project.getToSource().getPackageName() + ' ' + project.getToSource().getClassName() );


    DefaultExecutor executor = new DefaultExecutor();

    try {
      int exitValue = executor.execute(cmdLine);
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }

  }
}
