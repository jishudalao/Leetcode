package leetcode152;

public class Leetcode152 {
	//这题我再用暴力解法我就是狗
	public int maxProduct(int[] nums) {
		if(nums.length==0) {
			return 0;
		}
		int dp[][] = new int[nums.length][2];
		dp[0][0] = nums[0];
		dp[0][1] = nums[0];
		int max = dp[0][1];
		for(int i=1;i<nums.length;i++) {
			if(nums[i]>0) {
				dp[i][0] = Math.min(nums[i], dp[i-1][0] * nums[i]);
				dp[i][1] = Math.max(nums[i], dp[i-1][1] * nums[i]);
			} else {
				dp[i][0] = Math.min(nums[i], dp[i-1][1] * nums[i]);
				dp[i][1] = Math.max(nums[i], dp[i-1][0] * nums[i]);
			}
			max = Math.max(max, dp[i][1]);
		}
		return max;
    }
}
