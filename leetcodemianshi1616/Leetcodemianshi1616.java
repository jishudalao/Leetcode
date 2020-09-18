package leetcodemianshi1616;

public class Leetcodemianshi1616 {
	public double[] twoSum(int n) {
		double[] res = new double[n*5+1];
		int[][] dp = new int[n+1][n*6+1];
        dp[0][0] = 1;
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=i*6;j++){
                for(int k = 1;k<=Math.min(j,6);k++){
                    dp[i][j] += dp[i-1][j-k];
                }
            }
        }
        double total = Math.pow(6,n);
        for(int i = n;i<=6*n;i++){
            res[i-n] = (double)dp[n][i] / total;
        }
		return res;
    }
}
