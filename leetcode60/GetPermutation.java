package leetcode60;
import java.util.HashMap;
public class GetPermutation {
	 public static void main(String[] args) {
			System.out.println(getPermutation(4, 9));
		}
	
	 public static String getPermutation(int n, int k) {
		 int[] nums = new int[n];
		 	for(int i=0;i<n;i++) {
		 		nums[i] = i+1;
		 	}
		 	for(int i=0;i<k-1;i++) {
		 		nextPermutation(nums);
		 	}
		 	StringBuilder sb = new StringBuilder();
		 	for(int i=0;i<n;i++) {
		 		sb.append(nums[i]);
		 	}
		 	return sb.toString();
		 	
	    }
	 public static void nextPermutation(int[] nums) {
	        int i = nums.length - 2;
	        while (i >= 0 && nums[i + 1] <= nums[i]) {
	            i--;
	        }
	        if (i >= 0) {
	            int j = nums.length - 1;
	            while (j >= 0 && nums[j] <= nums[i]) {
	                j--;
	            }
	            swap(nums, i, j);
	        }
	        reverse(nums, i + 1);
	    }

	    private static void reverse(int[] nums, int start) {
	        int i = start, j = nums.length - 1;
	        while (i < j) {
	            swap(nums, i, j);
	            i++;
	            j--;
	        }
	    }

	    private static void swap(int[] nums, int i, int j) {
	        int temp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = temp;
	    }
}
