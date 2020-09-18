package leetcode74;

public class SearchMatrix {
	public static boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length==0||matrix[0].length==0) {
			return false;
		}
		int index = 0;
		for(int i=0;i<matrix.length;i++) {
			if(matrix[i][matrix[0].length-1]>=target) {
				index = i;
				break;
			}
		}
		//¶þ·Ö²éÕÒ
		int left = 0;
		int right = matrix[0].length-1;
		
		while(left<=right) {
			int mid = (left+right)/2;
			if(matrix[index][mid]>target) {
				right = mid-1;
			}
			else if(matrix[index][mid]<target) {
				left = mid+1;
			}
			else {
				return true;
			}
		}
		return false;
    }
	public static void main(String[] args) {
		/*int matrix[][] = {{1,   3,  5,  7},
				  {10, 11, 16, 20},
				  {23, 30, 34, 50}};*/
		int matrix[][] = {{1},{3}};
		int target = 1;
		System.out.println(searchMatrix(matrix,target));
	}
}
