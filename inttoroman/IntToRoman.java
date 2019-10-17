package inttoroman;

public class IntToRoman {
	 /* if(str.indexOf(0)=='0') {
	 
	  for (int i = 1; i < str.length(); i++) {
		  sb.append(str.indexOf(i));
		}
	 
	  str = sb.toString();
}*/
	 public static int reverse(int x) {
		 Integer s = x;
		 
		 StringBuilder sb = new StringBuilder();
		
			s = Math.abs(s);
			String strs = s.toString();
			
	        String str =   reaverseString(strs.toString());
	    
	        int result = 0;
	      try {
	    	  result = Integer.parseInt(str);
	      } catch(Exception e) {
	    	result = 0;
	      }
	   
	   
	    if(x<0) {
	    	result = 0 - result;
	    }
	    return result;
	    }
	 
	 public static void main(String[] args) {
		//System.out.println(Integer.MAX_VALUE);	
		// System.out.println(reverse(1111113125));
		 //System.out.println(reverse(-125000000));
		 System.out.println(intToRoman(2051));
	 }

	public static String reaverseString(String src) {

		char[] arr = src.toCharArray();

		char[] newArr = new char[arr.length];

		int index = arr.length-1;

		for (int i = 0; i < arr.length; i++) {

			char temp = arr[i];

			newArr[index--] = temp;

			}

		return new String(newArr);

	}
 
	public static int romanToInts(String s) {
		int totalSum = 0;
		int i = s.length()-1;
		int lastNum = 0;
		while(i>=0) {
			if(i==0) {
				lastNum =  translate(s.charAt(i));
				i--;
				}
				else {
					int num1 = translate(s.charAt(i));
					int num2 = translate(s.charAt(i-1));
					if(num1<=num2) {
						if(i-2>=0&&translate(s.charAt(i-2))<num2){
							totalSum += num2 - translate(s.charAt(i-2)) + num1;
							i = i - 3;
						}
						else {
							totalSum += num1 + num2;
							i = i - 2;
						}
					}
					if(num1>num2) {
						totalSum += num1-num2;
						i = i - 2;
					}
				
				}
				
		}
		return totalSum + lastNum;
	}

public static int translate(Character s) {
	int trans = 0;
	if(s.equals('I')) {
		trans = 1;
	}
	else if (s.equals('V')) {
		trans = 5;
	}
	else if (s.equals('X')) {
		trans = 10;
	}
	else if (s.equals('L')) {
		trans = 50;
	}
	else if (s.equals('C')) {
		trans = 100;
	}
	else if (s.equals('D')) {
		trans = 500;
	}
	else if (s.equals('M')) {
		trans = 1000;
	}
	return trans;
}
	public static String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		final int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		final String[] str = {"M", "CM", "D", "CD",
		        "C", "XC", "L", "XL",
		        "X", "IX", "V", "IV",
		        "I"};
		int k = 0;
		while(num>0) {
			int count = num / values[k];
			for(int i=0;i<count;i++) {
				sb.append(str[k]);
				num = num - values[k];
			}
			
			k++;
		}
		return sb.toString();
	}
}
