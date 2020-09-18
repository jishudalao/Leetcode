package leetcode1548;

public class NumWays {
	public int numWays(int n) {
		if(n==0) {
			return 1;
		}
		int a = 0;//代表n
		int b = 1;
		int sum = 0;//代表n+1
		for(int i=0;i<n;i++) {
			sum = (a+b)%1000000007;
			a = b;
			b = sum;
		}
		return sum;
    }
}
