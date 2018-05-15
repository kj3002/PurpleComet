package General;

import java.util.ArrayList;

public class Print {
	public static void printArray(int[] ar, boolean newLine) {
		if (ar == null) {
			System.out.print("null");
			if (newLine) {
				System.out.println();
			}
		}
		for (int i : ar) {
			if (newLine) {
				System.out.println(i);
			} else {
				System.out.print(i + " ");
			}
		}
	}

	public static void printArray(Integer[] ar, boolean newLine) {
		if (ar == null) {
			System.out.println("null");
			if (newLine) {
				System.out.println();
			}
		}
		for (Integer i : ar) {
			if (newLine) {
				System.out.println(i);
			} else {
				System.out.print(i + " ");
			}
		}
	}

	public static void printArray(ArrayList<? extends Object> ar, boolean newLine) {
		if (ar == null) {
			System.out.println("null");
			if (newLine) {
				System.out.println();
			}
		}
		for (Object o : ar) {
			if (newLine) {
				System.out.println(o);
			} else {
				System.out.print(o + " ");
			}
		}
	}

	public static void print2dArray(int[][] ar) {
		print2dArray(ar, true);
	}

	public static void print2dArray(int[][] ar, boolean spacing) {
		if (ar == null) {
			System.out.println("null");
		}
		int max = Integer.MIN_VALUE;
		if (spacing) {
			for (int[] i : ar) {
				for (int n : i) {
					if (n > max) {
						max = n;
					}
				}
			}
		}
		for (int[] i : ar) {
			for (int n : i) {
				String space = " ";
				if (spacing) {
					for (int addSpace = Miscellaneous.numDigits(n); addSpace < Miscellaneous
							.numDigits(max); addSpace++) {
						space += " ";
					}
				}
				System.out.print(n + space);
			}
			System.out.println();
		}
	}

	public static void print2dArray(Integer[][] ar) {
		print2dArray(ar, true);
	}

	public static void print2dArray(Integer[][] ar, boolean spacing) {
		if (ar == null) {
			System.out.println("null");
		}
		int max = Integer.MIN_VALUE;
		if (spacing) {
			for (Integer[] i : ar) {
				for (Integer n : i) {
					if (n > max) {
						max = n;
					}
				}
			}
		}
		for (Integer[] i : ar) {
			for (Integer n : i) {
				String space = " ";
				if (spacing) {
					for (int addSpace = Miscellaneous.numDigits(n); addSpace < Miscellaneous
							.numDigits(max); addSpace++) {
						space += " ";
					}
				}
				System.out.print(n + space);
			}
			System.out.println();
		}
	}

	public static void print2dArray(ArrayList<int[]> ar) {
		print2dArray(ar, true);
	}

	public static void print2dArray(ArrayList<int[]> ar, boolean spacing) {
		if (ar == null) {
			System.out.println("null");
		}
		int max = Integer.MIN_VALUE;
		if (spacing) {
			for (int[] i : ar) {
				for (int n : i) {
					if (n > max) {
						max = n;
					}
				}
			}
		}
		for (int[] i : ar) {
			for (int n : i) {
				String space = " ";
				if (spacing) {
					for (int addSpace = Miscellaneous.numDigits(n); addSpace < Miscellaneous
							.numDigits(max); addSpace++) {
						space += " ";
					}
				}
				System.out.print(n + space);
			}
			System.out.println();
		}
	}

	public static void print2dArrayList(ArrayList<ArrayList<Integer>> ar, boolean spacing) {
		if (ar == null) {
			System.out.println("null");
		}
		int max = Integer.MIN_VALUE;
		if (spacing) {
			for (ArrayList<Integer> i : ar) {
				for (Integer n : i) {
					if (n > max) {
						max = n;
					}
				}
			}
		}
		for (ArrayList<Integer> i : ar) {
			for (Integer n : i) {
				String space = " ";
				if (spacing) {
					for (int addSpace = Miscellaneous.numDigits(n); addSpace < Miscellaneous
							.numDigits(max); addSpace++) {
						space += " ";
					}
				}
				System.out.print(n + space);
			}
			System.out.println();
		}
	}

	public static void printBooleanArray(boolean[] ar) {
		printBooleanArray(ar, true);
	}

	public static void printBooleanArray(boolean[] ar, boolean newLine) {
		if (ar == null) {
			System.out.print("null");
			if (newLine) {
				System.out.println();
			}
		}
		for (boolean b : ar) {
			if (newLine) {
				System.out.println(b);
			} else {
				System.out.print(b + " ");
			}
		}
	}

	public static void print2dDoubleArray(double[][] ar) {
		print2dDoubleArray(ar, true);
	}

	public static void print2dDoubleArray(double[][] ar, boolean newLine) {
		if (ar == null) {
			System.out.print("null");
			if (newLine) {
				System.out.println();
			}
		}
		for (double[] row : ar) {
			for (double d : row) {
				System.out.print(d + " ");
			}
			if (newLine) System.out.println();
		}
	}
}