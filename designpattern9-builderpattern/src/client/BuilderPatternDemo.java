package client;

import builder.JSONBuilder;
import builder.XMLBuilder;
import director.DocumentReader;

public class BuilderPatternDemo {
   public static void main(String[] args) {
      System.out.println("[DBG] Convert a document to two different formats.\n");

      String text = "NAME:John Smith,ADDRESS:67th Street Omaha NE,PHONE:402-111-1111";
      System.out.println("[DBG]  Original format: \n\n" //
            + text + "\n");

      // XMLBuilder is an object that constructs XMLProduct.
      XMLBuilder xmlBuilder = new XMLBuilder();
      DocumentReader docReader = new DocumentReader(xmlBuilder);
      docReader.build(text);
      System.out.println("[DBG] XML format: " + "\n");
      System.out.println(docReader.getResult());
      
      System.out.println();

      // JSONBuilder is an object that constructs JSONProduct.
      JSONBuilder jsonBuilder = new JSONBuilder();
      docReader = new DocumentReader(jsonBuilder);
      docReader.build(text);
      System.out.println("[DBG] JSON format: " + "\n");
      System.out.println(docReader.getResult());
   }
}
