package com.perficient.tabasco.controller;

import java.util.*;
import java.net.*;
import java.io.*;
import java.sql.*;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

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
    name = "ProductCreateController", 
    urlPatterns = {"/product-create"}
  )
public class ProductCreateController extends Controller {

  @Override
  public void doController(HttpServletRequest req, HttpServletResponse resp) {
    // Create a new instance of the Firefox driver
    WebDriver driver = new FirefoxDriver();
    driver.get("http://www.lowes.com");

    ArrayList<Product> products = new ArrayList<Product>();

    ArrayList<String> productSearchArray = new ArrayList<String>();

    productSearchArray.add("snow blower");
    productSearchArray.add("fertilizer");
    
    driver.manage().deleteAllCookies();
    try {
      // Enter zipcode
      WebElement zipcode = driver.findElement(By.xpath(".//*[@id='nav-search-input']"));
      zipcode.sendKeys("28117");
      zipcode.submit();
    } 
    catch (Exception ex) {
    }

    for (String searchString : productSearchArray) {
      this.getProducts(driver, products, searchString);
    }
    driver.quit();

    Product.deleteAll();
    Product.create(products);

    try {
      ServletOutputStream out = resp.getOutputStream();
      out.write("{ \"message\" : \"Products created.\" }".getBytes());
    }
    catch(Exception e) {
      e.printStackTrace();
    }

  }

  /**
   * @param product
   */
  public void getProducts(WebDriver driver, ArrayList<Product> products, String searchString) {
    
    // Search for product
    WebElement searchOne = driver.findElement(By.name("Ntt"));
    searchOne.sendKeys(searchString);
    searchOne.submit();

    WebElement productList = driver.findElement(By.id("productResults"));
    List<WebElement> productInfoList = productList.findElements(By.className("productWrapper"));
    System.out.println("Product count: " + String.valueOf(productInfoList.size()));

    int productStartIndex = products.size();

    for (WebElement productInfo : productInfoList) {
      try {
        Product product = new Product();
        // find product name
        WebElement productName = productInfo.findElement(By.name("listpage_productname"));
        product.setName(productName.getText());

        // find item num and model num
        WebElement productInfoDetail = productInfo.findElement(By.className("productInfo"));
        List<WebElement> allproductInfos = productInfoDetail.findElements(By.tagName("li"));

        String[] str = allproductInfos.get(0).getText().split(":");
        product.setItem(str[(str.length - 1)]);
        str = allproductInfos.get(1).getText().split(":");
        product.setModel(str[(str.length - 1)]);

        // find product Description
        WebElement productDescription = productInfo.findElement(By.className("prod-detail"));
        product.setDescription(productDescription.getText());

        // find product price
        WebElement productPrice = productInfo.findElement(By.xpath("./div[3]/p/strong"));
        String priceString = productPrice.getText();
        priceString = priceString.replaceAll("\\$", "");
        priceString = priceString.replaceAll(",", "");
        product.setPrice((new Double(priceString).doubleValue()));

        // find product url
        WebElement productUrl = productInfo.findElement(By.xpath("./div[2]/h3/a"));
        String productUrlString = productUrl.getAttribute("href");
        product.setUrl(productUrlString);

        products.add(product);
      } 
      catch (Exception e) {
        e.printStackTrace();
      }

    }

  }

}


