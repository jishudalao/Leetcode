package leetcode62;

public class NniquePaths {
	//回溯法
	/*
	static int sum = 0;
	public static int uniquePaths(int m, int n) {
		//int sum = 0;
		int heng = 1;
		int shu = 1;
		backtrack(heng, shu, m, n);
		
		return sum;
    }
	public static void backtrack(int heng,int shu,int m, int n){
		if(shu==n&&heng==m) {
			 ++sum;
		}
		if(heng!=m) {
			heng =heng +1;
			backtrack(heng, shu, m, n);
			heng = heng-1;
		}
		if(shu!=n) {
			shu = shu +1;
			backtrack(heng, shu, m, n);
			shu = shu -1;
		}
		
	}*/
	//动态规划
	public static int uniquePaths(int m, int n) {
		int dp[][] = new int[m][n];
		/*for(int i=0;i<dp.length;i++) {
			dp[i][0] = 1;
		}
		for(int j=0;j<dp[0].length;j++) {
			dp[0][j] = 1;
		}*/
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				if(i==0||j==0) {
					dp[i][j] = 1;
				}
				if (i == 0 || j == 0) {     //最上一行或者最左一列
	                dp[i][j] = 1;
	            }
	            else {
	                dp[i][j] = dp[i-1][j] + dp[i][j-1];
	            }
			}
		}
		return dp[m-1][n-1];
    }
	public static void main(String[] args) {
		int m = 7;
		int n = 3;
		System.out.println(uniquePaths(m, n));
	}
}
