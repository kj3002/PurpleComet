package Programs;

import java.util.Scanner;

public class LawOfCosines {
	public static void main(String[] args) {
		double sideA =0, sideB=0, angleC = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Side a");
		if(sc.hasNextDouble()){
			sideA = sc.nextDouble();
		}
		System.out.println("Side b");
		if(sc.hasNextDouble()){
			sideB = sc.nextDouble();
		}
		System.out.println("Angle c");
		if(sc.hasNextDouble()){
			angleC = sc.nextDouble();
		}
		else {
			SinCosTan.radianToAngle(sc.next());
		}

		System.out.print("C = " + Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2) - 2 * sideA * sideB * SinCosTan.cos(angleC)));

	}
}
