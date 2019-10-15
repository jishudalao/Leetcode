package leetcode11;

public class MaxArea {
	/*暴力破解
	public static int maxAreas(int[] height) {
        int maxArea = 0;
        for(int i=0;i<height.length;i++) {
        	for(int j=i+1;j<height.length;j++) {
        		maxArea = Math.max(maxArea, Math.min(height[i], height[j])*(j-i));
        	}
        }		
        return maxArea;
    }
	*/
	//双指针法
	public static int maxArea(int[] height) {
		int maxArea = 0;
		int l = 0;
		int r = height.length-1;
		while(l<r) {
			maxArea = Math.max(maxArea, Math.min(height[l], height[r])*(r-l));
			if(height[l]<=height[r]) {
				l++;
			}else {
				r--;
			}

		}
		return maxArea;
	}
	
	
	public static void main(String[] args) {
		int height[] = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(height));
	}
}
