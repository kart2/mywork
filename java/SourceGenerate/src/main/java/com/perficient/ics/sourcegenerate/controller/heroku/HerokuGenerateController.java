package com.perficient.ics.sourcegenerate.controller.heroku;

import java.util.*;
import java.net.*;
import java.io.*;

import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.perficient.ics.sourcegenerate.model.*;

public class HerokuGenerateController {
  public static void main( String[] args ) {
    int length = args.length;

    if (length != 1) {
      System.out.println("Usage: JavaSourceController <JSON File>");
      System.out.println("JSON file should contain:\n");
      System.out.println("  {");
      System.out.println("    \"name\" :  \"myproject\"");
      System.out.println("  }");
      System.exit(-1);
    }

    String jsonFileName = args[0];

    System.out.println("JSON File: " + jsonFileName + "\n");

    ObjectMapper mapper = new ObjectMapper();

    Project project = null;
    try {
      project = mapper.readValue(new File(jsonFileName), Project.class);
    }
    catch(Exception e) {
      e.printStackTrace();
    }

    WebPomCreateController      pomCreate           = new WebPomCreateController(project);
    ModelCreateController       modelCreate         = new ModelCreateController(project);
    PojoCreateController        pojoCreate          = new PojoCreateController(project);
    PojoPersistCreateController pojoPersistCreate   = new PojoPersistCreateController(project);
    WebListCreateController     webListCreate       = new WebListCreateController(project);
    WebIndexJspCreateController webIndexJspCreate   = new WebIndexJspCreateController(project);
    WebCreateController webCreate                   = new WebCreateController(project);
    WebMainJavascriptCreateController webMainJavascriptCreate   = new WebMainJavascriptCreateController(project);
    WebLaunchCreateController webLaunchCreate   = new WebLaunchCreateController(project);

    try {
      String zipFile = project.getProjectName() + ".zip";
      // Create zip file
      FileOutputStream outputStream = new FileOutputStream(zipFile);

      // Create object of ZipOutputStream from FileOutputStream
      ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);

      // Create pom.xml
      zipOutputStream.putNextEntry(new ZipEntry(project.getProjectName() + "/pom.xml"));

      zipOutputStream.write(pomCreate.getSource().getBytes());
      zipOutputStream.closeEntry();

      // Create Model
      zipOutputStream.putNextEntry(new ZipEntry(project.getProjectName() + "/src/main/java/com/perficient/ics/" + project.getProjectName().toLowerCase() + "/model/Model.java"));
      zipOutputStream.write(modelCreate.getSource().getBytes());
      zipOutputStream.closeEntry();

      // Create Pojo
      zipOutputStream.putNextEntry(new ZipEntry(project.getProjectName() + "/src/main/java/com/perficient/ics/" + project.getProjectName().toLowerCase() + "/model/" + project.getClassName() + ".java"));

      zipOutputStream.write(pojoCreate.getSource().getBytes());
      zipOutputStream.closeEntry();

      // Create PojoPersist
      zipOutputStream.putNextEntry(new ZipEntry(project.getProjectName() + "/src/main/java/com/perficient/ics/" + project.getProjectName().toLowerCase() + "/model/" + project.getClassName() + "Persist.java"));

      zipOutputStream.write(pojoPersistCreate.getSource().getBytes());
      zipOutputStream.closeEntry();

      // Create WebListController
      zipOutputStream.putNextEntry(new ZipEntry(project.getProjectName() + "/src/main/java/com/perficient/ics/" + project.getProjectName().toLowerCase() + "/controller/" + project.getClassName() + "ListController.java"));

      zipOutputStream.write(webListCreate.getSource().getBytes());
      zipOutputStream.closeEntry();

      // Create Index JSP
      zipOutputStream.putNextEntry(new ZipEntry(project.getProjectName() + "/src/main/webapp/index.jsp"));

      zipOutputStream.write(webIndexJspCreate.getSource().getBytes());
      zipOutputStream.closeEntry();

      // Create Main Javascript Controller
      zipOutputStream.putNextEntry(new ZipEntry(project.getProjectName() + "/src/main/webapp/javascript/main-controller.js"));

      zipOutputStream.write(webMainJavascriptCreate.getSource().getBytes());
      zipOutputStream.closeEntry();

      // Create Web Launch
      zipOutputStream.putNextEntry(new ZipEntry(project.getProjectName() + "/src/main/java/com/perficient/ics/" + project.getProjectName().toLowerCase() + "/launch/Main.java"));

      zipOutputStream.write(webLaunchCreate.getSource().getBytes());
      zipOutputStream.closeEntry();

      // Create WebCreateController
      zipOutputStream.putNextEntry(new ZipEntry(project.getProjectName() + "/src/main/java/com/perficient/ics/" + project.getProjectName().toLowerCase() + "/controller/" + project.getClassName() + "CreateController.java"));

      zipOutputStream.write(webCreate.getSource().getBytes());
      zipOutputStream.closeEntry();

      zipOutputStream.flush();
      outputStream.flush();

      zipOutputStream.close();
      outputStream.close();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }

  }
}
