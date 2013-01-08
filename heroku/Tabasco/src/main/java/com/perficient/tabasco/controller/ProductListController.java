package com.perficient.tabasco.controller;

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

import com.perficient.tabasco.model.Product;

@WebServlet(
    name = "ProductListController", 
    urlPatterns = {"/product-list"}
  )

public class ProductListController extends Controller {
  @Override
  public void doController(HttpServletRequest request, HttpServletResponse resp) {

    // Get parameters
    // rows=32&page=2&sidx=name&sord=desc
    int page          = 0;
    int rowCount      = 0;
    String sortColumn = "";
    String sortOrder  = "";

    if( request.getParameterMap().containsKey("page")) {
      page = Integer.valueOf(request.getParameter("page").toString());
    }
    if( request.getParameterMap().containsKey("rows")) {
      rowCount = Integer.valueOf(request.getParameter("rows").toString());
    }
    if( request.getParameterMap().containsKey("sidx")) {
      sortColumn = request.getParameter("sidx").toString();
    }
    if( request.getParameterMap().containsKey("sord")) {
      sortOrder = request.getParameter("sord").toString();
    }

    ArrayList<Product> products = null;
    try {
      products = Product.list();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }

    try {
      ServletOutputStream out = resp.getOutputStream();
      //String json = Product.toJsonGrid(products, page, rowCount);
      String json = Product.toJsonGrid(products);
      out.write(json.getBytes());
    
      out.flush();
      out.close();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
}
