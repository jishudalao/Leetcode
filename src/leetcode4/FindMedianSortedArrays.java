package leetcode4;

import java.util.Arrays;

public class FindMedianSortedArrays {
	 public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        int array[] = new int[nums1.length+nums2.length];
	        for(int i=0;i<nums1.length;i++) {
	        	array[i] = nums1[i];
	        }
	        for(int i=0;i<nums2.length;i++) {
	        	array[nums1.length+i] = nums2[i];
	        }
	        Arrays.sort(array);
	        if(array.length%2!=0) {
	        	return (double)array[array.length/2];
	        }else {
	        	return ((double)array[array.length/2]+(double)array[(array.length-1)/2])/2;
	        }
	        
	    }
	 public static void main(String[] args) {
		 int[] nums1 = {1, 2};
		 int[] nums2 = {3, 4};
		 System.out.println(findMedianSortedArrays(nums1, nums2));
		
	}
}
