package leetcode69;

public class MySqrt {
	public static int mySqrt(int x) {
		if(x<2) {
			return x;
		}
		long num ;
		int left = 2, right = x/2;
		int mid = (left+right)/2;
		while(left<=right) {
			mid = (left+right)/2;
			num = (long)mid * mid;
			if(num>x) {
				right = mid-1;
			}else if(num<x) {
				left = mid+1;
			}else {
				return mid;
			}
		}
		return right;
    }
	public static void main(String[] args) {
		System.out.println(mySqrt(26));
	}
}
