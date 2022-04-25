package strategy;
import java.util.List;

// Make the compression algorithms interchangeable within the family
public class RarStrategy implements CompressionStrategy {
	public void compressFiles(List<String> files) {
		System.out.println("Use RAR Compression Strategy:");
		for (String iFile : files) {
			System.out.println("\t" + iFile);
		}
	}
}