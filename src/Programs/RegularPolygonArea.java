package Programs;

import java.util.Scanner;

public class RegularPolygonArea {
	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("How many sides? ");
			int sides = sc.nextInt();
			if(sides <= 2){
				throw new IllegalArgumentException("please input a number greater than 2");
			}
			System.out.print("Side length? ");
			double length = sc.nextDouble();
			double area = findArea(sides, length);
			System.out.println(Math.round(area));
		}
	}
	
	public static double findArea(int sides, double length){
		double interiorAngle = (180 * (sides - 2) / sides) * (2 * Math.PI / 360);
		double frustrum = (length / 2) * Math.tan(interiorAngle / 2);
		double area = sides * (length * frustrum / 2);
		return area;
	}
}