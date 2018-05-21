package Programs;

import java.util.Scanner;

public class LawOfCosines extends BaseProgram {
	public static void main(String[] args) { run(new Scanner (System.in)); }
	public static void run(Scanner scan) {
		double sideA =0, sideB=0, angleC = 0;
		System.out.println("Side a");
		if(scan.hasNextDouble()){
			sideA = scan.nextDouble();
		}
		System.out.println("Side b");
		if(scan.hasNextDouble()){
			sideB = scan.nextDouble();
		}
		System.out.println("Angle c");
		if(scan.hasNextDouble()){
			angleC = scan.nextDouble();
		}
		else {
			SinCosTan.radianToAngle(scan.next());
		}

		System.out.print("C = " + Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2) - 2 * sideA * sideB * SinCosTan.cos(angleC)));

	}
}
