package leetcode64;

public class MinPathSum {
	public static int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				
				if(i!=0&&j!=0) {
					grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
				}
				
				if(i==0&&j!=0) {
					grid[i][j] +=  grid[i][j-1];
				}
				
				if(i!=0&&j==0) {
					grid[i][j] += grid[i-1][j];
				}
	            
			}
		}
		return grid[m-1][n-1];
    }
	public static void main(String[] args) {
		int bp[][] = new int[3][3];
		bp[0][0] = 1;
		bp[0][1] = 3;
		bp[0][2] = 1;
		bp[1][0] = 1;
		bp[1][1] = 5;
		bp[1][2] = 1;
		bp[2][0] = 4;
		bp[2][1] = 2;
		bp[2][2] = 1;
		System.out.println(minPathSum(bp));
	}
}
