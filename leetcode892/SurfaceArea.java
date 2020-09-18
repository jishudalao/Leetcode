package leetcode892;

public class SurfaceArea {
	public int surfaceArea(int[][] grid) {
		int cover = 0;
		int sum = 0;
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				//上下遮盖的面数
				sum += grid[i][j];
				cover += grid[i][j]>1? grid[i][j]-1 : 0;
				//周围:
				if(i>0) {
					cover += Math.min(grid[i-1][j],grid[i][j]);
				}
				if(j>0) {
					cover += Math.min(grid[i][j-1],grid[i][j]);
				}
			}
		}
		return sum * 6 - cover * 2;
    }
	public static void main(String[] args) {
		
	}
}
