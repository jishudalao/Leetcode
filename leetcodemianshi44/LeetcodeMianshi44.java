package leetcodemianshi44;

public class LeetcodeMianshi44 {
	//������ûɶ˵�ģ���̵ľ�ͷ����ѧ
	public static int findNthDigit(int n) {
		//1:��λ��
		int weishu = 1;
		long curstart = 1;
		long curtotal = 9;
        while (n > curtotal) {
            n -= curtotal;
            weishu += 1;
            curstart *= 10;
            curtotal = weishu * curstart * 9;
        }
        //2:����������
        long num = curstart + (n - 1) / weishu; 
        return Long.toString(num).charAt((n - 1) % weishu) - '0';
    }
	public static void main(String[] args) {
		System.out.println(findNthDigit(365));
	}
}
