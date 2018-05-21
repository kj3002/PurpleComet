package Programs;

import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Number"); //must be less than 16
		int number = 0;
		int total = 1;
		if(sc.hasNextInt()) {
			number = sc.nextInt();
		}

		for(int i = number; i > 0; i--) {
			total = total * i;
		}

		System.out.println(number + "! = " + total);
	}
}
