package leetcode73;

import java.util.HashSet;
import java.util.Set;

public class SetZeroes {
	public static void setZeroes(int[][] matrix) {
		Set<Integer> good1 = new HashSet();
		Set<Integer> good2 = new HashSet();
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				if(matrix[i][j]==0) {
					good1.add(i);
					good2.add(j);
				}
			}
		}
		for(int n : good1) {
			for(int i=0;i<matrix[0].length;i++) {
				matrix[n][i] = 0;
			}
		}
		for(int n : good2) {
			for(int i=0;i<matrix.length;i++) {
				matrix[i][n] = 0;
			}
		}
    }
	public static void main(String[] args) {
		int obstacleGrid[][] = new int[3][4];
		for (int i = 0; i < obstacleGrid.length; i++) {
			for (int j = 0; j < obstacleGrid[0].length; j++) {
				obstacleGrid[i][j] = 1;
			}
		}
		obstacleGrid[0][0] = 0;
		obstacleGrid[0][3] = 0;
		setZeroes(obstacleGrid);
	}
}
