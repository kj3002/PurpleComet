package General;

import java.util.ArrayList;
import java.util.Scanner;
import Numbers.Number;

public class GetInfo {
	public static int getInt(String phrase, Scanner scan) {
		int i = 0;
		while (true) {
			System.out.print(phrase);
			if (scan.hasNextInt()) {
				i = scan.nextInt();
				break;
			} else {
				System.out.println("Please enter an integer.");
				scan.next();
			}
		}
		return i;
	}
	public static int getIntNoMax(int min, String phrase, Scanner scan) {
		int i = 0;
		String enter;
		if (min != Integer.MIN_VALUE)
			enter = "Please enter a number greater than " + min + ". ";
		else
			enter = "Please enter an integer.";

		while (true) {
			System.out.print(phrase);
			if (scan.hasNext()) {
				if (scan.hasNextInt()) {
					i = scan.nextInt();
					if (i >= min)
						break;
					else
						System.out.println(enter);
				} else {
					System.out.println(enter);
					scan.next();
				}
			}
		}
		return i;
	}
	
	public static int getInt(String phrase) {
		Scanner scan = new Scanner(System.in);
		int i = getInt(phrase, scan);
		scan.close();
		return i;
	}

	public static int getSpecialInt(int min, int max, String phrase, Scanner scan) {
		int i = 0;
		String enter;
		if (max != Integer.MAX_VALUE && min != Integer.MIN_VALUE)
			enter = "Please enter a number between " + min + " and " + max + ". ";
		else if (max != Integer.MAX_VALUE && min == Integer.MIN_VALUE)
			enter = "Please enter a number less than/equal to " + max + ". ";
		else if (max == Integer.MAX_VALUE && min != Integer.MIN_VALUE)
			enter = "Please enter a number greater than/equal to " + min + ". ";
		else
			enter = "Please enter an integer.";

		while (true) {
			System.out.print(phrase);
			if (scan.hasNext()) {
				if (scan.hasNextInt()) {
					i = scan.nextInt();
					if (i >= min && i <= max)
						return i;
					else
						System.out.println(enter);
				} else {
					System.out.println(enter);
					scan.next();
				}
			}
		}
	}
	public static int getSpecialInt(int min, int max, String phrase) {
		Scanner scan = new Scanner(System.in);
		int i = getSpecialInt(min, max, phrase, scan);
		scan.close();
		return i;
	}
	
	public static int getPositiveInt(String phrase, Scanner scan) {
		return getSpecialInt(1, Integer.MAX_VALUE, phrase, scan);
	}
	public static int getPositiveInt(String phrase) {
		Scanner scan = new Scanner(System.in);
		int i = getPositiveInt(phrase, scan);
		scan.close();
		return i;
	}

	public static double getDouble(String phrase, Scanner scan) {
		double d = 0;
		while (true) {
			System.out.print(phrase);
			if (scan.hasNextDouble()) {
				d = scan.nextDouble();
				break;
			} else {
				System.out.println("Please enter a number.");
				scan.next();
			}
		}
		return d;
	}
	public static double getDouble(String phrase) {
		Scanner scan = new Scanner(System.in);
		double d = getDouble(phrase, scan);
		scan.close();
		return d;
	}

	public static double getSpecialDouble(double min, double max, String phrase, Scanner scan) {
		double d = 0;
		String enter;
		if (max != Integer.MAX_VALUE && min != Integer.MIN_VALUE)
			enter = "Please enter a number between " + min + " and " + max + ". ";
		else if (max != Integer.MAX_VALUE && min == Integer.MIN_VALUE)
			enter = "Please enter a number less than/equal to " + max + ". ";
		else if (max == Integer.MAX_VALUE && min != Integer.MIN_VALUE)
			enter = "Please enter a number greater than/equal to " + min + ". ";
		else
			enter = "Please enter a number.";

		while (true) {
			System.out.print(phrase);
			if (scan.hasNext()) {
				if (scan.hasNextDouble()) {
					d = scan.nextDouble();
					if (d >= min && d <= max)
						return d;
					else
						System.out.println(enter);
				} else {
					System.out.println(enter);
					scan.next();
				}
			}
		}
	}
	public static double getSpecialDouble(double min, double max, String phrase) {
		Scanner scan = new Scanner(System.in);
		double d = getSpecialDouble(min, max, phrase, scan);
		scan.close();
		return d;
	}
	
	public static double getPositiveDouble(String phrase, Scanner scan) {
		return getSpecialDouble(0, Integer.MAX_VALUE, phrase, scan);
	}
	public static double getPositiveDouble(String phrase) {
		Scanner scan = new Scanner(System.in);
		double d = getPositiveDouble(phrase, scan);
		scan.close();
		return d;
	}
	
	public static String getString(boolean emptyAllowed, String phrase, Scanner scan) {
		String str = "";
		while (true) {
			System.out.print(phrase);
			str = scan.nextLine();
			if(emptyAllowed || !str.equals(""))
				break;
			else
				System.out.println("Please do not provide an empty input.");
		}
		return str;
	}
	public static String getString(boolean emptyAllowed, String phrase) {
		Scanner scan = new Scanner(System.in);
		String str = getString(emptyAllowed, phrase, scan);
		scan.close();
		return str;
	}

	public static String getSpecialString(String[] ans, String phrase, Scanner scan) {
		for (int in = 0; in < ans.length; in++) {
			ans[in] = ans[in].toLowerCase();
		}
		String str = "";
		while (true) {
			System.out.print(phrase);
			str = scan.nextLine().toLowerCase();
			if (isAns(str, ans))
				break;
			else
				System.out.println("Not an option.");
		}
		return str;
	}
	public static String getSpecialString(String[] ans, String phrase) {
		Scanner scan = new Scanner(System.in);
		String str = getSpecialString(ans, phrase, scan);
		scan.close();
		return str;
	}

	private static boolean isAns(String str, String[] ans) {
		ArrayList<String> listAns = Conversions.stringArrayToStringList(ans);
		if (listAns.contains(str)) {
			return true;
		}
		ArrayList<String> cuts = new ArrayList<>();
		for (String answer : listAns) {
			boolean isUsed = true;
			int n = 1;
			while (isUsed) {
				if (cuts.contains(answer.substring(0, n)))
					n++;
				else
					isUsed = false;
			}
			cuts.add(answer.substring(0, n));
		}

		if (cuts.contains(str)) {
			return true;
		}
		return false;
	}

	public static boolean getYesNo(String phrase, Scanner scan) {
		String yn = "";
		while (true) {
			System.out.print(phrase);
			yn = scan.next().toLowerCase();
			if (yn.equals("y") || yn.equals("yes"))
				return true;
			else if (yn.equals("n") || yn.equals("no"))
				return false;
			else
				System.out.println("Enter yes or no.");
		}
	}
	public static boolean getYesNo(String phrase) {
		Scanner scan = new Scanner(System.in);
		boolean b = getYesNo(phrase, scan);
		scan.close();
		return b;
	}

	public static boolean getBoolean(String phrase, Scanner scan) {
		String yn = "";
		while (true) {
			System.out.print(phrase);
			yn = scan.next().toLowerCase();
			if (yn.equals("t") || yn.equals("true"))
				return true;
			else if (yn.equals("f") || yn.equals("false"))
				return false;
			else
				System.out.println("Enter true or false.");
		}
	}
	public static boolean getBoolean(String phrase) {
		Scanner scan = new Scanner(System.in);
		boolean b = getBoolean(phrase, scan);
		scan.close();
		return b;
	}
	
	public static Number getNumber() {
		return getNumber(new Scanner(System.in));
	}
	public static Number getNumber(Scanner scan) {
		int numer = getInt("What is the integer part of the numerator? ", scan);
		int numRads = getIntNoMax(0, "How many radicals? ", scan);
		ArrayList<Integer> coefs = new ArrayList<>();
		ArrayList<Integer> indexes = new ArrayList<>();
		ArrayList<Number> radicands = new ArrayList<>();
		for (int i = 1; i <= numRads; i++) {
			int coef = getInt("What is the coefficient of the " + Miscellaneous.addSuffix(i) + " radical? ", scan);
			int in = getPositiveInt("What is the index of the " + Miscellaneous.addSuffix(i) + " radical? ", scan);
			Number radi;
			while (true) {
				System.out.print("What is the radicand of the " + Miscellaneous.addSuffix(i) + " radical? Enter \"new\" to make it a Number. ");
				String strRadi = scan.next().toLowerCase();
				if (strRadi.equals("n") || strRadi.equals("new")) {
					radi = getNumber(scan);
					break;
				} else if (Miscellaneous.isNumeric(strRadi)) {
					radi = new Number(Integer.parseInt(strRadi));
					break;
				}
			}
			coefs.add(coef);
			indexes.add(in);
			radicands.add(radi);
		}
		int denom = getInt("What is the denominator of the Number? ", scan);
		
		return new Number(numer, coefs, indexes, radicands, denom);
	}
}