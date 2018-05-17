package Programs;

import java.util.Scanner;

//TODO: LET KEVIN FINISH , btw completely broken rn
public class QuadraticCubicQuartic {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Type in power: ");
		int power;
		int a =0 , b =0 , c =0 , d, e;
		int[] radical;
		int[][] bigRadical;
		int coefficient, radicand;
		double discriminant = Math.pow(b, 2) - 4 * a * c;
		if(sc.hasNextInt()) {
			power = sc.nextInt();
			if(power == 2) {
				System.out.print("a: ");
				a = sc.nextInt();
				System.out.print("b: ");
				b = sc.nextInt();
				System.out.print("c: ");
				c = sc.nextInt();

				if(discriminant < 0) {
					System.out.print("Imaginary roots");
				}
				else if (discriminant > 0) {
					/*radical = SimplifyRadicals.simplify(2, discriminant);
					coefficient = radical[0];
					radicand = radical[1];
					if(radicand == 1){
						b = b * -1;
						System.out.println("Root: (" + (b + coefficient) + ")/(" + 2 * a + ")");
						System.out.println("Root: (" + (b - coefficient) + ")/(" + 2 * a + ")");
					}
					else {
						System.out.println("Root: (" + b + " + or - " + coefficient + "sqrt (" + radicand + ")/(" + 2 * a + ")");
					}*/
				}
				else {
					System.out.println("Root: " + b  + "/" + 2 * a);
				}
			}
			else if(power == 3) {
				System.out.println("a");
				a = sc.nextInt();
				System.out.println("b");
				b = sc.nextInt();
				System.out.println("c");
				c = sc.nextInt();
				System.out.println("d");
				d = sc.nextInt();

				double innerRadical = Math.pow((-1 * Math.pow(b, 3))/(27 * Math.pow(b, 3)) + (b * c)/(6 * Math.pow(a, 2)) - (d)/(2*a), 2) + Math.pow((c/(3 * a) - Math.pow(b,2))/(9 * Math.pow(a, 2)),2);
				if(innerRadical < 0) {
					System.out.println("Imaginary roots");
				}
				else {
					/*radical = SimplifyRadicals.simplify(2, innerRadical);
					coefficient = radical[0];
					radicand = radical[1];
					if(radicand == 1){
						System.out.println("Root: (" + (b + coefficient) + ")/(" + 2 * a + ")");
						System.out.println("Root: (" + (b - coefficient) + ")/(" + 2 * a + ")");
					}
					else {
						System.out.println("Root: (" + b + " + or - " + coefficient + "sqrt (" + radicand + ")/(" + 2 * a + ")");
					}*/
				}

				//((-1 * b * b * b)/(27 * a * a * a) + (b * c)/(6 * a * a) - (d)/(2*a)) +
			}
		}
		else {
			System.out.println("Invalid power");
		}
		// TODO Auto-generated method stub

	}
	//public static int[] Quadratic(int a, int b, int c) {
	//}

}


