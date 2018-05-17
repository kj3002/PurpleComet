package General;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import Numbers.Number;

public class Conversions {
	public static int[] intListToIntArray(ArrayList<Integer> list) {
		if (list == null) {
			return null;
		}
		int[] array = new int[list.size()];
		for(int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
		return array;
	}
	public static int[] intSetToIntArray(Set<Integer> set) {
		if (set == null) {
			return null;
		}
		int[] array = new int[set.size()];
		int in = 0;
		for(int i : set) {
			array[in] = i;
			in++;
		}
		return array;
	}
	public static int[] intCollectionToIntArray(Collection<Integer> col) {
		if (col == null) {
			return null;
		}
		int[] array = new int[col.size()];
		int in = 0;
		for(int i : col) {
			array[in] = i;
			in++;
		}
		return array;
	}
	public static int[] intArrayToIntArray(int[] ar) {
		if (ar == null) {
			return null;
		}
		int[] array = new int[ar.length];
		for(int i = 0; i < ar.length; i++) {
			array[i] = ar[i];
		}
		return array;
	}
	
	public static Integer[] integerArrayToIntegerArray(Integer[] ar) {
		if (ar == null) {
			return null;
		}
		Integer[] array = new Integer[ar.length];
		for(int i = 0; i < ar.length; i++) {
			array[i] = ar[i];
		}
		return array;
	}
	
	public static int[][] twoDIntArrayToTwoDIntArray(int[][] ar) {
		if (ar == null) {
			return null;
		}
		int[][] ar2 = new int[ar.length][ar[0].length];
		for (int in = 0; in < ar.length; in++) {
			ar2[in] = intArrayToIntArray(ar[in]);
		}
		return ar2;
	}
	public static ArrayList<Integer> intArrayToIntList(int[] array) {
		if (array == null) {
			return null;
		}
		ArrayList<Integer> list = new ArrayList<>();
		for(int i : array)
			list.add(i);
		return list;
	}
	public static ArrayList<Integer> intListToIntList(ArrayList<Integer> list) {
		if (list == null) {
			return null;
		}
		ArrayList<Integer> list2 = new ArrayList<>();
		for(int i : list)
			list2.add(i);
		return list2;
	}
	public static ArrayList<Number> numberListToNumberList(ArrayList<Number> list) {
		if (list == null) {
			return null;
		}
		ArrayList<Number> ret = new ArrayList<>();
		for (Number n : list) {
			Number add = new Number();
			add.set(n);
			ret.add(add);
		}
		return ret;
	}
	public static int[][] intArrayListToTwoDIntArray(ArrayList<int[]> list) {
		if (list == null) {
			return null;
		}
		int[][] ar = new int[list.size()][];
		for (int in = 0; in < list.size(); in++) {
			ar[in] = list.get(in);
		}
		return ar;
	}
	public static ArrayList<Long> longArrayToLongList(long[] array) {
		if (array == null) {
			return null;
		}
		ArrayList<Long> list = new ArrayList<>();
		for(long  l: array)
			list.add(l);
		return list;
	}
	public static ArrayList<Long> longListToLongList(ArrayList<Long> list) {
		if (list == null) {
			return null;
		}
		ArrayList<Long> list2 = new ArrayList<>();
		for(long l : list)
			list2.add(l);
		return list2;
	}
	public static ArrayList<Character> charArrayToCharList(char[] array) {
		if (array == null) {
			return null;
		}
		ArrayList<Character> list = new ArrayList<>();
		for(char c : array)
			list.add(c);
		return list;
	}
	public static ArrayList<Character> charListToCharList(ArrayList<Character> list) {
		if (list == null) {
			return null;
		}
		ArrayList<Character> list2 = new ArrayList<>();
		for(char c : list)
			list2.add(c);
		return list2;
	}
	public static ArrayList<Boolean> booleanArrayToBooleanList(boolean[] array) {
		if (array == null) {
			return null;
		}
		ArrayList<Boolean> list = new ArrayList<>();
		for(boolean b : array)
			list.add(b);
		return list;
	}
	public static ArrayList<Boolean> booleanListToBooleanList(ArrayList<Boolean> list) {
		if (list == null) {
			return null;
		}
		ArrayList<Boolean> list2 = new ArrayList<>();
		for(boolean b : list)
			list2.add(b);
		return list2;
	}
	public static ArrayList<Object> objectArrayToObjectList(Object[] array) {
		if (array == null) {
			return null;
		}
		ArrayList<Object> list = new ArrayList<>();
		for(Object o : array)
			list.add(o);
		return list;
	}
	public static ArrayList<ArrayList<Object>> twoDObjectArrayToTwoDObjectList(Object[][] array) {
		if (array == null) {
			return null;
		}
		ArrayList<ArrayList<Object>> list = new ArrayList<>();
		for(Object[] ar2 : array) {
			ArrayList<Object> list2 = new ArrayList<>();
			for(Object o : ar2) list2.add(o);
			list.add(list2);
		}
		return list;
	}
	public static ArrayList<Object> objectListToObjectList(ArrayList<Object> list) {
		if (list == null) {
			return null;
		}
		ArrayList<Object> list2 = new ArrayList<>();
		for(Object o : list)
			list2.add(o);
		return list2;
	}
	public static ArrayList<int[][]> twoDIntArrayListToTwoDIntArrayList(ArrayList<int[][]> list) {
		if (list == null) {
			return null;
		}
		ArrayList<int[][]> list2 = new ArrayList<>();
		for (int[][] twod : list) {
			list2.add(twoDIntArrayToTwoDIntArray(twod));
		}
		return list2;
	}
	public static ArrayList<int[]> twoDIntArrayToIntArrayList(int[][] ar) {
		if (ar == null) {
			return null;
		}
		ArrayList<int[]> list = new ArrayList<>();
		for (int[] subAr : ar) {
			list.add(subAr);
		}
		return list;
	}
	public static HashMap<Integer, Integer> intIntHasMapToIntIntHashMap(HashMap<Integer, Integer> map) {
		if (map == null) {
			return null;
		}
		HashMap<Integer, Integer> clone = new HashMap<>();
		for(int i : map.keySet()) {
			clone.put(i, (int)map.get(i));
		}
		return clone;
	}
	public static String charArrayToString(char[] ar) {
		if (ar == null) {
			return null;
		}
		String str = "";
		for(char c : ar)
			str += c;
		return str;
	}
	public static double stringToDouble(String str) {
		if (str == null) {
			return 0;
		}
		double d = 0;
		int decIn = -1;
		for (int in = 0; in < str.length(); in++) {
			int dig = str.charAt(in) - 48;
			if ((dig < 0 || dig > 9) && dig + 48 != '.') {
				//System.out.println((char)(dig + 48) + " " + dig + " is not a number or a decimal");
				throw new NumberFormatException("Invalid double: " + str);
			}
			if (dig + 48 == '.'){
				decIn = in;
				//System.out.println("At decimal. char: " + str.charAt(in) + " d: " + d);
			} else if (decIn == -1) {
				d *= 10;
				d += dig;
				//System.out.println("Before decimal. char: " + str.charAt(in) + " d: " + d);
			} else {
				d += Math.pow(0.1, in - decIn) * dig;
				//System.out.println("After decimal char: " + str.charAt(in) + " d: " + d);
			}
		}
		return d;
	}
	public static int[] inputToIntArray(String strInput, String delimiter) {
		int[] pawn = new int[2];
		if(strInput.indexOf(delimiter) != -1) {
			pawn[0] = Integer.valueOf(strInput.substring(0, strInput.indexOf(delimiter)));
			pawn[1] = Integer.valueOf(strInput.substring(strInput.indexOf(delimiter) + 1, strInput.length()));
		} else {
			pawn[0] = Integer.valueOf(strInput);
			pawn[1] = 1;
		}
		return pawn;
	}
	public static long[] inputToLongArray(String strInput, String delimiter) {
		long[] pawn = new long[2];
		if(strInput.indexOf(delimiter) != -1) {
			pawn[0] = Integer.valueOf(strInput.substring(0, strInput.indexOf(delimiter)));
			pawn[1] = Integer.valueOf(strInput.substring(strInput.indexOf(delimiter) + 1, strInput.length()));
		} else {
			pawn[0] = Integer.valueOf(strInput);
			pawn[1] = 1;
		}
		return pawn;
	}
}