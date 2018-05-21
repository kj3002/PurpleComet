package Programs;

import java.util.Scanner;

public class MatrixDeterminant extends BaseProgram {
	public static void main(String[] args) { run(new Scanner (System.in)); }
	public static void run(Scanner scan) {
		int size = General.GetInfo.getIntNoMax(1, "What is the side length of the matrix? ", scan);
		int[][] matrix = new int[size][size];
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				matrix[x][y] = General.GetInfo.getInt("What is the " + General.Miscellaneous.addSuffix(y + 1)
						+ " number in the " + General.Miscellaneous.addSuffix(x + 1) + " row? ", scan);
			}
		}
		int det = getDeterminate(matrix);
		System.out.println("The determinant of the matrix you entered is: " + det) ;
	}

	public static int getDeterminate(int[][] matrix) {
		int size = matrix.length;
		if (size != matrix[0].length)
			throw new IllegalArgumentException();

		if (size == 2) {
			return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
		} else {
			int det = 0;
			for (int min = 0; min < size; min++) {
				int scale = 1;
				if(min % 2 == 1)
					scale = -1;
				det += scale * matrix[min][0]*getDeterminate(getMinor(matrix, min));
			}
			return det;
		}
	}

	public static int[][] getMinor(int[][] matrix, int row) {
		int size = matrix.length;
		int[][] minor = new int[size - 1][size - 1];
		for (int x = 0; x < size; x++) {
			for (int y = 1; y < size; y++) {
				if (x < row) {
					minor[x][y-1] = matrix[x][y];
				} else if (x > row) {
					minor[x-1][y-1] = matrix[x][y];
				}
			}
		}
		return minor;
	}
}