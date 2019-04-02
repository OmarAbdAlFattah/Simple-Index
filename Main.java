import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) throws IOException {
		
		RandomAccessFile index_file = new RandomAccessFile("index.bin", "rw");
		RandomAccessFile data = new RandomAccessFile("SampleDataFile.bin", "rw");
		Index index = new Index(data, index_file);
		Data.displayFileContent(data);
		
		Scanner in = new Scanner(System.in);
		int searchProdID = in.nextInt();
		System.out.println(IndexOperations.binarySearch(index_file, searchProdID));
		
	}
}
