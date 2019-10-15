package leetcode43;

public class Multipy {
	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		int length1 = num1.length();
		int length2 = num2.length();
		StringBuilder str = new StringBuilder();
		int[] array = new int[length1+length2];
		for(int i=length1-1;i>=0;i--) {
			int index1 = num1.charAt(i)-48;
			
			for(int j=length2-1;j>=0;j--) {
				int index2 = num2.charAt(j)-48;
				array[i+j] += index1 * index2;
				if(array[i+j]>=10&&(i+j)!=0) {
					array[i+j-1] += array[i+j]/10;
					array[i+j] = array[i+j]%10;
				}
			}
		}
		for(int i=0;i<=array.length-2;i++) {
			str.append(array[i]);
		}
		return str.toString();
	}

	
}
