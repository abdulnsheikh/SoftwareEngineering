package strategy;
import java.util.List;

// Make the compression algorithms interchangeable within the family
public class ZipStrategy implements CompressionStrategy {
	public void compressFiles(List<String> files) {
		System.out.println("Use ZIP Compression Strategy:");
		for (String iFile : files) {
			System.out.println("\t" + iFile);
		}
	}
}