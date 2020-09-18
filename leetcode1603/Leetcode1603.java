package leetcode1603;


public class Leetcode1603 {
	//翻数据结构书
	boolean f = true;
	public boolean isBalanced(TreeNode root) {
		backtrack(root);
		return f;
    }

	private int backtrack(TreeNode root) {
		if(root==null) {
			return 0;
		}
		int left = backtrack(root.left) ;
		int right = backtrack(root.right);
		if(Math.abs(left-right)>1) {
			f = false;
		}
		return Math.max(left,right )+1;
	}
}
class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
