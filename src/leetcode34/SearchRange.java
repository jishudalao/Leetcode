package leetcode34;

import java.util.Arrays;

public class SearchRange {
	public static int[] searchRange(int[] nums, int target) {
		
	      int res[] = new int[2];
	      res[0] = -1;
	      res[1] = -1;
	      if(nums==null||nums.length==0) {
	    	  return res;
	      }
		        if(nums.length==1&&target==nums[0]) {
		        	
		        		res[0] = 0;
			        	res[1] = 0;
			        	return res;
		        	
		        }
		        
		        	
		        	int left = 0,right = nums.length-1;
		        	while(left<=right) {
		        		int mid = (left+right)/2;
		        		if(target==nums[mid]) {
		        			if(mid>0&&mid<nums.length-1) {
		        				if(nums[mid]==nums[mid-1]) {
		        					res[0] = mid-1;
			        	        	res[1] = mid;
		        				}else if(nums[mid]==nums[mid+1]) {
		        					res[0] = mid;
			        	        	res[1] = mid+1;
		        				}else {
		        					res[0] = mid;
		        					res[1] = mid;
		        				}
		        			}
		        			else if(mid==0) {
		        				res[0] = mid;
		        	        	if(nums[mid]==nums[mid+1]) {
		        	        		res[1] = mid+1;
		        	        	}else {
		        	        		res[1] = mid;
		        	        	}
		        			}
		        			else if(mid==nums.length-1) {
		        				res[1] = mid;
		        				if(nums[mid]==nums[mid-1]) {
		        	        		res[0] = mid-1;
		        	        	}else {
		        	        		res[0] = mid;
		        	        	}
		        			}
		        			return res;
		        		}
		        		if(target<nums[mid]) {
		        		right = mid-1;	
		        		}
		        		if(target>nums[mid]) {
		        			left = mid + 1;
		        		}
		        	}
		        	return res;  
	    }
	public static void main(String[] args) {
		int []nums = {1,2,2};
		System.out.println(Arrays.toString(searchRange(nums,2)));
	}
}
