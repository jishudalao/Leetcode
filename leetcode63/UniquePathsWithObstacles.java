package leetcode63;

public class UniquePathsWithObstacles {
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int dp[][] = new int[m][n];
		if(obstacleGrid[0][0]==1) {
			return 0;
		}
		//if(m==1||n==1) {
			for (int i = 0; i < obstacleGrid.length; i++) {
				if(obstacleGrid[i][0]==1) {
					for(int k=i;k<obstacleGrid.length;k++) {
						obstacleGrid[k][0] = 1;
					}
					
				};
			}
			for (int j = 0; j < obstacleGrid[0].length; j++) {
				if(obstacleGrid[0][j]==1) {
					for(int k=j;k<obstacleGrid[0].length;k++) {
						obstacleGrid[0][k] = 1;
					}
					
				}
			}
		//}
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (obstacleGrid[i][j] == 1) {
					dp[i][j] = 0;
					continue;
				}
				if (i == 0 || j == 0) {
					dp[i][j] = 1;
					continue;
				}
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}

	public static void main(String[] args) {
		int obstacleGrid[][] = new int[3][3];
		for (int i = 0; i < obstacleGrid.length; i++) {
			for (int j = 0; j < obstacleGrid[0].length; j++) {
				obstacleGrid[i][j] = 0;
			}
		}
		obstacleGrid[1][1] = 1;
		//obstacleGrid[1][1] = 1;
		System.out.println(uniquePathsWithObstacles(obstacleGrid));
	}
}
