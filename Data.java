import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

public class Data {
 private int Product_ID;
 private int Product_Price;
 private int Product_quantity;

	public int getProduct_ID()
	{
		return Product_ID;
	}
	public void setProduct_ID(int Product_ID) {
		this.Product_ID = Product_ID;
	}
	public int getProduct_Price() {
		return Product_Price;
	}
	public void setProduct_Price(int product_Price) {
		Product_Price = product_Price;
	}
	public int getProduct_quantity() {
		return Product_quantity;
	}	
	public void setProduct_quantity(int product_quantity) {
		Product_quantity = product_quantity;
	}

	public static Map<Integer, Integer> readData(RandomAccessFile data) throws IOException
	{
		Map<Integer, Integer> unsortedMap = new HashMap<Integer, Integer>();
		int len = (int) data.length();
		data.seek(len);
		int eof = (int) data.getFilePointer();
		for(int dataCount = 0; dataCount < len; dataCount += 12)
		{
			//System.out.println("read data function accessed");
			data.seek(dataCount);
			unsortedMap.put(data.readInt(), ((int) data.getFilePointer()) - 4);
		}
		
		return unsortedMap;
	}
	
	public static void displayFileContent(RandomAccessFile data_file) throws IOException
	{	
		int len1 = (int) data_file.length();
		data_file.seek(len1);
		int eof = (int) data_file.getFilePointer();
		data_file.seek(0);
		System.out.println("Data File: ");
		while(data_file.getFilePointer() != eof)
		{
			System.out.print("ProductID: "+data_file.readInt() + " ");
			System.out.print("ProductPrice: "+data_file.readInt() + " ");
			System.out.println("ProductQuantity: "+data_file.readInt());
		}
	}
}
