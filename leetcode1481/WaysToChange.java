package leetcode1481;

public class WaysToChange {
	public int waysToChange(int n) {
		int[] dp = new int[n + 1];
		        
		        int[] coins = new int[]{1,5,10,25};
		        
		        
		        //刚好可以用一个硬币凑成的情况，是一种情况
		        // while i == coin :
		        //dp[i] = dp[i - coin] => dp[0]
		        dp[0] = 1;
		        
		        /**
		        * dp方程：dp[i] += dp[i - coin];
		        */
		        
		        for(int coin : coins) {
		            for(int i = coin; i <= n; i++) {
		                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
		            }
		        }
		        
		        return dp[n];
		    }
}
