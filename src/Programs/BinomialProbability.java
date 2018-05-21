package Programs;

import Numbers.Rational;

import java.util.Scanner;

public class BinomialProbability extends BaseProgram {
	public static void run(Scanner scan) {
		while(true) {	
		System.out.print("How many trials? ");
		int trials = scan.nextInt();
		System.out.print("How many successes? ");
		int successes = scan.nextInt();
		System.out.print("Probability of the event? (Decimal plz)" );
		int[] chance = General.Conversions.inputToIntArray(scan.next(), "/");
		Rational prob = probability(trials, chance, successes);
		System.out.println(prob);
		}
	}
	
	public static Rational probability(int trials, int[] chance, int successes){
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
		System.out.println("Your probability is: "+ prob);
		return DecimalToFraction.fractionFromDecimal(prob,0);
	}
}