import java.io.*;
import java.util.ArrayList;

public class Database {

	public static ArrayList<String> readfile(String filename) {
		ArrayList<String> db = new ArrayList<String>(); // create new arraylist
		  try
		  {
		    BufferedReader reader = new BufferedReader(new FileReader(filename));
		    String line;
		    while ((line = reader.readLine()) != null)
		    {
		      db.add(line);
		    }
		    reader.close();
		    return db;}
		  catch (Exception e) // debug
		  {
		    System.err.format("Does not exist");
		    return null;
		  }
		  
	}
	public static void savefile(String filename, ArrayList<String> db) {
		File file = new File(filename);
		try {
			FileWriter filewrite = new FileWriter(file);
			BufferedWriter bufferwrite = new BufferedWriter(filewrite);
            bufferwrite.write(db.toString().replace("[", "").replace("]", ""));
            bufferwrite.close();
		}
		catch (Exception e) // debug
		  {
		    System.err.format("Error");
		  }
	}
	
	public static void main(String args[]) { // debug function
		ArrayList<String> items = database.readfile("src/MovieBooking/db.txt");
		System.out.println(items); //test readfile
		ArrayList<String> testlines = new ArrayList<String>();
		testlines.add("Test 1");
		testlines.add("Test 2");
		savefile("src/MovieBooking/db.txt", testlines);
		items = database.readfile("src/MovieBooking/db.txt");
		System.out.println(items); //test readfile
	}
}
