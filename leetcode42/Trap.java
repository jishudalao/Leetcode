package leetcode42;

import java.util.Arrays;

public class Trap {
	public static int trap(int[] height) {
        int left = 0, right = height.length - 1;
	    int ans = 0;
	    int left_max = 0, right_max = 0;
	    while (left < right) {
	        if (height[left] < height[right]) {
	        	if(height[left] >= left_max) {
	        		left_max = height[left];
	        	}else {
	        		ans += (left_max - height[left]);
	        	}
	            
	            ++left;
	        }
	        else {
	        	if(height[right] >= right_max) {
	        		right_max = height[right];
	        	}else {
	        		ans += (right_max - height[right]);
	        	}
	             
	            --right;
	        }
	    }
	    return ans;
    }
	public static void main(String[] args) {
		int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(height));
	}
}
