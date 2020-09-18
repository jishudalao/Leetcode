package leetcode912;

import java.util.Arrays;

public class SortArray {
	//¶ÑÅÅĞò
	public static int[] sortArray(int[] nums) {
		for(int i=nums.length/2-1;i>=0;i--) {
			adjustDui(nums,i,nums.length);
		}
		for(int j=nums.length-1;j>0;j--) {
			swap(nums,0,j);
			adjustDui(nums, 0, j);
		}
		return nums;
	}
	
	private static void swap(int[] nums, int i, int j) {
		// TODO Auto-generated method stub
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private static void adjustDui(int[] nums, int i, int length) {
		// TODO Auto-generated method stub
		int temp = nums[i];
		for(int k=2*i+1;k<length;k=k*2+1) {
			if(k+1<length&&nums[k]<nums[k+1]) {
				k++;
			}
			if(nums[k]>temp) {
				nums[i] = nums[k];
				i = k;
			}else {
				break;
			}
		}
		nums[i] = temp;
	}

	public static void main(String[] args) {
		int nums[] = {5,1,1,2,0,0};
		System.out.println(Arrays.toString(sortArray(nums)));
	}
}
//Ã°ÅİÅÅĞò
/*
for(int i=0;i<nums.length-1;i++) {
	
	for(int j=i+1;j<nums.length;j++) {
		if(nums[i]>nums[j]) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
	}
}*/
//¹é²¢ÅÅĞò
/*
public static int[] sortArray(int[] nums) {

//¹é²¢ÅÅĞò
int temp[] = new int[nums.length];
int start = 0; 
int end = nums.length-1;
merge(nums, start, end, temp);
return nums;
}
public static void merge(int[] nums,int start,int end,int[] temp) {
if(start>=end) {
return;
}
int mid =(start+end)/2;
merge(nums,start,mid,temp);
merge(nums, mid+1, end, temp);
if (nums[mid] <= nums[mid + 1]) {
return;
}
mergeTwoSortedArrays(nums,start,end,temp);


}
private static void mergeTwoSortedArrays(int[] nums, int start, int end, int[] temp) {
// TODO Auto-generated method stub
int mid = (start+end)/2;
int i = start;
int j = mid+1;
int current = start;
while(i<=mid&&j<=end) {
if(nums[i]<=nums[j]) {
	temp[current++] = nums[i++];
}else {
	temp[current++] = nums[j++];
}
}
while(i<=mid) {
temp[current] = nums[i++];
current++;
}
while(j<=end) {
temp[current] = nums[j++];
current++;
}
for(int k=start;k<=end;k++){
nums[k]=temp[k];
}
}*/
//¿ìÅÅ
	/*
	public static int[] sortArray(int[] nums) {
		int left = 0;
		int right = nums.length-1;
		quickSort(nums,left,right);
		return nums;
	}
	private static void quickSort(int[] nums, int left, int right) {
		// TODO Auto-generated method stub
		if(left<right) {
			int mid = getMiddle(nums,left,right);
			quickSort(nums, left, mid-1);
			quickSort(nums, mid+1, right);
		}
	}
	private static int getMiddle(int[] nums, int left, int right) {
		// TODO Auto-generated method stub
		int i = left;
		int j = right;
		int temp = nums[left];
		while(i<j) {
			while(i<j&&temp<=nums[j]) {
				j--;
			}
			while(i<j&&temp>=nums[i]) {
				i++;
			}
			if(i<j) {
				int l = nums[i];
				int r = nums[j];
				nums[i] = r;
				nums[j] = l;
			}
		}
		nums[left] = nums[i];
		nums[i] = temp;
		
		return i;
	}*/
