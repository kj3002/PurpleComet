package Programs;

import java.util.Scanner;

public class LawOfSines {
    public static void run(Scanner scan) {
        double sideA =0, sideB=0, angleA = 0;
        System.out.println("Side a");
        if(scan.hasNextDouble()){
            sideA = scan.nextDouble();
        }
        System.out.println("Angle a");
        if(scan.hasNextDouble()){
            angleA = scan.nextDouble();
        }
        else {
        	SinCosTan.radianToAngle(scan.next());
        }
        System.out.println("Side b");
        if(scan.hasNextDouble()){
            sideB = scan.nextDouble();
        }

        System.out.print("Sin B = " + Programs.SinCosTan.sin(angleA)/sideA * sideB);

    }

}


