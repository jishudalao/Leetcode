package leetcode1620;

public class Leetcode1620 {
	//������λ���㣬�����Ҳ��ᣬ������ѡ��ݹ�
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
