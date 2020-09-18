package leetcodemianshi14q1;

public class Leetcodemianshi14q1 {
	public int cuttingRope(int n) {
		/*
		int mod = (int)1e9 + 7;
		if(n<=3) {
			return n-1;
		}
	    long[] dp = new long[n + 1];
	    dp[2] = 2;//注意，这相当于底
	    dp[3] = 3;
	    for (int i = 4; i < dp.length; i++) {
	        dp[i] = Math.max(dp[i - 2] * 2, dp[i - 3] * 3) % mod;
	    }
	    return (int)dp[n];*/
		if(n == 2) {
            return 1;
        }
        if(n == 3){
            return 2;
        }
        int mod = (int)1e9 + 7;
        long res = 1;
        while(n > 4) {
            res *= 3;
            res %= mod;
            n -= 3;
        }
        return (int)(res * n % mod);
    }
}
