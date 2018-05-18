package Programs;
//INCOMPLETE
import java.util.Scanner;

public class RationalRootTheorem extends BaseProgram {
	public void run(Scanner scan) {
		System.out.print("Polynomial degree?" );
		int degree = scan.nextInt();
		double[] poly = new double[degree + 1];
		System.out.print("First coefficient? ");
		poly[poly.length - 1] = scan.nextInt();
		for(int i = 1; i <= degree; i++){
		System.out.print("Next coefficient? ");
		poly[poly.length - (1 + i)] = scan.nextInt();
		}
		getRoots(poly);
	}
	public static void getRoots(double[] poly){
		String roots = "";
		for(int i = 1; i <= poly[0]; i++){
			for(int j = 1; j <= poly[poly.length - 1]; j++){
				if((j/i) % 1 == 0){
					double[] testZero = {1, -j/i};
					double testRoot = j/i;
					double test[] = PolynomialDivision.divide(poly, testZero);
						if(test[test.length-1] == 0){
							roots = roots + "(x - " + testRoot + ")";
						}
				}
			}
		}		
	}
}