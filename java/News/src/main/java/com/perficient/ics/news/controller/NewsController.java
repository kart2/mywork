package com.perficient.ics.news.controller;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

/**
 * Hello world!
 *
 */
public class NewsController {
  public static void main( String[] args ) {
    try {
      URL url = new URL("http://sports.espn.go.com/espn/rss/news");
      HttpURLConnection httpcon = (HttpURLConnection)url.openConnection();
      // Reading the feed
      SyndFeedInput input = new SyndFeedInput();
      SyndFeed feed = input.build(new XmlReader(httpcon));
      List entries = feed.getEntries();
      Iterator itEntries = entries.iterator();
    
      while (itEntries.hasNext()) {
        SyndEntry entry = (SyndEntry) itEntries.next();
        System.out.println("Title: " + entry.getTitle());
        System.out.println("Link: " + entry.getLink());
        System.out.println("Author: " + entry.getAuthor());
        System.out.println("Publish Date: " + entry.getPublishedDate());
        System.out.println("Description: " + entry.getDescription().getValue());
        System.out.println();


        String description = entry.getDescription().getValue();
        int htmlLocation = description.indexOf("<");
  
        if(htmlLocation >= 0) {
          description = description.substring(0,htmlLocation);
        }
  
        description = description.replaceAll("\'","");
        description = description.replaceAll("\"","");
  
        CommandLine cmdLine = CommandLine.parse("say " + description);
        DefaultExecutor executor = new DefaultExecutor();
    
        int exitValue = executor.execute(cmdLine);
      }
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }

  }
}
