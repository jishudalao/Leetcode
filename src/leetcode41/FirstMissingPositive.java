package leetcode41;

public class FirstMissingPositive {
	public static int firstMissingPositive(int[] nums) {
	   int len = nums.length;
	   int flag = 0;
	   for(int i=0;i<len;i++) {
		   if(nums[i]==1) {
			   flag++;
			   break;
		   }
	   }
	   if(flag==0) {
		   return 1;
	   }
	   if(len==1) {
		   return 2;
	   }
	   for(int i=0;i<len;i++) {
		   if(nums[i]<=0||nums[i]>len) {
			   nums[i] = 1;
		   }
	   }
	   for(int i=0;i<len;i++) {
		   int a = Math.abs(nums[i]);
		   if(a==len) {
			   nums[0] = -Math.abs(nums[0]);
		   }else {
			   nums[a] =-Math.abs(nums[a]);
		   }
	   }
	   for(int i=1;i<len;i++) {
		   if(nums[i]>0) {
			   return i;
		   }
	   }
	   if(nums[0]>0) {
		   return len;
	   }
	   return len+1;
	  }
	public static void main(String[] args) {
		//int nums[] = {3,4,-1,-2,1,5,16,0,2,0};
		int nums[] = {0,1,2,3,4,5};
		System.out.println(firstMissingPositive(nums));
	}
}
