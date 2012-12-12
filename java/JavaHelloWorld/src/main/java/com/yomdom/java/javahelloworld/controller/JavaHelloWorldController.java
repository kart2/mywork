package com.yomdom.java.javahelloworld.controller;

import java.util.*;
import java.net.*;
import java.io.*;

import org.codehaus.jackson.map.ObjectMapper; 
import org.codehaus.jackson.type.TypeReference;
import org.codehaus.jackson.map.type.TypeFactory;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;

import com.yomdom.java.javahelloworld.model.Contact;

/**
 * Hello world!
 *
 */
public class JavaHelloWorldController {

  public static void main( String[] args ) {
    JavaHelloWorldController controller = new JavaHelloWorldController();

    String line = "ls /opt";
    CommandLine cmdLine = CommandLine.parse(line);
    DefaultExecutor executor = new DefaultExecutor();
    //executor.setExitValue(1);
    try {
      int exitValue = executor.execute(cmdLine);
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }

    //controller.createContacts("http://yomdompxn.appspot.com");
    //controller.createContacts("http://localhost:8080");
  }

  public void createContacts(String baseUrl) {
    // Delete Contacts
    try {
      String urlString = baseUrl + "/contact_delete";
      System.out.println(urlString);
      URL url = new URL(urlString);
      URLConnection urlConnection = url.openConnection();
      BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
      String inputLine;
      while ((inputLine = in.readLine()) != null) 
        System.out.println(inputLine);
      in.close();
    }
    catch(Exception e) {
      e.printStackTrace();
    }

    ArrayList<Contact> contacts = new ArrayList<Contact>();
    contacts.add(new Contact("Sean Wright", "Sean Wright", "Innovation Team", "35.39", "-80.71"));
    contacts.add(new Contact("Brock Wright", "Brock Wright", "Innovation Team", "35.38", "-80.70"));
    contacts.add(new Contact("Shane Wright", "Shane Wright", "Innovation Team", "35.39", "-80.70"));
    contacts.add(new Contact("Noah Wright", "Noah Wright", "Innovation Team", "35.40", "-80.71"));
    contacts.add(new Contact("Jack Wright", "Jack Wright", "Innovation Team", "35.40", "-80.72"));
    contacts.add(new Contact("Caleb Eades", "Caleb Eades", "Innovation Team", "35.39", "-80.72"));

    // Convert list to JSON
    ObjectMapper mapper = new ObjectMapper();
    String json = "";

    try {
      json = mapper.writeValueAsString(contacts);
    } 
    catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("Json" + json);

    // Create Contacts
    try {
      String jsonEncoded = URLEncoder.encode(json, "UTF-8");
      String urlString = baseUrl + "/contact_create?operation=create&contacts=" + jsonEncoded;
      System.out.println(urlString);
      URL url = new URL(urlString);
      URLConnection urlConnection = url.openConnection();
      BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
      String inputLine;
      while ((inputLine = in.readLine()) != null) 
        System.out.println(inputLine);
      in.close();
    }
    catch(Exception e) {
      e.printStackTrace();
    }

  }

}
