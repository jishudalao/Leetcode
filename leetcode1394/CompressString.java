package leetcode1394;

public class CompressString {

	public static String compressString(String S) {
		if(S.length()<=1) {
			return S;
		}
		StringBuilder str = new StringBuilder();
		int len = 1;
		int count = 1;
		char test = S.charAt(0);
		while(len<S.length()) {
			if(test==S.charAt(len)) {
				count++;
				
			}
			else {
				str.append(test);
				str.append(count);
				count = 1;
				test = S.charAt(len);
			}
			len++;
		}
		str.append(test);
		str.append(count);
		if(str.length()<S.length()) {
			return str.toString();
		}
		else {
			return S;
		}
    }
	public static void main(String[] args) {
		//String S = "aabcccccaaa";
		String S = "";
		//System.out.println("a");
		System.out.println(compressString(S));
	}
}
