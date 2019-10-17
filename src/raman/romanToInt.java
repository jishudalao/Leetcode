package raman;

public class romanToInt {
	public static int romanToInt(String s) {
		int totalSum = 0;
		
		int lastNum = 0;
			for(int i=s.length()-1;i>=0;i-=2) {
				if(i==0) {
				lastNum =  translate(s.charAt(i));
				}
				else {
					int num1 = translate(s.charAt(i));
					int num2 = translate(s.charAt(i-1));
					if(num1<=num2) {
						if(i-2>=0&translate(s.charAt(i-2))<num2){
							totalSum = num2 - translate(s.charAt(i-2)) + num1;
							i--;
						}
						else {
							totalSum += num1 + num2;
						}
					}
					if(num1>num2) {
						totalSum += num1-num2;
					}
				System.out.println(totalSum);
				}
				
			}
			return totalSum+lastNum;
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
	public static void main(String[] args) {
		//System.out.println(romanToInt("MCDLXXVI"));
		//System.out.println(romanToInts("MCDLXXVI"));
		System.out.println(romanToInts("MMCDXXV"));
		
	}
}
