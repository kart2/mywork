package com.perficient.ics.sourcegenerate.controller.java;

import java.util.*;
import java.net.*;
import java.io.*;
import org.apache.commons.lang.WordUtils;

import com.perficient.ics.sourcegenerate.model.*;

public class PomController {
  private String source;
  public PomController(Project project) {

    StringBuilder sourceBuilder = new StringBuilder();

    sourceBuilder.append("<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n");
    sourceBuilder.append("  xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd\">\n");
    sourceBuilder.append("  <modelVersion>4.0.0</modelVersion>\n");
    sourceBuilder.append("  <groupId>com.perficient.ics." + project.getProjectName().toLowerCase() + "</groupId>\n");
    sourceBuilder.append("  <artifactId>" + project.getProjectName() + "</artifactId>\n");
    sourceBuilder.append("  <packaging>jar</packaging>\n");
    sourceBuilder.append("  <version>1.0-SNAPSHOT</version>\n");
    sourceBuilder.append("  <name>" + project.getProjectName() + "</name>\n");
    sourceBuilder.append("  <url>http://maven.apache.org</url>\n");
    sourceBuilder.append("  <dependencies>\n");
    sourceBuilder.append("    <dependency>\n");
    sourceBuilder.append("      <groupId>org.apache.commons</groupId>\n");
    sourceBuilder.append("      <artifactId>commons-exec</artifactId>\n");
    sourceBuilder.append("      <version>1.1</version>\n");
    sourceBuilder.append("    </dependency>\n");
    sourceBuilder.append("    <dependency>\n");
    sourceBuilder.append("      <groupId>commons-lang</groupId>\n");
    sourceBuilder.append("      <artifactId>commons-lang</artifactId>\n");
    sourceBuilder.append("      <version>2.6</version>\n");
    sourceBuilder.append("    </dependency>\n");
    sourceBuilder.append("    <dependency>\n");
    sourceBuilder.append("      <groupId>org.codehaus.jackson</groupId>\n");
    sourceBuilder.append("      <artifactId>jackson-mapper-asl</artifactId>\n");
    sourceBuilder.append("      <version>1.9.9</version>\n");
    sourceBuilder.append("    </dependency>\n");
    sourceBuilder.append("  </dependencies>\n");
    sourceBuilder.append("  <build>\n");
    sourceBuilder.append("    <plugins>\n");
    sourceBuilder.append("      <plugin>\n");
    sourceBuilder.append("        <artifactId>maven-assembly-plugin</artifactId>\n");
    sourceBuilder.append("        <configuration>\n");
    sourceBuilder.append("          <archive>\n");
    sourceBuilder.append("            <manifest>\n");
    sourceBuilder.append("              <mainClass>com.perficient.ics." + project.getProjectName().toLowerCase() + ".controller." + project.getProjectName() + "Controller</mainClass>\n");
    sourceBuilder.append("            </manifest>\n");
    sourceBuilder.append("          </archive>\n");
    sourceBuilder.append("          <descriptorRefs>\n");
    sourceBuilder.append("            <descriptorRef>jar-with-dependencies</descriptorRef>\n");
    sourceBuilder.append("          </descriptorRefs>\n");
    sourceBuilder.append("        </configuration>\n");
    sourceBuilder.append("      </plugin>\n");
    sourceBuilder.append("    </plugins>\n");
    sourceBuilder.append("  </build>\n");
    sourceBuilder.append("</project>\n");

    this.source = sourceBuilder.toString();
  }

  /**
   * @param source the source to set
   */
  public void setSource(String source) {
    this.source = source;
  }

  /**
   * @return the source
   */
  public String getSource() {
    return source;
  }
}
