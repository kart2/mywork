package com.perficient.tabasco.controller;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.perficient.tabasco.model.Product;

/**
 * @author ubuntu
 * 
 */

public class TabascoController {

  public static ArrayList<Product> products = new ArrayList<Product>();

  public static void main(String[] args) {
    TabascoController tabascoController = new TabascoController();
  }

  public TabascoController() {
  }

}
