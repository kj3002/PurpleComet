package Programs;

import java.math.BigInteger;
import java.util.Scanner;

public class GCFandLCM extends BaseProgram {
	public static void main(String[] args) { run(new Scanner (System.in)); }
	public static void run(Scanner scan) {
		while (true) {
			BigInteger a = BigInteger.valueOf(General.GetInfo.getIntNoMax(1, "What is the first number? ", scan));
			BigInteger b = BigInteger.valueOf(General.GetInfo.getIntNoMax(1, "What is the second number? ", scan));
			System.out.println("The GCF of " + a + " and " + b + " is " + gcf(a,b) + ".");
			System.out.println("The LCM of " + a + " and " + b + " is " + lcm(a,b) + ".\n");
		}
	}
	
	public static int gcf(int a, int b) {
		/*if(a > b) {
			int temp = b;
		333	b = a;
			a = temp;
		}
		for(int fac = a; fac > 0; fac--) {
			if(a % fac == 0 && b % fac == 0) {
				return fac;
			}
		}
		return 1;*/
		BigInteger ba = BigInteger.valueOf(a), bb = BigInteger.valueOf(b);
		return ba.gcd(bb).intValue();
	}
	public static int lcm(int a, int b) {
		return a * b / gcf(a, b);
	}
	
	public static long gcf(long a, long b) {
		BigInteger ba = BigInteger.valueOf(a), bb = BigInteger.valueOf(b);
		return ba.gcd(bb).longValue();
	}
	public static long lcm(long a, long b) {
		return a * b / gcf(a, b);
	}

	public static BigInteger gcf(BigInteger a, BigInteger b) {
		/*if(a > b) {
			int temp = b;
		333	b = a;
			a = temp;
		}
		for(int fac = a; fac > 0; fac--) {
			if(a % fac == 0 && b % fac == 0) {
				return fac;
			}
		}
		return 1;*/
		return a.gcd(b);
	}
	public static BigInteger lcm(BigInteger a, BigInteger b) {
		return a.multiply(b).divide(gcf(a,b));
	}
}