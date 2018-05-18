package Programs;

import java.util.HashMap;
import java.util.Scanner;

public class SimplifyFractions extends BaseProgram {
	public void run(Scanner scan) {
		while (true) {
			int numer = General.GetInfo.getInt("What is the numerator of the fraction? ", scan);
			int denom = General.GetInfo.getInt("What is the denominator of the fraction? ", scan);
			int[] frac = simplify(numer, denom);
			String fraction;
			if (frac[1] == 1)
				fraction = frac[0] + "";
			else
				fraction = frac[0] + "/" + frac[1];
			System.out.println(numer + "/" + denom + " simplifies to: " + fraction + "\n");
		}
	}

	public static int[] simplify(int n, int d) {
		/*boolean isNeg = false;
		if(n < 0 ^ d < 0)
			isNeg = true;
		n = Math.abs(n);
		d = Math.abs(d);
		HashMap<Integer, Integer> npf = PrimeFactorization.getPrimeFactors(n);
		HashMap<Integer, Integer> dpf = PrimeFactorization.getPrimeFactors(d);
		for (int npri : npf.keySet()) {
			if (dpf.keySet().contains(npri) && dpf.get(npri) != 0) {
				int nexp = npf.get(npri);
				int dexp = dpf.get(npri);
				if (nexp >= dexp) {
					npf.put(npri, nexp - dexp);
					dpf.put(npri, 0);
				} else {
					npf.put(npri, 0);
					dpf.put(npri, dexp - nexp);
				}
			}
		}

		n = 1;
		for (int pri : npf.keySet()) {
			n *= (int) Math.pow(pri, npf.get(pri));
		}
		d = 1;
		for (int pri : dpf.keySet()) {
			d *= (int) Math.pow(pri, dpf.get(pri));
		}*/
		boolean[] neg = { n < 0, d < 0 };
		n = Math.abs(n);
		d = Math.abs(d);
		int gcf = GCFandLCM.gcf(n, d);
		int[] fraction = { n / gcf, d / gcf };
		fraction[0] *= neg[0] ^ neg[1] ? -1 : 1;
		return fraction;
	}
	
	public static long[] simplify(long n, long d) {
		boolean[] neg = { n < 0, d < 0 };
		n = Math.abs(n);
		d = Math.abs(d);
		long gcf = GCFandLCM.gcf(n, d);
		long[] fraction = { n / gcf, d / gcf };
		fraction[0] *= neg[0] ^ neg[1] ? -1 : 1;
		return fraction;
	}
	
	public static int[] simplify(HashMap<Integer, Integer> npf, HashMap<Integer, Integer> dpf) {
		for (int npri : npf.keySet()) {
			if (dpf.keySet().contains(npri) && dpf.get(npri) != 0) {
				int nexp = npf.get(npri);
				int dexp = dpf.get(npri);
				if (nexp >= dexp) {
					npf.put(npri, nexp - dexp);
					dpf.put(npri, 0);
				} else {
					npf.put(npri, 0);
					dpf.put(npri, dexp - nexp);
				}
			}
		}

		int n = 1;
		for (int pri : npf.keySet()) {
			n *= (int) Math.pow(pri, npf.get(pri));
		}
		int d = 1;
		for (int pri : dpf.keySet()) {
			d *= (int) Math.pow(pri, dpf.get(pri));
		}
		int[] fraction = { n, d };
		return fraction;
	}
}