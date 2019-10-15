package leetcode42;

public class Trap {
	//机智法
	/*
	public static int trap(int[] height) {
		int ans = 0;
		int len = height.length;
		if(len<=1) {
			return 0;
		}
		for(int i=1;i<len-1;i++) {
			int left = 0,right = 0;
			for(int j=i;j>=0;j--) {
				left = Math.max(left, height[j]);
			}
			for(int j=i;j<len;j++) {
				right = Math.max(right, height[j]);
			}
			ans += Math.min(left, right) - height[i];
		}
		return ans;
	}
	
	*/
	//更机智法
	/*
	public static int trap(int[] height) {
		int ans =0;
		int len = height.length;
		int[] left = new int[len];
		int[] right = new int[len];
		left[0] = 0;
		for(int i=1;i<len;i++) {
			left[i] = Math.max(left[i-1], height[i]);
		}
		right[len-1] = 0;
		for(int i=len-2;i>=0;i--) {
			right[i] = Math.max(right[i+1], height[i]);
		}
			
		for(int i=1;i<len-1;i++) {
			ans += Math.min(left[i], right[i]) - height[i];
		}
		
		return ans;
	}*/
	
	//栈
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
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(height));
	}
}
