package com.perficient.ics.ics.controller;

import java.io.IOException;



import java.util.*;
import java.net.*;
import java.io.*;
import java.sql.*;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.perficient.ics.ics.model.Agent;

@WebServlet(
    name = "IcsController", 
    urlPatterns = {"/ics"}
  )

public class IcsController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ServletOutputStream out = resp.getOutputStream();

    ArrayList<Agent> agents = null;
    try {
      agents = Agent.list();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }

    String json = Agent.toJson(agents);
    out.write(json.getBytes());
    
    out.flush();
    out.close();
  }
}
