import java.io.IOException;
import java.io.RandomAccessFile;

public class IndexOperations implements Operations{
	IndexOperations(RandomAccessFile file_name)
	{
		
	}
	
	public static int binarySearch(RandomAccessFile index_file, int searchedProductID) throws IOException
	{
		index_file.seek(index_file.length());
		
		int left = 0, right = ((int)index_file.length())/8;
		
		while(left <= right)
		{
			int middle = left + (right - 1) / 2;
			Index.readIndexFile(index_file, middle * 8);
			
			if(Index.getKey() == searchedProductID) 
			{
				
				return Index.getOffset();
			}
			
			if( Index.getKey() <  searchedProductID ) 
			{
				left = middle + 1;
				System.out.println("searched value is larger than middle one");
			}
			
			else
			{
				right = middle - 1;	
				System.out.println("searched value is smaller than middle one");
			}
		}
		
		return -1;	//element not found
		
	}

	
	public void shiftDown() 
	{
		
		// TODO Auto-generated method stub
		
	}
	

	public void shiftUp() 
	{
		// TODO Auto-generated method stub
		
	}

	
	public void getRecord(RandomAccessFile file, int byteOffset) {
		
	}
	
	public void writeRecord(RandomAccessFile file) 
	{
		
		
	}

	public void removeRecord(RandomAccessFile file) 
	{
		// TODO Auto-generated method stub
		
	}

	
	
}
