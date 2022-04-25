package client;
import java.util.Arrays;
import java.util.Scanner;

import context.CompressionContext;
import strategy.RarStrategy;
import strategy.ZipStrategy;

public class StrategyPatternDemo {
   public static void main(String[] args) {
      // Encapsulate each compression algorithm
      CompressionContext ctx = new CompressionContext();
      // Create a scanner to read the command-line input
      Scanner scanner = new Scanner(System.in);

      // Prompt for the compression type.
      System.out.print("Enter Compression Type (e.g., zip or rar) : ");
      // Get the input
      String compressionType = scanner.next();

      // Context is set by preferences
      // Each case is unknown until runtime
      if (compressionType.equals("zip")) {
          ctx.setCompressionStrategy(new ZipStrategy());
      } else if (compressionType.equals("rar")) {
          ctx.setCompressionStrategy(new RarStrategy());
      }
      // Prompt for the file list to be compressed.
      System.out.print("Enter File Names (e.g., file1.mp3,file2.mp3) : ");
      // Get the input
      String[] files = scanner.next().split(",");
      ctx.createArchive(Arrays.asList(files));
      scanner.close();
      System.out.print("Compressed.");
  }
}
