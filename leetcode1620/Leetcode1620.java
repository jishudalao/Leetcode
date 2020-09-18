package leetcode1620;

public class Leetcode1620 {
	//这题是位运算，但是我不会，所以我选择递归
	public static int sumNums(int n) {
		if(n==1) {
			return 1;
		}
		return n + sumNums(n-1);
    }
	public static void main(String[] args) {
		System.out.println(sumNums(10));
	}
}
