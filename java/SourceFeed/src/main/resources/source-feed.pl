#!/usr/bin/perl
use strict;
use FileHandle;

if(scalar(@ARGV) != 8) {
  die("Usage: $0 <file> <project name> <package name> <class name> <generate file name> <generate project name> <generate package name> <generate class name>\n");
}

my($fileName, $projectName, $packageName, $className, $generateFileName, $generateProjectName, $generatePackageName, $generateClassName ) = (@ARGV);

my $lcProjectName = lc($projectName);
my $lcClassName = lc($className);

my $generateFh = new FileHandle("> $generateFileName");

$generateFh->print('package ' . $generatePackageName . '.controller;' . "\n");
$generateFh->print('' . "\n");
$generateFh->print('import java.util.*;' . "\n");
$generateFh->print('import java.net.*;' . "\n");
$generateFh->print('import java.io.*;' . "\n");
$generateFh->print('import org.apache.commons.lang.WordUtils;' . "\n");
$generateFh->print('' . "\n");
$generateFh->print('import ' . $generatePackageName . '.model.*;' . "\n");
$generateFh->print('' . "\n");
$generateFh->print('public class ' . $generateClassName . ' {' . "\n");
$generateFh->print('  private String source;' . "\n");
$generateFh->print('  public ' . $generateClassName . '(Project project) {' . "\n");
$generateFh->print('' . "\n");
$generateFh->print('    StringBuilder sourceBuilder = new StringBuilder();' . "\n");
$generateFh->print('' . "\n");
$generateFh->print('    // Package' . "\n");

my $fh = new FileHandle($fileName);

while(my $line = $fh->getline()) {
  chomp($line);

  $line =~ s/"/\\"/g;

  $line =~ s/$packageName/" + project.getPackageName() + "/g;

  $line =~ s/$projectName/" + project.getProjectName() + "/g;
  $line =~ s/$lcProjectName/" + project.getProjectName().toLowerCase() + "/g;

  $line =~ s/$className/" + project.getClassName() + "/g;
  $line =~ s/$lcClassName/" + project.getClassName().toLowerCase() + "/g;

  $generateFh->print('    sourceBuilder.append("' . $line . '\n");' . "\n");
  
}

$fh->close();

$generateFh->print('    this.source = sourceBuilder.toString();' . "\n");
$generateFh->print('  }' . "\n");
$generateFh->print('' . "\n");
$generateFh->print('  /**' . "\n");
$generateFh->print('   * @param source the source to set' . "\n");
$generateFh->print('   */' . "\n");
$generateFh->print('  public void setSource(String source) {' . "\n");
$generateFh->print('    this.source = source;' . "\n");
$generateFh->print('  }' . "\n");
$generateFh->print('' . "\n");
$generateFh->print('  /**' . "\n");
$generateFh->print('   * @return the source' . "\n");
$generateFh->print('   */' . "\n");
$generateFh->print('  public String getSource() {' . "\n");
$generateFh->print('    return source;' . "\n");
$generateFh->print('  }' . "\n");
$generateFh->print('}' . "\n");

