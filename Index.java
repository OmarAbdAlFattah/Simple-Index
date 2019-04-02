import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Map;
import java.util.TreeMap;

public class Index {
	private static int key;
	private static int offset;
	//private String fileName;
	
	Index(int key, int offset){
		this.key = key;
		this.offset = offset;
	}
	
	Index( RandomAccessFile data, RandomAccessFile index) throws IOException
	{
		
		Map<Integer, Integer> sortedMap = new TreeMap<Integer, Integer>(Data.readData(data));
		System.out.println("Index File:");
		for(Map.Entry<Integer, Integer> entry: sortedMap.entrySet()) 
		{
			index.writeInt(entry.getKey());
			index.writeInt(entry.getValue());
		}
		displayFileContent(index);

	}
	
	public static void displayFileContent(RandomAccessFile index) throws IOException
	{
		int len = (int) index.length();
		index.seek(len);
		int eof = (int) index.getFilePointer();
		index.seek(0);
		
		while(index.getFilePointer() != eof)
		{
		//	System.out.println("while loop accessed");
			System.out.print("ProductID: " + index.readInt() + " ");
			System.out.println("Offset: " + index.readInt());
		}
	}
	
	public static void readIndexFile(RandomAccessFile index_file, long ptr) throws IOException
	{
		index_file.seek(ptr);
		
		key = index_file.readInt();
		offset = index_file.readInt();
	}
	
	public void writeIndex(RandomAccessFile index_file, long ptr)
	{
		
	}
	
	public static int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public static int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}

}
