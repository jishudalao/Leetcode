package leetcode945;

import java.util.Arrays;

public class MinIncrementForUnique {
	public static int minIncrementForUnique(int[] A) {
		Arrays.sort(A);
		int count = 0;
		if(A.length<=1) {
			return 0;
		}
		for(int i=1;i<A.length;i++) {
			while(A[i]<=A[i-1]) {
				count++;
				A[i]++;
			}
		}
		
		return count;
    }
	public static void main(String[] args) {
		int A[] = {3,2,1,2,1,7};
		System.out.println(minIncrementForUnique(A));
	}
}
