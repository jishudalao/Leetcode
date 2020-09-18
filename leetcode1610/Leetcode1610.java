package leetcode1610;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode1610 {
	public int[] maxSlidingWindow(int[] nums, int k) {
	    if(nums.length==0) return new int[0];
	    int index = 0;
	    //Deque<Integer> stack = new LinkedList<>();
	    int res[] = new int[nums.length-k+1];
	    for(int i=0;i<nums.length-k+1;i++){
	    	int max = Integer.MIN_VALUE;
	        int arr[] = new int[k];
	        for(int j=i;j<i+k;j++){
	            max = Math.max(max, nums[j]);
	        }
	        res[index++] = max;
	    }
	    return res;
	};
}
