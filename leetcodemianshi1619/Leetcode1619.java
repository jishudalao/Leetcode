package leetcodemianshi1619;

public class Leetcode1619 {
	//Ì°ÐÄËã·¨
	public static int maxProfit(int[] prices) {
		if (prices.length == 0) return 0;
		int maxLi = 0;
		int min = prices[0];
		for(int i=1;i<prices.length;i++) {
			maxLi = Math.max(maxLi, prices[i]-min);
			if(min>prices[i]) {
				min = prices[i];
			}
		}
		return maxLi;
    }
	public static void main(String[] args) {
		int prices[] = {7,1,5,3,6,4};
		System.out.println(maxProfit(prices));
	}
}
