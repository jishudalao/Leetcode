package moveMatrix;

public class MoveMatrix {
	 public static void rotate(int[][] matrix) {
	        int len = matrix.length;
	        int vlen = matrix.length-1;
	        for(int i=0;i<(len+1)/2;i++) {
	        	for(int j=0;j<len/2;j++) {
	        		int temp1 = matrix[i][j];
	        		int temp2 = matrix[j][vlen-i];
	        		int temp3 = matrix[vlen-i][vlen-j];
	        		int temp4 = matrix[vlen-j][i];
	        		matrix[i][j] = temp4;
	        		matrix[j][vlen-i] = temp1;
	        		matrix[vlen-i][vlen-j] = temp2;
	        		matrix[vlen-j][i] = temp3;
	        		
	        	}
	        }
	    }
	 public void rotates(int[][] matrix) {
		 int n = matrix.length;
		    for (int i = 0; i < (n + 1) / 2; i ++) {
		      for (int j = 0; j < n / 2; j++) {
		        int temp = matrix[n - 1 - j][i];
		        matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
		        matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
		        matrix[j][n - 1 - i] = matrix[i][j];
		        matrix[i][j] = temp; 
		      }
		    }

		
		  }

		
}
