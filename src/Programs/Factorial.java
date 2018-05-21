package Programs;

import java.util.Scanner;

public class Factorial extends BaseProgram {
	public static void main(String[] args) { run(new Scanner (System.in)); }
	public static void run(Scanner scan) {
		System.out.println("Number"); //must be less than 16
		int number = 0;
		int total = 1;
		if(scan.hasNextInt()) {
			number = scan.nextInt();
		}

		for(int i = number; i > 0; i--) {
			total = total * i;
		}

		System.out.println(number + "! = " + total);
	}
}
