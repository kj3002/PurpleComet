package Programs;

import java.util.Scanner;

public class BaseChange extends BaseProgram {
	public static void main(String[] args) { run(new Scanner (System.in)); }
	public static void run(Scanner scan) {
		while (true) {
			int obase = General.GetInfo.getSpecialInt(1, 36, "What is the original base? ", scan);
			String num = General.GetInfo.getString(false, "What is the number in said base? ", scan);
			int base = General.GetInfo.getSpecialInt(1, 36, "What base do you want to convert to? ", scan);
			String ans = changeBase(obase, num, base);
			System.out.println(num + " (base " + obase + ") is " + ans + " in base " + base + "\n");
		}
	}

	public static String changeBase(int obase, String num, int base) {
		num = num.toLowerCase();
		int base10 = toBase10(obase, num);
		//System.out.println(num + " (base " + obase + ") is " + base10 + " in base 10");
		char[] newNum = new char[(int)Math.floor(Math.log(base10)/Math.log(base))+1];
		//System.out.println("The new number will have " + newNum.length + " digit(s)");
		for(int in = newNum.length - 1; in >= 0; in--) {
			int dig = (int)(base10/Math.pow(base, in));
			base10 -= Math.pow(base, in) * dig;
			if(dig < 10) newNum[in] = (char)(dig+48);
			else newNum[in] = (char)(dig+87);
			//System.out.println(dig + " read as " + newNum[in]);
		}
		return General.Conversions.charArrayToString(General.Miscellaneous.reverse(newNum)).toUpperCase();
	}

	public static int toBase10(int obase, String n) {
		char[] num = General.Miscellaneous.reverse(n.toLowerCase().toCharArray());
		int base10 = 0;
		for (int i = 0; i < num.length; i++) {
			int dig;
			if (num[i] > 47 && num[i] < 58)
				dig = (int) num[i] - 48;
			else
				dig = (int) num[i] - 87;
			if(dig >= obase)
				return -1;
			//System.out.println("Char " + num[i] + " read as: " + dig);
			base10 += dig * Math.pow(obase, i);
		}
		return base10;
	}
}