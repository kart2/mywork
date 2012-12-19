package com.perficient.tabasco.controller;

import java.util.*;
import java.net.*;
import java.io.*;
import java.sql.*;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.perficient.tabasco.model.Product;

/**
 * @author ubuntu
 * 
 */

@WebServlet(
    name = "ProductInitController", 
    urlPatterns = {"/product-init"}
  )

public class ProductInitController extends Controller {

  @Override
  public void doController(HttpServletRequest req, HttpServletResponse resp) {
    Product.init();

    try {
      ServletOutputStream out = resp.getOutputStream();
      out.write("{ \"message\" : \"Product database re-created.\" }".getBytes());
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
}


