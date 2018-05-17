package Programs;

import java.util.ArrayList;
import java.util.Scanner;

public class Factors {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (true) {
			int num = General.GetInfo.getIntNoMax(1, "What number would you like the factorization of? ", scan);
			int[] facs = factor(num);
			for (int i : facs)
				System.out.print(i + " ");
			System.out.println("\nTotal number of factors: " + facs.length + "\n");
		}
	}

	public static int[] factor(int num) {
		ArrayList<Integer> halfFacs = new ArrayList<>();
		for (int fac = 1; fac <= Math.sqrt(num); fac++) {
			if (num % fac == 0)
				halfFacs.add(fac);
		}
		ArrayList<Integer> facs = General.Conversions.intListToIntList(halfFacs);
		for (int in = halfFacs.size() - 1; in >= 0; in--) {
			if (num / halfFacs.get(in) != halfFacs.get(in)) {
				facs.add(num / halfFacs.get(in));
			}
		}
		return General.Conversions.intListToIntArray(facs);
	}
}