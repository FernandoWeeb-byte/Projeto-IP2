package rolldice;

import java.util.Random;

public class Dice {
	
	
	public static void main(String[] args) {
		Random r = new Random();
		int result = r.nextInt(6) + 1;
		int result2 = r.nextInt(6) + 1;
		System.out.println(result + " e " + result2);
		
	}
}
