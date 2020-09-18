package leetcode84;

import java.util.Stack;

public class LargestRectangleArea {
	//暴力解法
	/* 
	public static int largestRectangleArea(int[] heights) {
		int h = heights.length;
		int max = 0;
		for(int i=0;i<h;i++) {
			int min = Integer.MAX_VALUE;
			for (int j = i; j < heights.length; j++) {
			min = Math.min(min, heights[j]);
			max = Math.max(max, min*(j-i+1));
		}
			}
		return max;
	}*/
	//分治法
	/*
	public static int calculateArea(int[] heights, int start, int end) {
        if (start > end)
            return 0;
        int minindex = start;
        for (int i = start; i <= end; i++)
            if (heights[minindex] > heights[i])
                minindex = i;
        return Math.max(heights[minindex] * (end - start + 1), Math.max(calculateArea(heights, start, minindex - 1), calculateArea(heights, minindex + 1, end)));
    }
    public static int largestRectangleArea(int[] heights) {
        return calculateArea(heights, 0, heights.length - 1);
    }
    */
	//单调栈
	public static int largestRectangleArea(int[] heights) {
        Stack < Integer > stack = new Stack < > ();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }  
        while (stack.peek() != -1)
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() -1));
        return maxarea;
    }

	public static void main(String[] args) {
		int[] heights = {6, 7, 5, 2, 4, 5, 9,3};
		System.out.println(largestRectangleArea(heights));
	}
}
