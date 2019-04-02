import java.io.RandomAccessFile;

public interface Operations {
	
	public void shiftDown();
	public void shiftUp();

	public void getRecord(RandomAccessFile file, int byteOffset);
	public void writeRecord(RandomAccessFile file);
	public void removeRecord(RandomAccessFile file);
	
	
}
