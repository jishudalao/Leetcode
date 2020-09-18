package leetcodemianshi44;

public class LeetcodeMianshi44 {
	//这种题没啥说的，编程的尽头是数学
	public static int findNthDigit(int n) {
		//1:求位数
		int weishu = 1;
		long curstart = 1;
		long curtotal = 9;
        while (n > curtotal) {
            n -= curtotal;
            weishu += 1;
            curstart *= 10;
            curtotal = weishu * curstart * 9;
        }
        //2:求所在数字
        long num = curstart + (n - 1) / weishu; 
        return Long.toString(num).charAt((n - 1) % weishu) - '0';
    }
	public static void main(String[] args) {
		System.out.println(findNthDigit(365));
	}
}
