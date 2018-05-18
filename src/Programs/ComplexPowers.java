package Programs;

import java.util.Scanner;

public class ComplexPowers extends BaseProgram {
	public void run(Scanner scan) {
		while(true){
		System.out.println("Please state the coefficients of the complex number in a + bi form");
		System.out.print("a? ");
		int a = scan.nextInt();
		System.out.print("b? ");
		int b = scan.nextInt();
		System.out.print("To what power? ");
		int exp = scan.nextInt();
		int[] ans = pow(a, b, exp);
		System.out.println(ans[0] + " + " + ans[1] + "i");
		}
	}
	public static int[] pow(int a, int b, int exp){
		int[] ans = new int[2];
		double magnitude = Math.sqrt(Math.pow(a, 2) + Math.pow(b,  2));
		double theta = Math.atan2(b, a);
		magnitude = Math.pow(magnitude, exp);
		theta *= exp;
		ans[0] = (int) (Math.cos(theta) * magnitude);
		ans[1] = (int) (Math.sin(theta) * magnitude);
		return ans;
	}
}