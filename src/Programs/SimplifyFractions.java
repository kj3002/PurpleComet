package Programs;

import Numbers.Rational;

import java.util.HashMap;
import java.util.Scanner;

public class SimplifyFractions extends BaseProgram {
	public static void run(Scanner scan) {
		while (true) {
			int numer = General.GetInfo.getInt("What is the numerator of the fraction? ", scan);
			int denom = General.GetInfo.getInt("What is the denominator of the fraction? ", scan);
			Rational frac = simplify(numer, denom);
			System.out.println(numer + "/" + denom + " simplifies to: " + frac + "\n");
		}
	}

	public static Rational simplify(int n, int d) {
		return new Rational(n, d);
	}
	
	public static Rational simplify(long n, long d) {
		return new Rational(n, d);
	}
}