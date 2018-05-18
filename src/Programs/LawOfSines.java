package Programs;

import java.util.Scanner;

public class LawOfSines {

    public static void main(String[] args) {
        double sideA =0, sideB=0, angleA = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Side a");
        if(sc.hasNextDouble()){
            sideA = sc.nextDouble();
        }
        System.out.println("Angle a");
        if(sc.hasNextDouble()){
            angleA = sc.nextDouble();
        }
        else {
        	SinCosTan.radianToAngle(sc.next());
        }
        System.out.println("Side b");
        if(sc.hasNextDouble()){
            sideB = sc.nextDouble();
        }

        System.out.print("Sin B = " + Programs.SinCosTan.sin(angleA)/sideA * sideB);

    }

}


