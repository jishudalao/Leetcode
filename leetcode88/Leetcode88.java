package leetcode88;

import java.util.Arrays;

public class Leetcode88 {
	 public static void merge(int[] nums1, int m, int[] nums2, int n) {
	      int len1 = m - 1;
	      int len2 = n - 1;
	      int len = m + n - 1;
	      while(len1>=0&&len2>=0) {
	    	  nums1[len--] =  nums1[len1] >  nums2[len2] ? nums1[len1--] : nums2[len2--];
	      }
	      System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
	    }
	 public static void main(String[] args) {
		int[] num1 = {1,2,3,6,0,0,0};
		int[] num2 = {2,5,7};
		merge(num1,4,num2,3);
		System.out.println(Arrays.toString(num1));
	}
}
