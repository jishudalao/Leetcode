package leetcode1554;

public class HammingWeight {
	public static int hammingWeight(int n) {
        int count = 0;
		while(n!=0) {
			//���⿼��λ����
			count += (n & 1);
			//ֱ�Ӷ�λ��1��λ��
			n = n >>> 1;
		}
		return count;
    }
	public static void main(String[] args) {
		System.out.println(hammingWeight(9));
	}
}
