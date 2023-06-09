package com.utils;

public class Utilities {
  private static final int NUM = 11;

private static void findJavaFiles(File parentDirectory, List<File> files) {
  for (File file : parentDirectory.listFiles()) {
    if (file.getName().endsWith(".java"))
      files.add(file);   
    else if (file.getName().endsWith(".javac"))
      findOldJavaFiles(file, files);
      
    else if (file.getName().endsWith(".txt"))
      findOtherFiles(file, files);
  }
}


public int getMedianLineWidth() {
  Integer[] sortedWidths = getSortedWidths();
  int cumulativeLineCount = 0;
  
  for (int width : sortedWidths) {
    cumulativeLineCount += lineCountForWidth(width);
    if (cumulativeLineCount > lineCount/2) 
      return width;
    else 
     return 0;
  }
  throw new Error("Cannot get here");
}


private Integer[] getSortedWidths() {
  Set<Integer> widths = lineWidthHistogram.getWidths();
  Integer[] sortedWidths = (widths.toArray(new Integer[0]));
  Arrays.sort(sortedWidths);

  return sortedWidths;
}

private static void findOldJavaFiles(File parentDirectory, List<File> files) {
  for (File file : parentDirectory.listFiles()) {
    if (file.getName().endsWith(".javac"))
      files.add(file); 
  }
}

private static void findOtherFiles(File parentDirectory, List<File> files) {
  for (File file : parentDirectory.listFiles()) {
    if (file.getName().endsWith(".javad"))
      files.add(file);   
  }
}
}
