package leetcode1593;

public class Leetcode1593 {
	public int maxValue(int[][] grid) {
		//不用说，动态规划
		for(int j = 1; j < grid[0].length; j++) {
			 grid[0][j] += grid[0][j - 1];
		} 
        for(int i = 1; i < grid.length; i++) {
        	 grid[i][0] += grid[i - 1][0];
        }
           
		for(int i=1;i<grid.length;i++) {
			for(int j=1;j<grid[0].length;j++) {
				grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
			}
		}
		return grid[grid.length-1][grid[0].length-1];
    }
}
