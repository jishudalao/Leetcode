package leetcode33;

public class Search {
	/*
	public static int search(int[] nums, int target) {
	     if(nums==null||nums.length==0) {
	    	 return -1;
	     }   
	     int start = 0,end = nums.length-1;
	     
	     while(start<=end) {
	    	 int mid = (start + end) / 2;
	    	 if(nums[mid]==target) {
	    		 return mid;
	    	 }
	    	 if(nums[start]<=nums[mid]) {
	    		 if(nums[start]<=target&&nums[mid]>=target) {
	    			 end = mid-1;
	    		 }else {
	    			 start = mid+1;
	    		 }
	    	 }else {
	    		 if(nums[mid]<target&&nums[end]>=target) {
	    			 start = mid+1;
	    		 }else {
	    			 end = mid-1;
	    		 }
	    	 }
	    	
	     }
	     return -1;
    }
	*/
	public static int search(int[] nums, int target) {
		int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid]))
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo == hi && nums[lo] == target ? lo : -1;
	}
	
public static void main(String[] args) {
	int nums[] = {4,5,6,7,0,1,2};
	System.out.println(search(nums, 0));
	System.out.println(true^false);
}
}
