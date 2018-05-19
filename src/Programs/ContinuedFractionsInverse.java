package Programs;

import java.util.Scanner;		//make sure the rest of the import statements aren't collapsed
import java.util.ArrayList;
public class ContinuedFractionsInverse extends BaseProgram {
	public static void run(Scanner scan) {
		while(true){
			ArrayList<Long> nums = new ArrayList<>();
			System.out.println("After your first input, you may enter \"0\" to conclude the input stage.");
			nums.add(scan.nextLong());
			long denom = 0, nume = 0, pawn = 1;
			while(pawn != 0) {
				pawn = scan.nextInt();
				nums.add(pawn);
			}
			System.out.print("---Stage concluded (last 0 is null)---");
			denom = 1;
			nume = nums.get(nums.size() - 2);
			for(int i = nums.size() - 3; i >= 0; i--) {
				pawn = denom;
				denom = nume;
				nume = pawn + nums.get(i) * denom;
			}
			System.out.println();
			System.out.print(nume);
			if(denom != 1) {
				System.out.print("/" + denom);
			}
			System.out.println("\n" + ((nume + 0.0) / denom));
		}
	}
}