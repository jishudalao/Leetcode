package leetcode914;

import java.util.Arrays;

public class HasGroupsSizeX {
	public static boolean hasGroupsSizeX(int[] deck) {
		/*
		if(deck.length<=1) {
			return false;
		}
		Arrays.sort(deck);
		int x = 1;
		int y = 1;
		boolean flag = true;
		int index = 1;
		while(index<deck.length&&deck[index]==deck[index-1]) {
			index++;
		}
		if(index==deck.length) {
			if(deck[0]==1||deck[0]==0) {
				return true;
			}
			else {
				return false;
			}
		}
		
		x = index;
		for(int i=index+1;i<deck.length;i++) {
			if(deck[i]==deck[i-1]) {
				y++;
			}else {
				if(get_gcd(x,y)==1) {
					return !flag;
				}
				x = y;
				y = 1;
			}
		}
		if(get_gcd(x,y)==1) {
			return !flag;
		}
		
		return flag;*/
		int[] count = new int[10000];
        for (int c: deck)
            count[c]++;

        int g = -1;
        for (int i = 0; i < 10000; ++i)
            if (count[i] > 0) {
                if (g == -1)
                    g = count[i];
                else
                    g = gcd(g, count[i]);
            }

        return g >= 2;
    }
	public static void main(String[] args) {
		int deck[] = {1,2,3,4,4,3,2,1};
		System.out.println(hasGroupsSizeX(deck));
	}
	public static int gcd(int x, int y) {
        return x == 0 ? y : gcd(y%x, x);
    }
	public static int get_gcd(int a, int b) {
		int max, min;
		max = (a > b) ? a : b;
		min = (a < b) ? a : b;

		if (max % min != 0) {
			return get_gcd(min, max % min);
		} else
			return min;
	}
}
