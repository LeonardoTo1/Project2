import java.lang.Math;
import java.util.Arrays;

public class MesoInherit extends MesoAbstract{
private int[] average;
private MesoStation stID;
private String ID;


	public MesoInherit(MesoStation stID) {
		average = new int[3];
		this.stID = stID;
		ID = stID.getStID();
	}
	public MesoStation getID(){
		return stID;
	}
	 protected int[] calAverage() {
		// TODO Auto-generated method stub
		double ascii = 0;
		double calc;
		
		for (int i = 0; i < ID.length(); i++) {
			char letter = ID.charAt(i);
			ascii += (int) letter;
		}
		for (int x = 0; x < 3; x++) {
			calc = ascii/4;
			
			if(x == 0) {
				average[x] = (int) Math.ceil(calc);
				
			}
			else if(x == 1) {
				average[x] = (int) Math.floor(calc);
				
			}
			else {
			if(calc-(int)calc >= .5) {
				average[x] = (int) Math.ceil(calc);
			}
			else average[x] = (int) Math.floor(calc);
			}
		}
		return average;
	}

	@Override
	protected char letterAverage() {
		// TODO Auto-generated method stub
		double ascii = 0;
		double calc;
		char average;
		for (int i = 0; i < ID.length(); i++) {
			char letter = ID.charAt(i);
			ascii += (double) letter;
		}
		calc = ascii/4;
		if(calc-(int)calc >= .5) {
			average = (char) Math.ceil(calc);
		}
		else average = (char) Math.floor(calc);
		
		
		return average;
	}
}
