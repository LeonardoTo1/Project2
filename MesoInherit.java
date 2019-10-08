import java.lang.Math;

import com.sun.javafx.css.CalculatedValue;
public class MesoInherit extends MesoAbstract{
private String stID;
private int[] average;
	public MesoInherit(String stID) {
		average = new int[3];
		this.stID = stID;
	}
	@Override
	 protected int[] calAverage() {
		// TODO Auto-generated method stub
		int ascii = 0;
		int calc;
		for (int i = 0; i < stID.length(); i++) {
			char letter = stID.charAt(i);
			ascii += (int) letter;
			System.out.println(ascii);
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
		//int asciiInt = calAlverage()
		
		return 0;
	}
}
