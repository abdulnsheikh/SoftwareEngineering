package client;

import java.util.Scanner;

import factory.GUIAbstractFactory;
import factory.OSXGUIFactory;
import factory.WinGUIFactory;

public class AbstractFactoryDemo {
   private static Scanner scanner;

   public AbstractFactoryDemo() {
      scanner = new Scanner(System.in);
   }

   public static void main(String[] args) {
      AbstractFactoryDemo demo = new AbstractFactoryDemo();
      demo.doStart();
   }

   void doStart() {
      while (true) {
         Application app = new Application(getFactoryType());
         app.paint();
         app.openShell();
      }
   }

   GUIAbstractFactory getFactoryType() {
      GUIAbstractFactory factory = null;
      showMenuOptions();
      switch (getOption()) {
      case 1:
         factory = new WinGUIFactory();
         break;
      case 2:
         factory = new OSXGUIFactory();
         break;
      default:
         break;
      }
      return factory;
   }

   int getOption() {
      int input = scanner.nextInt();
      if (input < 0 || input > 3) {
         System.out.println("You have entered an invalid selection, please try again\n");
      } else if (input == 3) {
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
      System.out.println("Simple Abstract Factory Pattern Example Program");
      System.out.println("=============================================");
      System.out.println("\tMenu Options:");
      System.out.println("\t1. Windows GUI Factory");
      System.out.println("\t2. OSX GUI Factory");
      System.out.println("\t3. Exit the program");
      System.out.println("=============================================");
      System.out.print("Please select an option:");
   }
}
