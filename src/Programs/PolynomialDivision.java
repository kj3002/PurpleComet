package Programs;

import java.util.Scanner;

public class PolynomialDivision {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);	
		while(true){
			System.out.print("Degree of dividend? " );
			int degree1 = sc.nextInt();
			double[] dividendPoly = new double[degree1 + 1];	
			System.out.print("First coefficient? ");
			dividendPoly[dividendPoly.length - 1] = sc.nextDouble();	
			for(int i = 1; i <= degree1; i++){
				System.out.print("Next coefficient? ");
				dividendPoly[dividendPoly.length - (1 + i)] = sc.nextDouble();
			}		
			System.out.print("Degree of divisor? " );
			int degree2 = sc.nextInt();
			double[] divisorPoly = new double[degree2 + 1];	
			System.out.print("First coefficient? ");
			divisorPoly[divisorPoly.length - 1] = sc.nextDouble();
			for(int j = 1; j <= degree2; j++){
				System.out.print("Next coefficient? ");
				divisorPoly[divisorPoly.length - (1 + j)] = sc.nextInt();
			}
			String quotient = "Your quotient is: " + divide(dividendPoly, divisorPoly);
		}
	}
	public static double[] divide(double[] dividendPoly, double[] divisorPoly) {
		String quotient = "";
		int count = 1;
		double[] coefficients = new double[dividendPoly.length - divisorPoly.length + 2];
		for(int i = dividendPoly.length - 1; i >= divisorPoly.length-1; i--){
			double multiplier = dividendPoly[i]/divisorPoly[divisorPoly.length-1];
			coefficients[coefficients.length - count] = multiplier;
			count++;
			if(i - (divisorPoly.length - 1) >= 0){
				if(multiplier > 1 && i - (divisorPoly.length - 1) > 1){
					quotient += (int)multiplier + "x^" + (i - divisorPoly.length + 1) + "+";
				} else if(multiplier > 1 && i - divisorPoly.length + 1 == 1){
					quotient += (int)multiplier + "x+";
				} else if(multiplier == 1 && i - divisorPoly.length + 1 > 1){
					quotient += "x^" + (i - (divisorPoly.length - 1)) + "+";
				} else if(multiplier == 1 && i - divisorPoly.length + 1 == 1){
					quotient += "x+";
				} else if(multiplier == 0){		
				} else if(i - divisorPoly.length + 1 == 0 && multiplier != 0){
					quotient += (int)multiplier;
				}
			}
			for(int j = divisorPoly.length - 1; j >= 0; j--){
				dividendPoly[i - (divisorPoly.length - (j+1))] -= multiplier * divisorPoly[j];
			}
			
		}
		String remainder = "";
		int isRemainder = 0;
		for(int i = dividendPoly.length - 1; i >= 0; i--){
			if(dividendPoly[i] != 0){
				remainder += dividendPoly[i];
				if(i == 1){
					remainder += "x" + i + " + ";
				} else if(i == 0){
					remainder += i + " + ";
				} else {
					remainder += "x^" + i + " + ";
				}
			}
		}
		System.out.print("Your quotient is: " + quotient);
		if(remainder != ""){
			isRemainder = 1;
			System.out.println(" with a remainder of " + remainder.substring(0, remainder.length()-2));
		}
		System.out.println();
		coefficients[coefficients.length-1] = isRemainder;
		return coefficients;
	}
}