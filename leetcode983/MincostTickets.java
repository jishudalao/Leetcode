package leetcode983;

public class MincostTickets {
	public static int mincostTickets(int[] days, int[] costs) {
		int maxDay = days[days.length-1];
		int minDay = days[0];
		int index = days.length-1;
		int dp[] = new int[maxDay+31];
		for(int d=maxDay;d>=minDay;d--) {
			if(d==days[index]) {
				dp[d] = Math.min(Math.min(dp[d+1]+costs[0], dp[d+7]+costs[1]), dp[d+30]+costs[2]);
				index--;
			}else {
				dp[d] = dp[d+1];
			}
		}
		return dp[minDay];
    }
	public static void main(String[] args) {
		int days[] = {1,4,6,7,8,20};
		int costs[] = {2,7,15};
		System.out.println(mincostTickets(days, costs));
	}
}
