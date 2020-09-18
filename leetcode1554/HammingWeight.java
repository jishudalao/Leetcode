package leetcode1554;

public class HammingWeight {
	public static int hammingWeight(int n) {
        int count = 0;
		while(n!=0) {
			//这题考察位运算
			count += (n & 1);
			//直接定位到1的位置
			n = n >>> 1;
		}
		return count;
    }
	public static void main(String[] args) {
		System.out.println(hammingWeight(9));
	}
}
