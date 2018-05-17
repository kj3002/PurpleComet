package Programs;

import java.util.Scanner;
import java.util.ArrayList;
public class ContinuedFractions {
	public static void main(String[] args) {
		Scanner useless = new Scanner(System.in);
		System.out.println("What is the fraction?");
		while(true){
			int[] frac = General.Conversions.inputToIntArray(useless.next(), "/");
			int pawn;
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(frac[0] / frac[1]);
			while(Math.abs(2 * frac[1] - 1) != 1) {
				pawn = frac[0] % frac[1];
				frac[0] = frac[1];
				frac[1] = pawn;
				if(frac[1] != 0) {
					list.add(frac[0] / frac[1]);	
				}
			}
			System.out.print("[" + list.get(0));
			if(list.size() != 1) {
				System.out.print(";" + list.get(1));
				for(int i = 2; i < list.size(); i++) {
					System.out.print("," + list.get(i));
				}
			}
			System.out.print("]");
		}
	}
}