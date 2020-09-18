package leetcode1600;

public class Leetcode1600 {
	public int missingNumber(int[] nums) {
		for(int i=0;i<nums.length;i++) {
			if(i!=nums[i]) {
				return i;
			}
		}
		return nums.length;
    }
}
