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

public class ProductInitController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Product.init();
    try {
      RequestDispatcher dispatcher = req.getRequestDispatcher("/");
      dispatcher.forward(req, resp);
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
}


