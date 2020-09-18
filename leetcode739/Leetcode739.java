package leetcode739;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Leetcode739 {
	public static int[] dailyTemperatures(int[] T) {
		//����ջ
		
        int length = T.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            int temperature = T[i];
            while (!stack.isEmpty() && temperature > T[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
		
		//˫ָ��
		/*
		for (int i = 0,j=i+1; i < T.length;) {
            //�߽�2���൱�����һ��Ԫ�أ�ѭ������
            if(i==T.length-1){
                T[i] = 0;
                break;
            }
            if(T[i]<T[j]){
                //j��i֮��ľ������Ҫ��Ľ��
                T[i] = j-i;
                i++;
                j=i+1;
                continue;
            }else{
                j++;
            }
            //�߽�1���൱��j����������Ԫ�ض�û���ҵ����ʵ�
            if(j==T.length){
                T[i] = 0;
                i++;
                j=i+1;
                continue;
            }
        }
        return T;*/
		/*
		if(T==null||T.length==0) {
			return new int[0];
		}
		int left=0;
		int right = left+1;
		while(left!=T.length-1) {
			if(T[left]<T[right]) {
				T[left] = right-left;
				left++;
				right = left+1;
				continue;
			}
			else {
				right++;
			}
			if(right==T.length) {
				T[left] = 0;
				left++;
				right = left+1;
				continue;
			}
		}
		T[left] = 0;
		return T;*/
    }
	public static void main(String[] args) {
		int T[] = {73, 74, 75, 71, 69, 72, 76, 73};
		System.out.println(Arrays.toString(dailyTemperatures(T)));
	}
}
