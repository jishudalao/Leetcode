package leetcodemianshi46;

public class TranslateNum {
	public static int translateNum(int num) {
		//这题动态规划,参考斐波那契
			String s = String.valueOf(num);
	        int len = s.length()+1;
	        int[] dp = new int[len];
	        dp[1] = 1;
	        dp[0] = 1;
	        for(int i = 2; i<len; i++){
	            int temp = Integer.valueOf(s.substring(i-2,i));
	            if(temp > 9 && temp < 26 ){
	                dp[i] = dp[i-1] + dp[i-2];
	            }else{
	                dp[i] = dp[i-1];
	            }
	        }
	        return dp[len-1];
    }
	public static void main(String[] args) {
		System.out.println(translateNum(12258));
	}
}
