package Programs;

import java.math.BigInteger;
import java.util.Scanner;

public class Factorial extends BaseProgram {
	public static void main(String[] args) { run(new Scanner (System.in)); }
	public static void run(Scanner scan) {
		System.out.println("Number"); //must be less than 16
		int number = 0;
		BigInteger total = BigInteger.ONE;
		if(scan.hasNextInt()) {
			number = scan.nextInt();
		}

		for(int i = number; i > 0; i--) {
			total = total.multiply(BigInteger.valueOf(i));
		}

		System.out.println(number + "! = " + total);
	}
}
