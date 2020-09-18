package leetcode1542;

public class FindNumberIn2DArray {
	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		//这种题得观察，不能从左上角或者右下角遍历，但可以从左下或者右上遍历
		int c = matrix.length-1;
		int l = 0;
		while(c>=0&&l<=matrix[0].length-1) {
			if(matrix[c][l]>target) {
				c--;
			}
			else if(matrix[c][l]<target) {
				l++;
			}
			else if(matrix[c][l]==target) {
				return true;
			}
		}
		return false;
    }
}
