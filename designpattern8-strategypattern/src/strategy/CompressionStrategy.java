package strategy;
import java.util.List;

// Define a family of compression algorithms
public interface CompressionStrategy {
	public void compressFiles(List<String> files);
}