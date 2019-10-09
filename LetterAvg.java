import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LetterAvg {
private char letter;
public String fileName = "Mesonet.txt";
private int numStations;
private int intialCapacity = 1;
private int capacity;
private String[] stationid;

public LetterAvg(char letter) {
	this.letter=letter;
	 this.capacity = intialCapacity;
	 this.numStations = 0;
	 this.stationid = new String[intialCapacity];
	 try
	{
		read(fileName);
	}
	catch(IOException e)
	{
		System.out.println("Error reading from file!\n");
		e.printStackTrace();
	}
}
private void expandStation()
{
    // TODO: complete this...
	
	String[] newArray = new String[capacity*2];
    
    for (int i = 0; i < capacity; ++i) 
    {
        newArray[i] = this.stationid[i];
    }
    // Update the reference and values
    capacity *= 2;
    this.stationid = newArray;
}

public void read(String filename) throws IOException {
 
	BufferedReader br = new BufferedReader(new FileReader(fileName));
	String strg;
	strg = br.readLine();
	strg = br.readLine();
	strg = br.readLine();
	strg = br.readLine();
	while(strg != null)
	{
		
		String[] idInfo = strg.split("  ");
		String id = idInfo[0];
		id = id.substring(1);
		if (numStations == capacity) 
		{

			expandStation();
		}
		stationid[numStations] = id;
		numStations++;
	
	
		// Get the next line of the file
		strg = br.readLine();
	}
	// Make sure to close the Reader once done parsing the file
	br.close();
}

public int numberOfStationWithLetterAvg() {
	 int count = 0;
	 for (int x = 0; x < numStations; x ++) {
		  String currStation = stationid[x];
	 for (int i = 0; i < 1; i++) {
		 
		  if (letter == currStation.charAt(i)) {
		   count+=1;
		  }
		 
	 }
	 }
	  
	 return count;
}
public String toString() 
{
 String Line = "They are:\n" +stationid[46] + "\n" + stationid[47] + "\n" + stationid[48] + "\n" + stationid[49] + "\n"
		 + stationid[50] + "\n" + stationid[51] + "\n" + stationid[52] + "\n" + stationid[53];

 
 return Line;
 
}
}
