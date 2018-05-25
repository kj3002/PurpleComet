package Programs;

import General.GetInfo;
import Numbers.Number;

import java.util.Scanner;

public class Calculator extends BaseProgram {
	public static void main(String[] args) { run(new Scanner(System.in)); }
	public static void run(Scanner scan) {
		Number num = GetInfo.getNumber(scan);
		while (true) {
			System.out.print("What operation? ");
			String op = scan.next();
			Number num2, ans;
			if (op.equals("+") || op.equals("add") || op.equals("a")) {
				num2 = GetInfo.getNumber(scan);
				ans = num.add(num2);
				System.out.println(num + " + " + num2 + " = " + ans);
			} else if (op.equals("*") || op.equals("multiply") || op.equals("m")) {
				num2 = GetInfo.getNumber(scan);
				ans = num.multiply(num2);
				System.out.println(num + " * (" + num2 + ") = " + ans);
			} else {
				continue;
			}
			num = ans;
		}
	}
}
