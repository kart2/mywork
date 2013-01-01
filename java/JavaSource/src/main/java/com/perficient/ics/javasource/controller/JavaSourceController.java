package com.perficient.ics.javasource.controller;

import java.util.*;
import java.net.*;
import java.io.*;

import java.io.File;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.perficient.ics.javasource.model.*;

public class JavaSourceController {
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

    ModelCreateController modelCreate = new ModelCreateController(project);
  }  
}

