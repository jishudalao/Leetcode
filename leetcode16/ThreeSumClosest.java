package leetcode16;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClo(int[] nums,int target) {
		Arrays.sort(nums);
		int ans = nums[0] +nums[1] +nums[2];
		for(int i=0;i<nums.length;i++) {
			int start = i+1;
			int end = nums.length-1;
			while(start<end) {
				int sum = nums[start] +nums[end] +nums[i];
				if(Math.abs(sum-target)<Math.abs(ans-target)) {
					ans = sum;
				}
				if(sum<target) {
					start++;
				}else if(sum>target) {
					end--;
				}else {
					return ans;
				}
			}
			
		}
		return ans;
	}
}
