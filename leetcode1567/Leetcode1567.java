package leetcode1567;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1567 {
	public int[] spiralOrder(int[][] matrix) {
		List<Integer> ans = new ArrayList<Integer>();
		if(matrix.length==0) {
			return new int[0];
		}
		int r1 =0;
		int r2 = matrix.length-1;
		int col1 = 0;
		int col2 = matrix[0].length-1;
		while(r1<=r2&&col1<=col2) {
			for(int i=col1;i<=col2;i++) {
				ans.add(matrix[r1][i]);
			}
			for(int i=r1+1;i<=r2;i++) {
				ans.add(matrix[i][col2]);
			}
			if(col1!=col2&&r1!=r2) {
				for(int i=col2-1;i>col1;i--) {
					ans.add(matrix[r2][i]);
				}
				for(int i=r2;i>r1;i--) {
					ans.add(matrix[i][col1]);
				}
			}
			
			r1++;
			r2--;
			col1++;
			col2--;
		}
		int res[] = new int[ans.size()];
		for(int i=0;i<ans.size();i++) {
			res[i] = ans.get(i);
		}
       return res;
    }
}
