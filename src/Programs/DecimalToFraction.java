package Programs;

import Numbers.Rational;

import java.util.Scanner;

public class DecimalToFraction extends BaseProgram {
	public static void run(Scanner scan) {
		while (true) {
			String start = General.GetInfo.getString(false, "What is the first (non-repeating) part of the decimal? ", scan);
			int rep = General.GetInfo.getInt("What is the repeating part of the decimal? ", scan);
			Rational frac = fractionFromDecimal(start, rep);
			System.out.println(frac);
		}
	}

	public static Rational fractionFromDecimal(double start, int repeating) {
		return fractionFromDecimal(start + "", repeating);
	}
	
	public static Rational fractionFromDecimal(String startStr, int repeating) {
		double start = General.Conversions.stringToDouble(startStr);
		int startLen = 0;
		if (startStr.indexOf('.') != -1) {
			startLen = startStr.substring(startStr.indexOf('.') + 1, startStr.length()).length();
		}
		int repLen = (repeating + "").length();
		int highPow = (int) Math.pow(10, startLen + repLen), lowPow = (int) Math.pow(10, startLen);
		int[] frac = { (int) (highPow * start + repeating - lowPow * start), highPow - lowPow };
		//System.out.println("start: " + start + " startLen: " + startLen + " repeating: " + repeating + " repLen: " + repLen + " highPow: " + highPow + " lowPow: " + lowPow + " numerator: " + frac[0] + " denominator: " + frac[1]);
		return SimplifyFractions.simplify(frac[0], frac[1]);
	}
}