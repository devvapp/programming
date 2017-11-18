package ctci.tests;

import java.lang.Integer;

public class C1_1_8_ZeroMatrix {

	public static void main(String... args) {

		Integer[][] matrix = new Integer[4][3];
		matrix[0][0] = 0;
		matrix[0][1] = 1;
		matrix[0][2] = 2;
		matrix[1][0] = 0;
		matrix[1][1] = 2;
		matrix[1][2] = 0;
		matrix[2][0] = 5;
		matrix[2][1] = 1;
		matrix[2][2] = 1;
		matrix[3][0] = 6;
		matrix[3][1] = 1;
		matrix[3][2] = 2;

		int row_size = matrix.length;
		int col_size = matrix[0].length;

		for (int i = 0; i < row_size; i++) {
			for (int j = 0; j < col_size; j++) {
				System.out.print(matrix[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		
		Map<Intger, Integer> zeroMap = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < row_size; i++) {
			for (int j = 0; j < col_size; j++) {
				//zeroMap.
			}
		}

	}

}
