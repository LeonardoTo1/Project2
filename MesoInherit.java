import java.lang.Math;
import java.util.Arrays;

public class MesoInherit extends MesoAbstract{
private int[] average;
private MesoStation stID;
private String ID;


	public MesoInherit(MesoStation stID) {
		average = new int[3];
		this.stID = stID;
		ID = stID.toString();
	}
	@Override
	 protected int[] calAverage() {
		// TODO Auto-generated method stub
		int ascii = 0;
		int calc;
		
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
				average[x] = calc;
				
			}
		}
		return average;
	}

	@Override
	protected char letterAverage() {
		// TODO Auto-generated method stub
		int ascii = 0;
		char average;
		for (int i = 0; i < ID.length(); i++) {
			char letter = ID.charAt(i);
			ascii += (int) letter;
		}
		average = (char) (ascii/4);
		return average;
	}
}
