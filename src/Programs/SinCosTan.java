package Programs;

import java.util.Scanner;

public class SinCosTan extends BaseProgram {
	public static void main(String[] args) { run(new Scanner (System.in)); }
	public static void run(Scanner scan) {
		double angle = -1;
		System.out.println("Type in your angle or radian (type in pi for pi, no exponents accepted)");
		String angle_or_radian = scan.next();
		int pi = angle_or_radian.indexOf("pi");

		if(pi == -1) { //Goes to angles
			angle = Integer.parseInt(angle_or_radian);
			if(angle == -1) {
				throw new IllegalArgumentException("Please put in a valid angle");
			}
			if(angle < 0) {
				while(angle < 0) {
					angle = angle + 360;
				}
			}
		}
		else { //Goes to radians
			angle = radianToAngle(angle_or_radian);
		}

		if(!(angle % 30 == 0 || angle % 45 == 0)) {
			System.out.println("Sin = " + sin(angle));
			System.out.println("Cos = " + cos(angle));
			System.out.println("Tan = " + tan(angle));
		}
		else {
			sin(angle);
			cos(angle);
			tan(angle);
		}
	}

	public static double sin(double angle) {
		if(angle % 180 == 0) {
			System.out.println("Sin = 0");
		}
		else if(angle % 90 == 0){
			System.out.println("Sin = 1");
		}
		else if(angle % 60 == 0){
			if(firstQuadrant(angle) || secondQuadrant(angle)) {
				System.out.println("Sin = sqrt(3)/2");
			}
			else {
				System.out.println("Sin = -sqrt(3)/2");
			}

		}
		else if(angle % 45 == 0){
			if(firstQuadrant(angle) || secondQuadrant(angle)) {
				System.out.println("Sin = sqrt(2)/2");
			}
			else {
				System.out.println("Sin = -sqrt(2)/2");
			}
		}
		else if(angle % 30 == 0){
			if(firstQuadrant(angle) || secondQuadrant(angle)) {
				System.out.println("Sin = 1/2");
			}
			else {
				System.out.println("Sin = -1/2");
			}
		}
		else {
			angle = Math.sin(angle * Math.PI/180.0);
			return angle;
		}
		return angle;
	}

	public static double cos(double angle) {
		if(angle % 180 == 0) {
			System.out.println("Cos = 1");
		}
		else if(angle % 90 == 0){
			System.out.println("Cos = 0");
		}
		else if(angle % 60 == 0){
			if(firstQuadrant(angle) || thirdQuadrant(angle)) {
				System.out.println("Cos = 0.5");

			}
			else {
				System.out.println("Cos = -0.5");
			}

		}
		else if(angle % 45 == 0){
			if(firstQuadrant(angle) || thirdQuadrant(angle)) {
				System.out.println("Cos = sqrt(2)/2");
			}
			else {
				System.out.println("Cos = -sqrt(2)/2");
			}
		}
		else if(angle % 30 == 0){
			if(firstQuadrant(angle) || thirdQuadrant(angle)) {
				System.out.println("Cos = sqrt(3)/2");
			}
			else {
				System.out.println("Cos = -sqrt(3)/2");
			}
		}
		else {
			angle = Math.cos(angle * Math.PI/180.0);
			return angle;
		}
		return angle;

	}

	public static double tan(double angle) {
		if(angle % 180 == 0) {
			System.out.println("Tan = 0");
		}
		else if(angle % 90 == 0){
			System.out.println("Tan = -1");
		}
		else if(angle % 60 == 0){
			if(firstQuadrant(angle) || thirdQuadrant(angle)) {
				System.out.println("Tan = sqrt(3)");
			}
			else {
				System.out.println("Tan = sqrt(3)");
			}

		}
		else if(angle % 45 == 0){
			if(firstQuadrant(angle) || thirdQuadrant(angle)) {
				System.out.println("Tan = 1");
			}
			else {
				System.out.println("Tan = -1");
			}
		}
		else if(angle % 30 == 0){
			if(firstQuadrant(angle) || thirdQuadrant(angle)) {
				System.out.println("Tan = sqrt(3)/3");
			}
			else {
				System.out.println("Tan = -sqrt(3)/3");
			}
		}
		else {
			angle = Math.tan(angle * Math.PI/180.0);
			return angle;
		}
		return angle;

	}
	//Converter constants
	public static double convertToLessThan360(double angle) {
		while(angle >= 360) {
			angle = angle % 360;
		}
		return angle;
	}
	public static boolean firstQuadrant(double angle) {
		angle = convertToLessThan360(angle);
		if(angle >= 0 && angle <= 90) {
			return true;
		}
		else return false;
	}
	public static boolean secondQuadrant(double angle) {
		angle = convertToLessThan360(angle);
		if(angle >= 90 && angle <= 180) {
			return true;
		}
		else return false;
	}
	public static boolean thirdQuadrant(double angle) {
		angle = convertToLessThan360(angle);
		if(angle >= 180 && angle <= 270) {
			return true;
		}
		else return false;
	}
	public static boolean fourthQuadrant(double angle) {
		angle = convertToLessThan360(angle);
		if(angle >= 270 && angle <= 360) {
			return true;
		}
		else return false;
	}

	public static double radianToAngle(String angleInRadians) {
		System.out.println(angleInRadians);
		int fraction = angleInRadians.indexOf("/");
		int pi = angleInRadians.indexOf("pi");
		System.out.println(pi + " , " + fraction);
		String numerator, denominator;
		double numericalNumerator, numericalDenominator;
		if(fraction > pi) { //if pi is on the numerator
			if (pi == 0) {
				numericalNumerator = 1;
			}
			else {
				if(pi + 2 == fraction) { //if it's in the form #pi/#
					numerator = angleInRadians.substring(0, pi);
					numericalNumerator = Double.parseDouble(numerator);
				}
				else { //if it's in the form pi#/#
					numerator = angleInRadians.substring(pi + 2, fraction);
					numericalNumerator = Double.parseDouble(numerator);
				}
			}
			denominator = angleInRadians.substring(fraction + 1, angleInRadians.length());
			numericalDenominator = Double.parseDouble(denominator);

			return (numericalNumerator * 180 / numericalDenominator);
		}
		else { //if pi is on the denominator
			if(fraction + 1 == pi) { //if it's in the form #/pi#
				if(pi + 2 == angleInRadians.length()) { //when it's just pi on the bottom
					numericalDenominator = Math.PI;
				}
				else {
					denominator = angleInRadians.substring(pi + 2, angleInRadians.length());
					numericalDenominator = Double.parseDouble(denominator);
				}
			}
			else { //if it's in the form #/#pi
				denominator = angleInRadians.substring(fraction + 1, pi);
				numericalDenominator = Double.parseDouble(denominator);
			}
			numerator = angleInRadians.substring(0, fraction);
			numericalNumerator = Double.parseDouble(numerator);
			return (numericalNumerator * 180/ numericalDenominator * Math.PI * Math.PI);
		}
	}
}
