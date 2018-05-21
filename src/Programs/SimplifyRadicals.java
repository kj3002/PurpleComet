package Programs;

import Numbers.Radical;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class SimplifyRadicals extends BaseProgram {
	public static void main(String[] args) { run(new Scanner (System.in)); }
	public static void run(Scanner scan) {
		while (true) {
			int index = General.GetInfo.getIntNoMax(1, "What is the index of the radical? ", scan);
			int num = General.GetInfo.getIntNoMax(1, "What number would you like to simplify? ", scan);
			System.out.println(index + "\u221A(" + num + ") simplifies to: " + simplify(index, num));
		}
	}

	public static Radical simplify(int index, int num) {
		return new Radical(index, num);
	}
}