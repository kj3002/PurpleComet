package Programs;

import java.util.Scanner;

public class QuadraticCubicQuartic {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Type in power: ");
		int power;
		int a = 0, b = 0, c = 0, d, e;
		int[] radical;
		int coefficient, radicand;
		int discriminant = b * b - 4 * a * c;
		if(sc.hasNextInt()) {
			power = sc.nextInt();
			if(power == 2) {
				System.out.println("a");
				a = sc.nextInt();
				System.out.println("b");
				b = sc.nextInt();
				System.out.println("c");
				c = sc.nextInt();
				
				if(discriminant < 0) {
					System.out.print("Imaginary roots");
				} 
				else if (discriminant > 0) {
					radical = SimplifyRadicals.simplify(2, discriminant);
					coefficient = radical[0];
					radicand = radical[1];
					if(radicand == 1){
						b = b * -1; 
						System.out.println("Root: (" + (b + coefficient) + ")/(" + 2 * a + ")");
						System.out.println("Root: (" + (b - coefficient) + ")/(" + 2 * a + ")");
					}
					else {
						System.out.println("Root: (" + b + " + or - " + coefficient + "sqrt (" + radicand + ")/(" + 2 * a + ")");
					}
				} 
				else {
					System.out.println("Root: " + b  + "/" + 2 * a);
				}
			}
		}
		else {
			System.out.println("Invalid power");
		}
		// TODO Auto-generated method stub

	}
	public static int[] Quadratic(int a, int b, int c) {
		return new int[0];
	}
}