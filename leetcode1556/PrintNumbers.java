package leetcode1556;

import java.util.Arrays;

public class PrintNumbers {
	public static int[] printNumbers(int n) {
		int len = 0;
		int index = 10;
		for(int i=0;i<n;i++) {
			len += index - index/10;
			index *= 10;
		}
		int nums[] = new int[len];
		for(int i=0;i<nums.length;i++) {
			nums[i] = i+1;
		}
		return nums;
    }
	public static void main(String[] args) {
		System.out.println(Arrays.toString(printNumbers(3)));
	}
}
