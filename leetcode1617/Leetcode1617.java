package leetcode1617;

public class Leetcode1617 {
	public static int add(int a, int b) {
		int carry = 0;
		while(b!=0) {
			carry = (a&b)<<1;//ֻ���ǽ�λ
			a = a^b;//�����ǽ�λ
			b = carry;
		}
		return a;
    }
	public static void main(String[] args) {
		System.out.println(add(11,23));
	}
}
