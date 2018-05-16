package Programs;

import java.util.Scanner;

public class BinomialProbability {
	public static void main(String args[]) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while(true) {	
		System.out.print("How many trials? ");
		int trials = sc.nextInt();
		System.out.print("How many successes? ");
		int successes = sc.nextInt();
		System.out.print("Probability of the event? (Decimal plz)" );
		int[] chance = General.Conversions.inputToIntArray(sc.next(), "/");
		int[] prob = probability(trials, chance, successes);
		System.out.println(prob[0] + (prob[1] == 1 ? "" : " / " + prob[1]));
		}
	}
	
	public static int[] probability(int trials, int[] chance, int successes){
		int top = 1;
		int bottom = 1;
		int k = 1;
		for(int i = 1; i <= trials; i++){
			top *= i;
		}
		for(int i = 1; i <= trials - successes; i++){
			bottom *= i;
		}
		for(int i = 1; i <= successes; i++){
			k *= i;
		}
			bottom *= k;
		int combinations = top/bottom;
		double prob = combinations * Math.pow((double) (chance[0]) / (double)(chance[1]), successes) * Math.pow((double)(chance[1] - chance[0]) / (double)(chance[1]), trials - successes);
		System.out.println("You're probability is: "+ prob);
		return DecimalToFraction.fractionFromDecimal(prob,0);
	}
}