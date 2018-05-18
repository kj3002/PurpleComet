package Programs;

import java.util.Scanner;

public class QuadraticCubicQuartic extends BaseProgram {
	public void run(Scanner scan) {
		System.out.print("Type in power: ");
		int power;
		int a = 0, b = 0, c = 0, d, e;
		int[] radical;
		int coefficient, radicand;
		int discriminant = b * b - 4 * a * c;
		if(scan.hasNextInt()) {
			power = scan.nextInt();
			if(power == 2) {
				System.out.println("a");
				a = scan.nextInt();
				System.out.println("b");
				b = scan.nextInt();
				System.out.println("c");
				c = scan.nextInt();
				
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