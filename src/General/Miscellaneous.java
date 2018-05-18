package General;

import java.util.ArrayList;
import java.util.Random;

public class Miscellaneous {
	public static void wait(double secs) {
		int iSecs = (int) secs * 1000;

		try {
			Thread.sleep(iSecs);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	public static String addSuffix(int i) {
		String suf = "th";
		if (i % 10 == 1 && i % 100 != 11)
			suf = "st";
		else if (i % 10 == 2 && i % 100 != 12)
			suf = "nd";
		else if (i % 10 == 3 && i % 100 != 13)
			suf = "rd";
		return i + suf;
	}
	
	public static boolean contains(int[] ar, int n) {
		if (ar == null) return false;
		for(int i : ar) {
			if(i == n) return true;
		}
		return false;
	}
	public static boolean contains(Integer[] ar, Integer n) {
		if (ar == null) return false;
		for(Integer i : ar) {
			if(i == n) return true;
		}
		return false;
	}
	public static boolean contains(int[][] ar, int n) {
		if (ar == null) return false;
		for(int[] ar2 : ar) {
			if(contains(ar2, n)) return true;
		}
		return false;
	}
	public static boolean contains(Integer[][] ar, Integer n) {
		if (ar == null) return false;
		for(Integer[] ar2 : ar) {
			if(contains(ar2, n)) return true;
		}
		return false;
	}
	public static boolean contains(String[] ar, String str) {
		if (ar == null) return false;
		for (String s : ar) {
			if (s.equals(str)) return true;
		}
		return false;
	}
	
	public static void sort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
 
		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
 
			while (arr[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (low < j)
			sort(arr, low, j);
 
		if (high > i)
			sort(arr, i, high);
	}
	
	public static void shuffle(int[] ar) {
		int[] shuffled = new int[ar.length];
		Random ran = new Random();
		boolean[] inUsed = new boolean[ar.length];
		for (int in = 0; in < ar.length; in++) {
			int newIn = ran.nextInt(ar.length); 
			while (inUsed[newIn]) {
				newIn = ran.nextInt(ar.length);
			}
			inUsed[newIn] = true;
			shuffled[in] = ar[newIn];
		}
		for (int in = 0; in < ar.length; in++) {
			ar[in] = shuffled[in];
		}
	}
	
	public static int[][] permutations(int[] ar) {
		if (ar.length <= 1) {
			int[][] perm = { ar };
			return perm;
		} else {
			int len = ar.length;
			int[][] perms = new int[factorial(len)][len];
			for (int in = 0; in < len; in++) {
				int[] ar2 = new int[len - 1];
				for (int aAr2 = 0; aAr2 < len - 1; aAr2++) {
					if (aAr2 < in) {
						ar2[aAr2] = ar[aAr2];
					} else {
						ar2[aAr2] = ar[aAr2 + 1];
					}
				}
				
				int[][] prevPerm = permutations(ar2);
				for (int prevPermIn = 0; prevPermIn < prevPerm.length; prevPermIn++) {
					int[] perm = new int[len];
					perm[0] = ar[in];
					for (int index = 1; index < len; index++) {
						perm[index] = prevPerm[prevPermIn][index - 1];
					}
					perms[in * prevPerm.length + prevPermIn] = perm;
				}
			}
			return perms;
		}
	}
	
	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * factorial(Math.abs(n) - 1);
		}
	}
	
	public static int numDigits(int n) {
		return ("" + n).length();
	}
	
	public static boolean isPrime(long n) {
		if(n < 2) return false;
		for(int fac = 2; fac <= Math.sqrt(n); fac++) {
			if(n % fac == 0) return false;
		}
		return true;
	}
	
	public static long nthPri(int n) {
		int cnt = 0, pri = 2;
		for(pri = 2; cnt < n; pri++) {
			if(isPrime(pri)) cnt++;
		}
		return pri - 1;
	}
	
	// isNumeric() gotten from https://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java
	public static boolean isNumeric(String str) {
	  return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}

	public static int[] reverse(int[] array) {
		if (array == null) {
			return null;
		}
		int[] rev = new int[array.length];
		for(int i = 0; i < array.length; i++)
			rev[array.length-i-1] = array[i];
		return rev;
	}
	public static char[] reverse(char[] array) {
		char[] rev = new char[array.length];
		for(char c = 0; c < array.length; c++)
			rev[array.length-c-1] = array[c];
		return rev;
	}
	public static ArrayList<Integer> reverse(ArrayList<Integer> list) {
		if (list == null) {
			return null;
		}
		ArrayList<Integer> rev = new ArrayList<>();
		for(int i : list)
			rev.add(list.get(list.size()-i-1));
		return rev;
	}
}