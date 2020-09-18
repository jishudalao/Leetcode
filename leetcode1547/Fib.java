package leetcode1547;

public class Fib {
	public static int fib(int n) {
		int a = 0;//代表n
		int b = 1;
		int sum = 0;//代表n+1
		for(int i=0;i<n;i++) {
			sum = (a+b)%1000000007;
			a = b;
			b = sum;
		}
		return a;
    }
	public static void main(String[] args) {
		System.out.println(fib(5));
	}
}
