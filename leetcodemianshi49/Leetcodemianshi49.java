package leetcodemianshi49;

public class Leetcodemianshi49 {
	//动态规划
	//dp[n+1] = dp[a] *2 或dp[b] *3 或 dp[c] *5;
	public static int nthUglyNumber(int n) {
		int a = 0,b = 0,c = 0;
		int dp[] = new int[n];
		dp[0] = 1;
		for(int i=1;i<n;i++) {
			dp[i] = Math.min(Math.min(dp[a] *2, dp[b] * 3), dp[c] *5);
			if(dp[i]==dp[a] *2) {
				a++;
			}
			if(dp[i]==dp[b] *3) {
				b++;
			}
			if(dp[i]==dp[c] *5) {
				c++;
			}
		}
		return dp[n-1];
    }
	public static void main(String[] args) {
		System.out.println(nthUglyNumber(10));
	}
}
