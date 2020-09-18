package leetcode1588;

public class Leetcode1588 {
	public int maxSubArray(int[] nums) {
		int b = 0;
        int sum = nums[0];
        for(int i=0;i<nums.length;i++) {
        	if(b>0) {
        		b += nums[i];
        	}
        	else {
        		b = nums[i];
        	}
        	if(b>sum) {
        		sum = b;
        	}
        }
        return sum;
    }
}
