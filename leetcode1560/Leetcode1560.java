package leetcode1560;

import java.util.Arrays;

public class Leetcode1560 {
	public static int[] exchange(int[] nums) {
		int res[] = new int[nums.length];
		int left = 0;
		int right = nums.length-1;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]%2!=0) {
				res[left] = nums[i];
				left++;
			}
			else {
				res[right] = nums[i];
				right--;
					}
		}
		return res;
    }
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		System.out.println(Arrays.toString(exchange(nums)));
		
	}
}
