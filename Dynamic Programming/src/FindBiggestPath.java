import java.util.ArrayList;
import java.util.Collections;

public class FindBiggestPath {

	public static void main(String[] args) {
		int[][] cells = new int[][] { 
			{ 2, 6, 1, 8, 9, 4, 2 },
			{ 1, 8, 0, 3, 5, 6, 7 },
			{ 3, 4, 8, 7, 2, 1, 8 },	
			{ 0, 9, 2, 8, 1, 7, 9 },	
			{ 2, 7, 1, 9, 7, 8, 2 }, 	
			{ 4, 5, 6, 1, 2, 5, 6 }, 
			{ 9, 3, 5, 2, 8, 1, 9 },
			{ 2, 3, 4, 1, 7, 2, 8 } };

		System.out.println(biggestPath(cells));

	}

	public static String biggestPath(int cells[][]) {
		int row = cells.length;
		int col = cells[0].length;
		System.out.println(col);

		int[][] sums = new int[row][col];

		sums[0][0] = cells[0][0];

		// sums cols
		for (int i = 1; i < row; i++) {
			sums[i][0] = cells[i][0] + sums[i - 1][0];
		}

		// sums rows
		for (int i = 1; i < col; i++) {
			sums[0][i] = cells[0][i] + sums[0][i - 1];
		}
		// sums all matrix
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (sums[i - 1][j] > sums[i][j - 1]) {
					sums[i][j] = cells[i][j] + sums[i - 1][j];
				} else {
					sums[i][j] = cells[i][j] + sums[i][j - 1];
				}
			}
		}
		for (int i = 0; i < row; i++) {
			System.out.println();
			for (int j = 0; j < col; j++) {
				System.out.print(sums[i][j] + " ");
			}
		}
		System.out.println();
		return findWay(cells,sums);

	}
	
	public static String findWay(int[][] cells, int[][]sums){
		int row = sums.length;
		int col = sums[0].length;
		ArrayList<Integer> path=new ArrayList<>();
		path.add(cells[row-1][col-1]);
		while(row!=1 && col!=1){
			if(sums[row-2][col-1]>sums[row-1][col-2]){
				path.add(cells[row-2][col-1]);
				row--;
			}
			else{
				path.add(cells[row-1][col-2]);
				col--;
			}
		}
		path.add(cells[0][0]);
		Collections.reverse(path);
		return path.toString();
		
	}

}
