package removeVal;

public class RemoveVal {
	public static int removeVal(int nums[],int val) {
		int first = 0;
		int last = nums.length-1;
		while(first<=last) {
			if(first==last) {
				if(nums[first]!=val) {
					first++;
				}
				break;
			}
			if(nums[first]!=val) {
				first++;
				
			}else {
				while(nums[last]==val&&first<last) {
					last--;
				}
				nums[first] = nums[last];
				if(first<=last) {
					last--;
				}
			}
		}
		if(first==0) {
			return 0;
		}
		else {
			for(int i=0;i<first;i++) {
				System.out.print(nums[i]+" ");
			}
			return first;
		}
		
	}
	public static void main(String[] args) {
		int nums[] = {0,1,2,2,3,0,4,2};
		int num[] = {1};
		int nu[] = {3,3};
		System.out.println(removeVal(nu,3));
	}
}
