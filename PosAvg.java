import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PosAvg {
	public String fileName = "Mesonet.txt";
	private int numStations;
	private int intialCapacity = 1;
	private int capacity;
	private String[] stationid;
	private String stID;
	
	public PosAvg(String stID) {
		 this.stID = stID;
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
	 public String getstID()
	   {
	      return stID;
	   }
	 
	 public int indexOfStation() {
		 int index = 0;
		 int count = 0;
		 for (int x = 0; x < numStations; x ++) {
			  String currStation = stationid[x];
		 for (int i = 0; i < stID.length(); i++) {
			 
			  if (stID.charAt(i) == currStation.charAt(i)) {
			   count+=1;
			  }
			 
		 }
		 if (count == 4) {
			 return x+1;
			   }
			 else count = 0;
		 }
		  
		 return index;
	 }
	 public String toString() 
	    {
		 int stationindex = indexOfStation()-1;
		 String Line = "This index is average of "+ stationid[stationindex-1] + " and " +stationid[stationindex+1] + ", "+ stationid[stationindex-2] +" and "+ stationid[stationindex+2] +", and so on.";

		 
		 return Line;

	    }
}
