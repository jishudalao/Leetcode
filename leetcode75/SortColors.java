package leetcode75;

import java.util.Arrays;

public class SortColors {
	public static void sortColors(int[] nums) {
		/*
		int num = 0;
		int num1 = 0;
		int num2 = 0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==0) {
				num++;
			}
			else if(nums[i]==1) {
				num1++;
			}else {
				num2++;
			}
		}
		int index = 0;
		for(int i=0;i<num;i++) {
			nums[index++] = 0;
		}
		for(int i = num;i<num+num1;i++) {
			nums[index++] = 1;
		}
		for(int i=num+num1;i<num+num1+num2;i++) {
			nums[index++] = 2;
		}*/
		//ºÉÀ¼¹úÆìÎÊÌâ
		int po = 0;
		int p1 = nums.length-1;
		int current = 0;
		int temp;
		while(current<=p1) {
			if(nums[current]==0) {
				temp = nums[po];
				nums[po++] = nums[current];
				nums[current++] = temp;
			}else if(nums[current]==2) {
				temp = nums[p1];
				nums[p1--] = nums[current];
				nums[current] = temp;
			}else {
				current++;
			}
		}
    }
	public static void main(String[] args) {
		int nums[] = {2,0,2,1,1,0};
		System.out.println(Arrays.toString(nums));
		sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}
}
