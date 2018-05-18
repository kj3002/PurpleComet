package Programs;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class SimplifyRadicals extends BaseProgram {
	public void run(Scanner scan) {
		while (true) {
			int index = General.GetInfo.getIntNoMax(1, "What is the index of the radical? ", scan);
			int num = General.GetInfo.getIntNoMax(1, "What number would you like to simplify? ", scan);
			int[] rad = simplify(index, num);
			String radical;
			if(rad[1] == 1)
				radical = rad[0] + "";
			else if (rad[0] == 1)
				radical = rad[1] + "^1/" + index;
			else
				radical = rad[0] + " * " + rad[1]  + "^1/" + index;
			System.out.println(
					num + "^1/" + index + " simplifies to: " + radical + "\n");
		}
	}

	public static int[] simplify(int index, int num) {
		/*HashMap<Integer, Integer> rad = PrimeFactorization.getPrimeFactors(num);
		HashMap<Integer, Integer> coe = new HashMap<>();
		Collection<Integer> exps = rad.values();
		for (int exp : exps) {
			if (exp >= index) {
				coe.put(General.Conversions.intListToIntArray(rad.keySet())[General.Conversions.intArrayToIntList(General.Conversions.intListToIntArray(exps)).indexOf(exp)], (exp - (exp % index)) / index);
				rad.put(General.Conversions.intListToIntArray(rad.keySet())[General.Conversions
						.intArrayToIntList(General.Conversions.intListToIntArray(exps)).indexOf(exp)], exp % index);
			}
		}

		int coef = 1;
		for (int pri : coe.keySet()) {
			coef *= (int) Math.pow(pri, coe.get(pri));
		}
		int radi = 1;
		for (int pri : rad.keySet()) {
			radi *= (int) Math.pow(pri, rad.get(pri));
		}*/
		int coef = 1, rad = num;
		for (int testCoef = (int)Math.sqrt(rad); testCoef > 1; testCoef--) {
			if (rad % Math.pow(testCoef, index) == 0) {
				coef = testCoef;
				break;
			}
		}
		rad /= (int)Math.pow(coef, index);
		System.out.println("coef: " + coef + " index: " + index + " num: " + num + " rad: " + rad);

		int[] radical = { coef, rad };
		return radical;
	}
}