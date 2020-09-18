package leetcode1549;

public class MinArray {
	public static int minArray(int[] numbers) {
		for(int i=0;i<numbers.length-1;i++) {
			if(numbers[i+1]<numbers[i]) {
				return numbers[i+1];
			}
		}
		return numbers[0];
    }
	public static void main(String[] args) {
		int[] numbers = {3,4,5,6,1};
		System.out.println(minArray(numbers));
	}
}
