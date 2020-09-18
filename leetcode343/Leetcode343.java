package leetcode343;

public class Leetcode343 {
	public static int integerBreak(int n) {
		if(n<=3) {
			return n-1;
		}
	    int[] dp = new int[n + 1];
	    dp[2] = 2;//注意，这相当于底
	    dp[3] = 3;
	    for (int i = 4; i < dp.length; i++) {
	        dp[i] = Math.max(dp[i - 2] * 2, dp[i - 3] * 3);
	    }
	    return dp[n];
	}
	public static void main(String[] args) {
		System.out.println(integerBreak(10));
	}
}
