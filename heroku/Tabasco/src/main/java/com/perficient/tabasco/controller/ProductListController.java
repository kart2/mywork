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
  public void doController(HttpServletRequest req, HttpServletResponse resp) {

    ArrayList<Product> products = null;
    try {
      products = Product.list();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }

    try {
      ServletOutputStream out = resp.getOutputStream();
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
