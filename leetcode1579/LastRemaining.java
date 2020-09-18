package leetcode1579;

import java.util.ArrayList;

public class LastRemaining {
	public static int lastRemaining(int n, int m) {
		 /*
		int current = 0;
		boolean[] flag = new boolean[n];
		for(int i=0;i<n-1;i++) {
			int bianli = 0;
			while(bianli<m) {
				if(flag[current]==false) {
					bianli++;
				}
				current++;
				if(current==n) {
					current=0;
				}
			}
			if(current==0) {
				flag[n-1] = true;
			}else {
				flag[current-1] = true;
			}
		
		}
		for(int i=0;i<n;i++) {
			if(flag[i]==false) {
				return i;
			}
		}
		return 0;*/
		/*
		 ArrayList<Integer> list = new ArrayList<>(n);
	        for (int i = 0; i < n; i++) {
	            list.add(i);
	        }
	        int idx = 0;
	        while (n > 1) {
	            idx = (idx + m - 1) % n;
	            list.remove(idx);
	            n--;
	        }
	        return list.get(0);*/
		int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
	public static void main(String[] args) {
		int m = 5;
		int n = 3;
		System.out.println(lastRemaining(m, n));
	}
}
