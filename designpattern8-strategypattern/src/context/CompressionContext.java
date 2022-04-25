package context;
import java.util.List;

import strategy.CompressionStrategy;

public class CompressionContext {
   CompressionStrategy strategy;

   // Determined at runtime by the preferences
   public void setCompressionStrategy(CompressionStrategy strategy) {
      this.strategy = strategy;
   }

   // Use the determined compression strategy
   public void createArchive(List<String> files) {
      strategy.compressFiles(files);
   }
}