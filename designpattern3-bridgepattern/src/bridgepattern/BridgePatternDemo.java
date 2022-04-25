package bridgepattern;

import java.util.Scanner;

import bridgepattern.abstraction.DocumentReader;
import bridgepattern.abstraction.Reader;
import bridgepattern.impl.MSWordReaderConcreteImpl;
import bridgepattern.impl.PDFReaderConcreteImpl;

public class BridgePatternDemo {
   private static Scanner scanner;

   public BridgePatternDemo() {
      scanner = new Scanner(System.in);
   }

   public static void main(String[] args) {
      BridgePatternDemo demo = new BridgePatternDemo();
      Reader docReader;
      while (true) {
         showMenuOptions();

         switch (demo.getOption()) {
         case 1:
            System.out.println("[DBG] Executing ...");
            docReader = new DocumentReader(new PDFReaderConcreteImpl());
            docReader.read("mypdf.pdf");
            break;
         case 2:
            System.out.println("[DBG] Executing ...");
            docReader = new DocumentReader(new MSWordReaderConcreteImpl());
            docReader.read("mymsword.docx");
            break;
         case 3:
            System.out.println("[DBG] Executing ...");
            docReader = new DocumentReader(null);
            docReader.read("mypowerpointslides.pptx");
            break;
         default:
            break;
         }
      }
   }

   int getOption() {
      int input = scanner.nextInt();
      if (input < 0 || input > 4) {
         System.out.println("You have entered an invalid selection, please try again\n");
      } else if (input == 4) {
         System.out.println("You have quit the program\n");
         System.exit(1);
      } else {
         System.out.println("You have entered " + input + "\n");
         return input;
      }
      return 0;
   }

   static void showMenuOptions() {
      System.out.println("=============================================");
      System.out.println("Simple Adapter Pattern Example Program");
      System.out.println("=============================================");
      System.out.println("\tMenu Options:");
      System.out.println("\t1. Read PDF");
      System.out.println("\t2. Read MS Word");
      System.out.println("\t3. Read MS PPT");
      System.out.println("\t4. Exit the program");
      System.out.println("=============================================");
      System.out.print("Please select an option:");
   }
}