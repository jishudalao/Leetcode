package strStr;

public class StrStr {

	public static void main(String[] args) {
		
		
		String haystack = "";
		String needle = " ";
		System.out.println(strStr(haystack, needle));
	}
	public int strStrs(String haystack, String needle) {
		return haystack.indexOf(needle);
		}

		
	public static int strStr(String haystack,String needle) {
		int index = -1;
		if(needle == "") {
			return 0;
		}
		if (haystack == ""&&needle == "") {
			
			return 0;
		}
		if(needle.length()>haystack.length()) {
			return -1;
		}
		Character flag;
		try {
			flag = needle.charAt(0);
		}catch(Exception e) {
			flag = 'a';
		}
		
		for(int i=0;i<haystack.length();i++) {
			if(haystack.charAt(i)==flag&&(haystack.length()-i-needle.length()>=0)) {
				index = i;
				for(int j=0;j<needle.length();j++) {
					if(needle.charAt(j)!=haystack.charAt(i+j)) {
						index = -1;
						break;
					}
				}
				if(index!=-1) {
					return index;
				}
			}
		}
		return index;
	}
}
