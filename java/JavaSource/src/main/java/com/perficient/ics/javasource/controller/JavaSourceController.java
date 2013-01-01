package com.perficient.ics.javasource.controller;

import java.util.*;
import java.net.*;
import java.io.*;

public class JavaSourceController {
  public static void main( String[] args ) {
    int length = args.length;
     
    if (length <= 0) {
      System.out.println("You need to enter some arguments.");  
    }

    for (int i = 0; i < length; i++) {
      System.out.println(args[i]);
     
    }
  }  
}
  



