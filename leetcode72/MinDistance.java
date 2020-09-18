package leetcode72;

public class MinDistance {
	public int minDistance(String word1, String word2) {
		int n = word1.length();
		int m = word2.length();
		if(m*n==0) {
			return m+n;
		}
		int dp[][] = new int[n+1][m+1];
		
		for(int i=0;i<dp.length;i++) {
			dp[i][0] = i;
		}
		
		for(int i=0;i<dp[0].length;i++) {
			dp[0][i] = i;
		}
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<m+1;j++) {
				int left = dp[i][j-1]+1;
				int mid = dp[i-1][j]+1;
				int right = dp[i-1][j-1];
				if(word1.charAt(i - 1) != word2.charAt(j - 1)) {
					right++;
				}
				dp[i][j] = Math.min(left, Math.min(mid, right));
			}
		}
		return dp[n][m];
    }
}
