package leetcode41;

public class FirstMissingPositive {
	 public static int firstMissingPositive(int[] nums) {
	       for(int i=0;i<nums.length;i++) {
	    	   while(nums[i]>0&&nums[i]<=nums.length&&nums[nums[i]-1]!=nums[i]) {
	    		   swap(nums,i,nums[i]-1);
	    	   }
	       }
	       for(int i=0;i<nums.length;i++) {
	    	   if(nums[i]!=i+1) {
	    		   return i+1;
	    	   }
	       }
	       return nums.length+1;
	    }
	 private static void swap(int[] nums, int index1, int index2) {
	        if (index1 == index2) {
	            return;
	        }
	        int temp = nums[index1];
	        nums[index1] = nums[index2];
	        nums[index2] = temp;
	    }

	
	public static void main(String[] args) {
		 int[] nums = {2,3,4,-1,1};
		 System.out.println(firstMissingPositive(nums));
	}
}
