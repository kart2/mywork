package com.perficient.ics.javasource.controller;

import java.util.*;
import java.net.*;
import java.io.*;

public class JavaSourceController {
  public static void main( String[] args ) {
    int length = args.length;
     
    if (length != 1) {
      System.out.println("Usage: JavaSourceController <JSON File>");  
      System.exit(-1);
    }

    String jsonFileName = args[0];

    System.out.println("JSON File: " + jsonFileName + "\n");

    ModelCreateController modelCreate = new ModelCreateController();
  }  
}

