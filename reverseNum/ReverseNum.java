package reverseNum;

public class ReverseNum {
	public static boolean IsReverseNum(int x) {
		int y = x;
		if(x==0) {
			return true;
		}
		if(x<0||x%10==0) {
			return false;
		}
		int result = 0;
		while(x!=0) {
			result = result * 10 + x % 10;
			x /= 10;
		}
		
		if(result==y) {
			return true;
		}else {
			return false;
		}
	}
	public static void main(String[] args) {
		System.out.println(IsReverseNum(120000));
	}
}
