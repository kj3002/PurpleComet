package Programs;

import java.util.Scanner;

public class CatParabolaFinder extends BaseProgram {
	public static void main(String[] args) { run(new Scanner (System.in)); }
	public static void run(Scanner scan) {
		while(true){
			System.out.println("Enter the coordinates with a comma between, but no parentheses.");
			System.out.println("The coordinates will appear below after all points have been submitted.");
			System.out.println("Point 1:");
			long[] axy = General.Conversions.inputToLongArray(scan.next(), ",");
			System.out.println("Point 2:");
			long[] bxy = General.Conversions.inputToLongArray(scan.next(), ",");
			System.out.println("Point 3:");
			long[] cxy = General.Conversions.inputToLongArray(scan.next(), ",");
			System.out.println("Points: ("+axy[0]+","+axy[1]+") , ("+bxy[0]+","+bxy[1]+") , ("+cxy[0]+","+cxy[1]+")");
			long ab = axy[0] - bxy[0], ac = axy[0] - cxy[0], bc = bxy[0] - cxy[0];
			if(ab*ac*bc==0) {
				throw new IllegalArgumentException("Two of your x-coordinates are the same -- not a function! Please try again.");
			} else {
				long aN = axy[1]*bc-bxy[1]*ac+cxy[1]*ab;
				long bN = -axy[1]*bc*(bxy[0]+cxy[0])+bxy[1]*ac*(axy[0]+cxy[0])-cxy[1]*ab*(axy[0]+bxy[0]);
				long cN = axy[1]*bxy[0]*cxy[0]*bc-axy[0]*bxy[1]*cxy[0]*ac+axy[0]*bxy[0]*cxy[1]*ab;
				long denominator = ab*ac*bc;
				projectMainPage(aN, bN, cN, denominator);
			}
			System.out.println();
		}
	}
	public static void projectMainPage(long aNume, long bNume, long cNume, long denom) {
		long[] a = new long[2], b = new long[2], c = new long[2];
		a[0] = gcf(aNume, denom, 0);
		a[1] = gcf(aNume, denom, 1);
		b[0] = gcf(bNume, denom, 0);
		b[1] = gcf(bNume, denom, 1);
		c[0] = gcf(cNume, denom, 0);
		c[1] = gcf(cNume, denom, 1);
		long[][] nums = {{a[0], a[1]}, {b[0], b[1]}, {c[0], c[1]}};
		printer(a, b, c);
		QuadraticStanVertConverter.converter(QuadraticStanVertConverter.standardToVertex(nums));
	}
	public static void printer(long[] a, long[]b, long[] c) {
		String aConv = converter(a[0], a[1]);
		String bConv = converter(b[0], b[1]);
		String cConv = converter(c[0], c[1]);
		System.out.println("Standard: " + aConv + "x^2 + " + bConv + "x + " + cConv);
	}
	public static long gcf(long first, long second, long x) {
		long pawn = 1;
		for(int i = 1; i < Math.abs(second) + 1; i++) {
			if(first % i == 0 && second % i == 0) {					//Modulus cannot be negative
				pawn = i;
			}
		}
		if(x==0) {
			return first / pawn;
		} else {
			return second / pawn;
		}
	}
	public static String converter(long num, long den) {
		if(num == 0) {
			den = 1;
		} else if(den < 0) {
			den *= -1;
			num *= -1;
		}
		String rook = "" + num;
		if(Math.abs(den) != 1) {
			rook += "/" + den;
		}
		return rook;
	}
}