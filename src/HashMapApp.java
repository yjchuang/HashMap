import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class HashMapApp {

	public static void main(String[] args) {
		HashMap<Integer, String> myMap = new HashMap<Integer, String>();
		Scanner sc = new Scanner(System.in);
		Integer intKey;
		String stringValue = "";
		String fileName = "HashMap.txt";

		//reading from file
		readHashMapFromFile(fileName, myMap);

		String nextNumber = "y";

		while (nextNumber == "y")
		{
			System.out.print("Enter a number: ");
			intKey = sc.nextInt();

			if (myMap.containsKey(intKey))
			{
				stringValue = myMap.get(intKey);
				System.out.println(" You entered " + stringValue);
			}
			else
			{
				System.out.println("Enter Value: ");
				stringValue = sc.next();
				myMap.put(intKey, stringValue);
			}

			System.out.println("\nNext number? (y/n) ");
			if (sc.next().equalsIgnoreCase("n"))
			{
				//write to a file
				writeHashMapToFile(fileName, myMap);

				nextNumber = "n";					//write to file
			}

		}
		sc.close();

	}
	
	public static void readHashMapFromFile(String fileName, HashMap<Integer, String> _myMap)
	{
		int _key = 0;
		
		try
		{
			File file = new File(fileName);
			Scanner input = new Scanner(file);
			while (input.hasNextLine())
			{
				String _string = input.nextLine();
				String[] _stringValue = _string.split(" ");
				_key = Integer.parseInt(_stringValue[0]);
				_myMap.put(_key, _stringValue[1]);
			}
			input.close();
		}
		catch (IOException e)
		{
			//e.getMessage().toString();
			e.getMessage();

		}
		
	}

	public static void writeHashMapToFile(String fileName, HashMap<Integer, String> _myMap)
	{

		FileWriter fw= null;
		File file =null;
		try {
			file=new File(fileName);
			if(!file.exists()) {
				file.createNewFile();
			}
			fw = new FileWriter(file);
			for(int key : _myMap.keySet())
				fw.write(key + " " + _myMap.get(key) + "\n");
			fw.flush();
			fw.close();

		} catch (IOException e) {
			e.getMessage();
		}

	}

}
