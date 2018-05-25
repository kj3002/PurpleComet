package Programs;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import Numbers.Number;

public class QuickProgram extends BaseProgram {
	public static void main(String[] args) { run(new Scanner (System.in)); }
	public static void run(Scanner scan) {
		Random rand = new Random();
		//Number n = new Number(1, 1, 2, new Number(1, 1, 2, 3, 1), 1);
		Number n = randNumber(1, rand);
		System.out.println("n: " + n);
		Number rec = n.reciprocal();
		System.out.println("rec: " + rec);
		System.out.println("1: " + n.multiply(rec));
	}

	public static Number randNumber(int numRadicals, Random rand) {
		int numer = rand.nextInt(100);
		int denom = rand.nextInt(100) + 1;
		ArrayList<Long> coefs = new ArrayList<>(), ins = new ArrayList<>();
		ArrayList<Number> rads = new ArrayList<>();
		for (int rad = 0; rad < numRadicals; rad++) {
			coefs.add((long)rand.nextInt(20) + 1);
			ins.add((long)rand.nextInt(3) + 2);
			rads.add(new Number(rand.nextInt(48) + 2));
		}
		return new Number(numer, coefs, ins, rads, denom);
	}
}