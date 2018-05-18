package Programs;

import java.util.Scanner;
public class QuadraticStanVertConverter extends BaseProgram {
	public void run(Scanner scan) {
		while(true){
			System.out.println("Quadratic?");
			long[] a = General.Conversions.inputToLongArray(scan.next(), "/");
			System.out.println("Linear?");
			long[] b = General.Conversions.inputToLongArray(scan.next(), "/");
			System.out.println("Constant?");
			long[] c = General.Conversions.inputToLongArray(scan.next(), "/");
			long[][] coefficients = {{a[0], a[1]}, {b[0], b[1]}, {c[0], c[1]}};
			CatParabolaFinder.printer(a, b, c);
			converter(standardToVertex(coefficients));
		}
	}
	public static long[][] standardToVertex(long[][] coefs) {
		long[][] equation = new long[3][2];
		equation[0][0] = coefs[0][0];
		equation[0][1] = coefs[0][1];
		equation[0] = SimplifyFractions.simplify(equation[0][0], equation[0][1]);
		//end "a" converter
		equation[1][0] = coefs[0][1] * coefs[1][0];
		equation[1][1] = 2 * coefs[0][0] * coefs[1][1];
		equation[1] = SimplifyFractions.simplify(equation[1][0], equation[1][1]);
		//end "h" converter
		equation[2][0] = 4 * coefs[0][0] * coefs[1][1] * coefs[1][1] * coefs[2][0] - coefs[0][1] * coefs[1][0] * coefs[1][0] * coefs[2][1];
		equation[2][1] = 4 * coefs[0][0] * coefs[1][1] * coefs[1][1] * coefs[2][1];
		equation[2] = SimplifyFractions.simplify(equation[2][0], equation[2][1]);
		//end "k" converter
		for(int i = 0; i < 3; i++) {
			equation[i][0] *= (equation[i][1] < 0 ? -1 : 1);
			equation[i][1] *= (equation[i][1] < 0 ? -1 : 1);
		}
		return equation;
	}
	public static void converter(long[][] nums) {
		String[] e = {"","","","","","","",""};
		for(int i = 0; i < 3; i++) {
			if(nums[i][0] != 0) {
				e[2 * i + 1] = "" + Math.abs(nums[i][0]);
				if(nums[i][1] != 1) {
					e[2 * i + 1] += "/" + nums[i][1];
				}
				if(nums[i][0] < 0) {
					e[2 * i] = " - ";
				} else if(i != 0) {
					e[2 * i] = " + ";
				}
			}
		}
		if(e[2] != "") {
			e[6] = "(";
			e[7] = ")";
		}
		System.out.println("Vertex: " + e[0] + e[1] + e[6] + "x"+ e[2] + e[3] + e[7] + "^2" + e[4] + e[5]);
	}
}