package Programs;

import java.util.Scanner;

public class DecimalToFraction {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (true) {
			String start = General.GetInfo.getString(false, "What is the first (non-repeating) part of the decimal? ", scan);
			int rep = General.GetInfo.getInt("What is the repeating part of the decimal? ", scan);
			int[] frac = fractionFromDecimal(start, rep);
			System.out.println(frac[0] + (frac[1] == 1 ? "" : " / " + frac[1]));
		}
	}

	public static int[] fractionFromDecimal(double start, int repeating) {
		return fractionFromDecimal(start + "", repeating);
	}
	
	public static int[] fractionFromDecimal(String startStr, int repeating) {
		double start = General.Conversions.toDouble(startStr);
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