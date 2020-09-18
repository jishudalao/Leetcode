package leetcode1496;

public class Massage {
	public static int massage(int[] nums) {
		/*
		int first=0;
        int second=0;
        for(int i:nums){
            int temp=second;
            second=Math.max(second,first+i);
            first=temp;
        }
        return second;*/
		int n = nums.length;
        if (n==0) return 0;
        int dp0 = 0, dp1 = nums[0];

        for (int i = 1; i < n; ++i){
            int tdp0 = Math.max(dp0, dp1); // 计算 dp[i][0]
            int tdp1 = dp0 + nums[i]; // 计算 dp[i][1]

            dp0 = tdp0; // 用 dp[i][0] 更新 dp_0
            dp1 = tdp1; // 用 dp[i][1] 更新 dp_1
        }
        return Math.max(dp0, dp1);
    }
	
	//最大子序列和
	public static int zuida (int[] nums) {
		//贪心
		/*
		int max = nums[0];
		int current = nums[0];
		for(int i=1;i<nums.length;i++) {
			current = Math.max(nums[i], current+nums[i]);
			max = Math.max(max, current);
		}
		return max;*/
		//动态规划
		int max = nums[0];
		for(int i=1;i<nums.length;i++) {
			if(nums[i-1]>0) {
				nums[i] += nums[i-1];
			}
			max = Math.max(max, nums[i]);
		}
		return max;
	}
	public static void main(String[] args) {
		int nums[] = {2,1,4,5,3,1,1,3};
		System.out.println(massage(nums));
		
		int num[] =  {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(zuida(num));
	}
}
